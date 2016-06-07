package com.lthdl.app.common.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.lthdl.app.R;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.xml.sax.XMLReader;

public class ResourceTagHandler
        implements TagHandler {
    int answerStart = 0;
    final HashMap<String, String> attributes = new HashMap();
    int clickableStart = 0;
    private Context context;
    String data = "";
    int highlightStart = 0;
    private OnClickableListener listener;

    public ResourceTagHandler(Context paramContext) {
        this.context = paramContext;
    }

    public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader) {
        final Editable localEditable = paramEditable;
        if ("lt_highlight".equalsIgnoreCase(paramString)) {
            if (paramBoolean)
                this.highlightStart = paramEditable.length();
        } else if ("lt_answer".equalsIgnoreCase(paramString)) {
            if (!paramBoolean) {
                Integer localInteger = Integer.valueOf(this.answerStart);
                paramEditable.setSpan(new BackgroundColorSpan(this.context.getResources().getColor(R.color.colorBlank)), localInteger.intValue(), paramEditable.length(), 33);
                paramEditable.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.colorHighlight)), localInteger.intValue(), paramEditable.length(), 33);
            } else {
                this.answerStart = paramEditable.length();
            }
        }
        if ("lt_clickable".equalsIgnoreCase(paramString)) {
            if (!paramBoolean) {
                paramEditable.setSpan(new ClickableSpan() {
                    public void onClick(View paramView) {
                        if (ResourceTagHandler.this.listener != null) {
                            Spanned localSpanned = (Spanned) ((TextView) paramView).getText();
                            String localStr = localSpanned.subSequence(localSpanned.getSpanStart(this), localSpanned.getSpanEnd(this)).toString();
                            ResourceTagHandler.this.listener.onTagClick(localStr, null, ResourceTagHandler.this.clickableStart, ResourceTagHandler.this.attributes);
                        }
                    }
                }, clickableStart, paramEditable.length(), 33);
                paramEditable.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.colorClickable)), clickableStart, paramEditable.length(), 33);
            } else {
                this.clickableStart = paramEditable.length();
                processAttributes(paramXMLReader);
            }
        }
    }

    public HashMap<String, String> processAttributes(XMLReader paramXMLReader) {
        try {
            Field elementField = paramXMLReader.getClass().getDeclaredField("theNewElement");
            elementField.setAccessible(true);
            Object element = elementField.get(paramXMLReader);
            Field attsField = element.getClass().getDeclaredField("theAtts");
            attsField.setAccessible(true);
            Object atts = attsField.get(element);
            Field dataField = atts.getClass().getDeclaredField("data");
            dataField.setAccessible(true);
            String[] data = (String[]) dataField.get(atts);
            Field lengthField = atts.getClass().getDeclaredField("length");
            lengthField.setAccessible(true);
            int len = (Integer) lengthField.get(atts);
            /**
             * MSH: Look for supported attributes and add to hash map.
             * This is as tight as things can get :)
             * The data index is "just" where the keys and values are stored.
             */
            for (int i = 0; i < len; i++)
                attributes.put(data[i * 5 + 1], data[i * 5 + 4]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.attributes;
    }

    public ResourceTagHandler setOnClickableListener(OnClickableListener paramOnClickableListener) {
        this.listener = paramOnClickableListener;
        return this;
    }

    public static abstract interface OnClickableListener {
        public abstract void onTagClick(String paramString, Editable paramEditable, Integer paramInteger, HashMap<String, String> paramHashMap);
    }
}