package css.com.applab.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import css.com.applab.R;

/**
 * 想通了，不要用居中的那种属性，用对齐属性
 */
public class ScrollAndConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_and_constraint_layout);
    }
}
