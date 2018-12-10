package css.com.applab.activitys;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import css.com.applab.R;
import css.com.applab.view.RoomCustomView;

public class CustomDragGroupActivity extends AppCompatActivity {
    MyImageView iv;
    RoomCustomView customView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customView = new RoomCustomView(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        customView.setLayoutParams(lp);
        setContentView(customView);
        iv = new MyImageView(this);
        iv.setImageResource(R.mipmap.ic_launcher);
//        iv.performClick();
        customView.addView(iv);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) iv.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.leftMargin = 200;
        layoutParams.topMargin = 200;
        iv.setLayoutParams(layoutParams);
//        iv.layout(200,200,389,389);//189
        initEvent();
//        initPureTouchEvent();
    }

    void initEvent() {
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    startDrag(v);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                }
                return false;
            }
        });
        customView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        System.out.println("ACTION_DRAG_STARTED");
                        return true;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        System.out.println("ACTION_DRAG_LOCATION");
                        return true;
                    case DragEvent.ACTION_DROP:
                        System.out.println("ACTION_DROP");
                        if (event.getResult()) {
                            Toast.makeText(CustomDragGroupActivity.this, "The drop was handled.", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(CustomDragGroupActivity.this, "The drop didn't work.", Toast.LENGTH_LONG).show();

                        }

                        int w = iv.getMeasuredWidth();
                        int h = iv.getMeasuredHeight();
                        float moveX = event.getX();
                        float moveY = event.getY();
                        iv.layout((int) (moveX - w / 2), (int) (moveY - h / 2), (int) (moveX + w / 2), (int) (moveY + h / 2));
                        System.out.println("x:"+event.getX()+" y:"+event.getY());
                        return true;
                    case DragEvent.ACTION_DRAG_ENDED:
                        System.out.println("ACTION_DRAG_ENDED");

                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        System.out.println("ACTION_DRAG_ENTERED");
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        System.out.println("ACTION_DRAG_EXITED");
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
