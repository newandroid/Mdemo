package css.com.applab.activitys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class ScaleActivity extends AppCompatActivity {
    MyButton myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myButton = new MyButton(this);
        setContentView(myButton);
        ViewGroup.LayoutParams layoutParams = myButton.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        myButton.setLayoutParams(layoutParams);
    }

    private class MyButton extends AppCompatButton {
        Paint p = new Paint();
        private ScaleGestureDetector mScaleDetector;
        GestureDetector g;
        private float mScaleFactor = 1.f;

        public MyButton(Context mContext) {
            super(mContext);
            // View code goes here
            mScaleDetector = new ScaleGestureDetector(mContext, new ScaleListener());
            GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
                public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                        float distanceX, float distanceY) {
                    System.out.println(distanceX+" "+distanceY);
                    scrollTo((int) distanceX, (int) distanceY);
                    return true;
                }
            };
            g = new GestureDetector(getContext(), simpleOnGestureListener);

            p.setColor(Color.BLACK);
        }

        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            // Let the ScaleGestureDetector inspect all events.
            mScaleDetector.onTouchEvent(ev);
            g.onTouchEvent(ev);
            return true;
        }

//        @Override
//        public void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//
//            canvas.drawText("content", 200, 200, p);
//            canvas.save();
//            canvas.scale(mScaleFactor, mScaleFactor);
//            // onDraw() code goes here
//            canvas.restore();
//        }

        private class ScaleListener
                extends ScaleGestureDetector.SimpleOnScaleGestureListener {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                mScaleFactor *= detector.getScaleFactor();

                // Don't let the object get too small or too large.
                mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));
                setScaleX(mScaleFactor);
                setScaleY(mScaleFactor);
//                invalidate();
                return true;
            }
        }


    }
}
