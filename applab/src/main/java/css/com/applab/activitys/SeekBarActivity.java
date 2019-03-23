package css.com.applab.activitys;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.warkiz.tickseekbar.OnSeekChangeListener;
import com.warkiz.tickseekbar.SeekParams;
import com.warkiz.tickseekbar.TickSeekBar;
import com.warkiz.widget.IndicatorSeekBar;

import androidx.appcompat.app.AppCompatActivity;
import css.com.applab.R;

public class SeekBarActivity extends AppCompatActivity {
    private static final String TAG = "SeekBarActivity";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_seek_bar);
//        initSeekBar2();
        initSeekBar3();
    }

    private void initSeekBar2() {
        tv = new TextView(SeekBarActivity.this);
        setContentView(R.layout.activity_seek_bar_2);
        final IndicatorSeekBar seekBar2 = findViewById(R.id.seekBar2);
        tv.setText("");
        seekBar2.getIndicator().setTopContentView(tv);
//        seekBar2.setOnSeekChangeListener(new OnSeekChangeListener() {
//            @Override
//            public void onSeeking(SeekParams seekParams) {
//                tv.setText("");
//                seekBar2.getIndicator().setTopContentView(tv);
//            }
//
//            @Override
//            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
//
//            }
//        });
    }

    private void initSeekBar3() {
        setContentView(R.layout.activity_seek_bar_3);
        Button button = findViewById(R.id.sbBtn);

        TickSeekBar viewById = findViewById(R.id.speedSb);
        viewById.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {
                Log.d(TAG, "onSeeking() called with: seekParams = [" + " thumbPosition:" + seekParams.tickText + " fromUser:" + seekParams.fromUser + " progress:" + seekParams.progress
                        + " progressFloat:" + seekParams.progressFloat + " thumbPosition:" + seekParams.thumbPosition + "]");
            }

            @Override
            public void onStartTrackingTouch(TickSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(TickSeekBar seekBar) {

            }
        });
        button.setOnClickListener(v -> {
            int result = (int) (Math.random() * 2);
            button.setText(String.valueOf(result));
            viewById.setProgress(result);
        });
    }
}
