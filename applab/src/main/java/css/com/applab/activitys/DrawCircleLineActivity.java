package css.com.applab.activitys;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import css.com.applab.view.DrawCircleLineView;

public class DrawCircleLineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawCircleLineView drawCircleLineView = new DrawCircleLineView(this);
        setContentView(drawCircleLineView);
    }
}
