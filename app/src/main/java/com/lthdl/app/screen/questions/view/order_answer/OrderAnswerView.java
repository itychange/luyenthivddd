package com.lthdl.app.screen.questions.view.order_answer;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lthdl.app.R;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.questions.event.OnEventAnswerModified;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;
import com.lthdl.app.screen.questions.view.order_answer.adapter.MyAdapterRecyclerView;
import com.lthdl.app.screen.questions.view.order_answer.adapter.MyItemTouchHelperCallback;
import com.lthdl.app.screen.questions.view.order_answer.adapter.OrderAnswerItem;
import com.lthdl.app.screen.questions.view.order_answer.interfaces.CallbackItemTouch;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrderAnswerView extends FrameLayout
        implements CallbackItemTouch {
    public static final String CLASS_NAME = " OrderAnswerView ";
    List<Integer> correctOrder = new ArrayList();
    List<String> data = new ArrayList();
    List<Integer> indexs = new ArrayList();
    MyAdapterRecyclerView myAdapterRecyclerView;

    @Bind(R.id.rcvOrderAnswer)
    RecyclerView rcvOrderAnswer;

    @Bind(R.id.tvOrderQuestion)
    TextView tvOrderQuestion;

    public OrderAnswerView(Context paramContext) {
        super(paramContext);
        init();
    }

    public OrderAnswerView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public OrderAnswerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.question_order_answer_view, this, true);
        ButterKnife.bind(this);
    }

    public void checkAnswer() {
        int i = 0;
        while (i < this.indexs.size()) {
            (this.myAdapterRecyclerView.getOrderAnswerItems().get(i)).setIndex(this.indexs.get(i));
            i += 1;
        }
        Object localObject = this.myAdapterRecyclerView.getOrderAnswerItems().iterator();
        while (((Iterator) localObject).hasNext()) {
            if(((OrderAnswerItem) ((Iterator) localObject).next()).checkAnswer())
            {
                OnEventOneQuestionComplete localOnEventOneQuestionComplete = new OnEventOneQuestionComplete();
                EventBus.getDefault().post(localOnEventOneQuestionComplete);
            }
        }
    }

    public void initData() {
        this.data.add("3");
        this.data.add("2");
        this.data.add("5");
        this.data.add("4");
        this.data.add("0");
        this.data.add("1");
        this.correctOrder.add(3/*Integer.valueOf(3)*/);
        this.correctOrder.add(2);
        this.correctOrder.add(5);
        this.correctOrder.add(4);
        this.correctOrder.add(0);
        this.correctOrder.add(1);
        int i = 0;
        while (i < this.data.size()) {
            this.indexs.add(i/*Integer.valueOf(i)*/);
            i += 1;
        }
        this.rcvOrderAnswer.setLayoutManager(new LinearLayoutManager(getContext()));
        this.myAdapterRecyclerView = new MyAdapterRecyclerView(this.data, this.correctOrder, getContext());
        this.rcvOrderAnswer.setAdapter(this.myAdapterRecyclerView);
        new ItemTouchHelper(new MyItemTouchHelperCallback(this)).attachToRecyclerView(this.rcvOrderAnswer);
    }

    public void itemTouchOnMove(View paramView, int paramInt1, int paramInt2) {
//        Log.e(Constant.TAG, CLASS_NAME + "itemTouchOnMove()->start");
        Collections.swap(this.myAdapterRecyclerView.getOrderAnswerItems(), paramInt1, paramInt2);
        this.myAdapterRecyclerView.notifyItemMoved(paramInt1, paramInt2);
        ((OrderAnswerItem) paramView).setIndex(paramInt2);
        EventBus.getDefault().post(new OnEventAnswerModified());
//        Log.e(Constant.TAG, CLASS_NAME + "itemTouchOnMove()->end");
    }
}