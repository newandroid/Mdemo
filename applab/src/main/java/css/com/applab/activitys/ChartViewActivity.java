package css.com.applab.activitys;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

import css.com.applab.R;

public class ChartViewActivity extends AppCompatActivity {
    LineChart line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_view);
        line = findViewById(R.id.line);
        initChart();

    }

    private void initChart() {



        Legend legend = line.getLegend();
        legend.setForm(Legend.LegendForm.EMPTY);

        Description description = line.getDescription();
        if (description != null) {
            description.setText("");
        }


        XAxis xAxis = line.getXAxis();
//        xAxis.setEnabled(false);//把整个x轴都取消了，但是我想要bottom的x轴
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return xlabels[(int) value];
            }
        });
        xAxis.setDrawPositiveArrowHead(true);

        YAxis axisRight = line.getAxisRight();
        axisRight.setEnabled(false);
        YAxis axisLeft = line.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setDrawPositiveArrowHead(true);
    }

    String[] xlabels = new String[]{"M", "T", "W", "T", "F", "S", "S"};

    public void oho(View view) {
        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            float val = (float) (Math.random() * 100);
            values.add(new Entry(i, val));
        }
        LineDataSet lineDataSet = new LineDataSet(values, "");
        LineData lineData = new LineData(lineDataSet);
        line.setData(lineData);
        line.invalidate();
    }
}
