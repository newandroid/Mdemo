package css.com.applab.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import css.com.applab.view.CountdownTv;

public class CutDownTvActivity extends AppCompatActivity {
    boolean isStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CountdownTv cutdownTextView = new CountdownTv(this);
        setContentView(cutdownTextView);
        cutdownTextView.setOnClickListener(v -> {
            if (!isStart) {
                cutdownTextView.start();
                isStart = true;
            } else {
                isStart = false;
                cutdownTextView.reset();
            }

        });

    }
}
