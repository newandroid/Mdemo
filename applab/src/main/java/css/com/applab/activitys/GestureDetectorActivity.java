package css.com.applab.activitys;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GestureDetectorCompat;

public class GestureDetectorActivity extends AppCompatActivity {
    private static final String TAG = "GestureDetectorActivity";
    MyButton button;
    GestureDetectorCompat gestureDetectorCompat;
    private boolean isScrolling = false;
    Listener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gesture_detector);
        button = new MyButton(this);
        setContentView(button);
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        button.setLayoutParams(layoutParams);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);
        listener = new Listener() {
            @Override
            public void onDragStart(View iv) {
                Log.d(TAG, "onDragStart() called with: iv = [" + iv + "]");
            }

            @Override
            public void onClick(View iv) {
                Log.d(TAG, "onClick() called with: iv = [" + iv + "]");
            }

            @Override
            public void onLongClick(View iv) {
                Log.d(TAG, "onLongClick() called with: iv = [" + iv + "]");
            }
        };
    }

    GestureDetector.OnGestureListener gestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(TAG, "onDown() called with: e = [" + e + "]");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d(TAG, "onShowPress() called with: e = [" + e + "]");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d(TAG, "onSingleTapUp() called with: e = [" + e + "]");
            listener.onClick(button);
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG, "onScroll() called with: e1 = [" + e1 + "], e2 = [" + e2 + "], distanceX = [" + distanceX + "], distanceY = [" + distanceY + "]");
            if (!isScrolling) {
                isScrolling = true;
                listener.onDragStart(button);
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.d(TAG, "onLongPress() called with: e = [" + e + "]");
            listener.onLongClick(button);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG, "onFling() called with: e1 = [" + e1 + "], e2 = [" + e2 + "], velocityX = [" + velocityX + "], velocityY = [" + velocityY + "]");
            return false;
        }
    };

    class MyButton extends AppCompatButton {

        public MyButton(Context context) {
            super(context);
        }

        public MyButton(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (gestureDetectorCompat.onTouchEvent(event)) {
                return true;
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                isScrolling = false;
            }
            return super.onTouchEvent(event);
        }

        @Override
        public boolean performClick() {
            return true;
        }
    }

    public interface Listener {
        void onDragStart(View iv);

        void onClick(View iv);

        void onLongClick(View iv);
    }


}
