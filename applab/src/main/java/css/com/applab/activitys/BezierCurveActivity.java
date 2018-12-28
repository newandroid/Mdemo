package css.com.applab.activitys;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import css.com.applab.view.BezierCurveView;

public class BezierCurveActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BezierCurveView bezierCurveView = new BezierCurveView(this);
        setContentView(bezierCurveView);
    }
}
