package css.com.applab.activitys;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import css.com.applab.R;

public class ChartViewActivity extends AppCompatActivity {
    LineChart line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_view);
        line = findViewById(R.id.line);
        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < 8; i++) {

            float val = (float) (Math.random() * 100);
            values.add(new Entry(i, val));
        }
        LineDataSet lineDataSet = new LineDataSet(values, "");
        LineData lineData = new LineData(lineDataSet);
        line.setData(lineData);
        Legend legend = line.getLegend();
        legend.setForm(Legend.LegendForm.EMPTY);
    }
}
