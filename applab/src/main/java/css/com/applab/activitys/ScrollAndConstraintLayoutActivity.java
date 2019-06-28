package css.com.applab.activitys;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import css.com.applab.R;
import css.com.applab.utils.InputMethodUtils;

/**
 * 想通了，不要用居中的那种属性，用对齐属性
 */
public class ScrollAndConstraintLayoutActivity extends AppCompatActivity {
    ScrollView scrollView;
    Button btn;
    View root;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scroll_and_constraint_layout);
        setContentView(R.layout.activity_single_button);
//        btn = findViewById(R.id.btn);
//        root = findViewById(R.id.root);
//        btn.setOnClickListener(v -> {
//            showPP();
//        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (popupWindow != null) popupWindow.dismiss();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {

        }
    }

    private void showPP() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.activity_scroll_and_constraint_layout, null);
        if (contentView == null) {
            System.out.println("contentView null");
            return;
        }
        System.out.println("ScrollAndConstraintLayoutActivity.showPP");
        popupWindow = new PopupWindow(contentView);
        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(this, android.R.color.transparent));
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.showAtLocation(root, Gravity.BOTTOM, 0, 0);
        scrollView = contentView.findViewById(R.id.scrollView);
        if (scrollView == null) {
            System.out.println("scrollView null");
            return;
        }
//        scrollView.setMinimumHeight(ScreenUtils.dip2px(this, 550));
        scrollView.post(() -> {
            System.out.println("height:" + scrollView.getHeight());
        });
    }

    public void show(View view) {
        InputMethodUtils.showOrHideInputMethod(this, view, true);
    }
}
