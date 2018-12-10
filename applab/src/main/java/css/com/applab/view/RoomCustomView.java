package css.com.applab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Map;

public class RoomCustomView extends FrameLayout {
    private Map<ImageView, ChildViewBean> maps;

    public RoomCustomView(Context context) {
        super(context);
    }

    public RoomCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoomCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
//        final int count = getChildCount();
//        for (int i = 0; i < count; i++) {
//            final View child = getChildAt(i);
//            final LayoutParams lp = (LayoutParams) child.getLayoutParams();
//            child.layout();
//        }
    }

    public void child2ParentTouchEvent(View v, MotionEvent event) {
        int w = v.getMeasuredWidth();
        int h = v.getMeasuredHeight();
        float moveX = event.getX();
        float moveY = event.getY();


        int action = event.getAction();
        System.out.println("action:" + action);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("x:" + moveX + " y:" + moveY);
                v.layout((int) (moveX - w / 2), (int) (moveY - h / 2), (int) (moveX + w / 2), (int) (moveY + h / 2));
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
    }

    public static final class ChildViewBean {
        private int childX;
        private int childY;

        private int childW;
        private int childH;

        public int getChildX() {
            return childX;
        }

        public void setChildX(int childX) {
            this.childX = childX;
        }

        public int getChildY() {
            return childY;
        }

        public void setChildY(int childY) {
            this.childY = childY;
        }
    }
}
