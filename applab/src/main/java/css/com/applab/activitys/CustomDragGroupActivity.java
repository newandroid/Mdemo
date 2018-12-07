package css.com.applab.activitys;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import css.com.applab.R;
import css.com.applab.view.RoomCustomView;

public class CustomDragGroupActivity extends AppCompatActivity {
    MyImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RoomCustomView customView = new RoomCustomView(this);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        customView.setLayoutParams(lp);
        setContentView(customView);
        iv = new MyImageView(this);
        iv.setImageResource(R.mipmap.ic_launcher);
        iv.performClick();
        customView.addView(iv);
        ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        iv.setLayoutParams(layoutParams);

        initEvent();
    }

    void initEvent() {
        //        iv.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                startDrag(v);
//                return false;
//            }
//        });
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    startDrag(v);
                    return true;
                }
                return false;
            }
        });
    }

    void startDrag(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "nothing");
        ClipData data = ClipData.newIntent("value", intent);
        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(view);
        view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            view.startDragAndDrop(data, myShadow, null, 0);
        } else {
            view.startDrag(data, myShadow, null, 0);
        }
    }

    static class MyImageView extends AppCompatImageView {

        public MyImageView(Context context) {
            super(context);
        }

        public MyImageView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        public boolean performClick() {
            return super.performClick();
        }
    }
}
