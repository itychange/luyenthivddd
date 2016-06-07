package com.lthdl.app.screen.statistic;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.Bind;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.lthdl.app.BaseActivity;
import com.lthdl.app.R;
import com.lthdl.app.common.widget.taskbar.SupportBar;

import java.util.ArrayList;
import java.util.List;

public class StatisticActivity extends BaseActivity {

    @Bind(R.id.mChart)
    BarChart mChart;

    @Bind(R.id.supportBar)
    SupportBar supportBar;

    protected void init() {
        Typeface localTypeface = Typeface.createFromAsset(getAssets(), "font/SourceSansPro-Regular.otf");
        this.mChart.setDrawGridBackground(true);
        Object localObject1 = this.mChart.getXAxis();
        ((XAxis) localObject1).setTypeface(localTypeface);
        ((XAxis) localObject1).setPosition(XAxis.XAxisPosition.BOTTOM);
        ((XAxis) localObject1).setDrawGridLines(false);
        ((XAxis) localObject1).setTextColor(getResources().getColor(R.color.greyLight));
        ((XAxis) localObject1).setXOffset(0.0F);
        localObject1 = this.mChart.getAxisLeft();
        ((YAxis) localObject1).setTypeface(localTypeface);
        ((YAxis) localObject1).setValueFormatter(new LargeValueFormatter());
        ((YAxis) localObject1).setDrawGridLines(true);
        ((YAxis) localObject1).setSpaceTop(30.0F);
        ((YAxis) localObject1).setAxisMinValue(0.0F);
        ((YAxis) localObject1).setAxisMaxValue(10.0F);
        ((YAxis) localObject1).setDrawAxisLine(false);
        this.mChart.getAxisRight().setEnabled(false);
        this.mChart.setDrawBarShadow(false);
        this.mChart.setDrawValueAboveBar(false);
        this.mChart.setDescription("");
        this.mChart.getLegend().setEnabled(false);
        Object localObject4 = new ArrayList();
        Object localObject3 = new ArrayList();
        Object localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        Object localObject5 = new BarEntry(7.0F, 0);
        BarEntry localBarEntry1 = new BarEntry(8.0F, 1);
        BarEntry localBarEntry2 = new BarEntry(9.0F, 2);
        new BarEntry(10.0F, 3);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject5);
        localArrayList.add(localBarEntry1);
        localArrayList.add(localBarEntry2);
        int i = 0;
        while (i < 3) {
            ((ArrayList) localObject4).add(new BarEntry(7.0F, i));
            ((ArrayList) localObject3).add(new BarEntry(8.0F, i));
            ((ArrayList) localObject2).add(new BarEntry(9.0F, i));
            ((ArrayList) localObject1).add(new BarEntry(10.0F, i));
            i += 1;
        }
        localObject4 = new BarDataSet((List) localObject4, "1");
        ((BarDataSet) localObject4).setColor(getResources().getColor(R.color.greenCorrect));
        ((BarDataSet) localObject4).setDrawValues(false);
        ((BarDataSet) localObject4).setBarSpacePercent(2.0F);
        localObject3 = new BarDataSet((List) localObject3, "1");
        ((BarDataSet) localObject3).setColor(getResources().getColor(R.color.yellowWhite));
        ((BarDataSet) localObject3).setDrawValues(false);
        ((BarDataSet) localObject3).setBarSpacePercent(2.0F);
        localObject2 = new BarDataSet((List) localObject2, "1");
        ((BarDataSet) localObject2).setColor(getResources().getColor(R.color.redWrong));
        ((BarDataSet) localObject2).setDrawValues(false);
        ((BarDataSet) localObject2).setBarSpacePercent(2.0F);
        localObject5 = new BarDataSet((List) localObject1, "1");
        ((BarDataSet) localObject5).setColor(getResources().getColor(R.color.redWrong));
        ((BarDataSet) localObject5).setDrawValues(false);
        ((BarDataSet) localObject5).setBarSpacePercent(2.0F);
        localObject1 = new ArrayList();
        ((ArrayList) localObject1).add(localObject4);
        ((ArrayList) localObject1).add(localObject3);
        ((ArrayList) localObject1).add(localObject2);
        ((ArrayList) localObject1).add(localObject5);
        localObject2 = new ArrayList();
        ((ArrayList) localObject2).add("15.10.2015");
        ((ArrayList) localObject2).add("17.10.2015");
        ((ArrayList) localObject2).add("18.10.2015");
        localObject1 = new BarData((List) localObject2, (List) localObject1);
        ((BarData) localObject1).setValueFormatter(new LargeValueFormatter());
        ((BarData) localObject1).setGroupSpace(50.0F);
        ((BarData) localObject1).setValueTypeface(localTypeface);
        this.mChart.setGridBackgroundColor(getResources().getColor(R.color.transparent));
        this.mChart.setData((BarData) localObject1);
        this.mChart.animateXY(2000, 2000);
        this.mChart.invalidate();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.statistic_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_icon_arrowleft);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.bookdetail, paramMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        int i = paramMenuItem.getItemId();
        if (i == R.id.menuSupport) {
            this.supportBar.toggle();
            return true;
        }
        if (i == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(paramMenuItem);
    }
}