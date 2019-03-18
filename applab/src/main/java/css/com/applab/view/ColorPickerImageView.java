package css.com.applab.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.lang.ref.WeakReference;

import androidx.appcompat.widget.AppCompatImageView;
import css.com.applab.utils.ScreenUtils;

/**
 * Created by Administrator on 2016/6/18.
 */
public class ColorPickerImageView extends AppCompatImageView {
    private final Point iconLastPoint;
    private Context mContext;
    private ShapeDrawable shapeDrawable;
    private int followIconRadius = 0;
    private ColorListener listener;
    private final static int WHAT_SEND_TO_DEVICE = 1;

    private MyHander mHandle = new MyHander(this);

    private static class MyHander extends Handler {
        WeakReference<ColorPickerImageView> viewWeakReference;

        MyHander(ColorPickerImageView view) {
            super();
            viewWeakReference = new WeakReference<>(view);
        }

        @Override
        public void handleMessage(Message msg) {
            if (viewWeakReference.get() == null) return;
            ColorPickerImageView imageView = viewWeakReference.get();
            switch (msg.what) {
                case WHAT_SEND_TO_DEVICE:
                    int rgbPixel = msg.arg1;
                    imageView.sendToDevice(rgbPixel);
                    break;
            }
        }
    }

    public ColorPickerImageView(Context context) {
        this(context, null);
    }

    public ColorPickerImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorPickerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        followIconRadius = ScreenUtils.dip2px(getContext(), 5);
        mContext = context;
        iconLastPoint = new Point();
        shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicWidth(followIconRadius);
        shapeDrawable.setIntrinsicHeight(followIconRadius);
        Paint shapeDrawablePaint = shapeDrawable.getPaint();
        shapeDrawablePaint.setStrokeWidth(1);
        shapeDrawablePaint.setStyle(Paint.Style.STROKE);
        shapeDrawablePaint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        shapeDrawable.setBounds(iconLastPoint.x - followIconRadius / 2, iconLastPoint.y - followIconRadius / 2,
                iconLastPoint.x + followIconRadius / 2, iconLastPoint.y + followIconRadius / 2);
        shapeDrawable.draw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
//                Bitmap mbm = ((BitmapDrawable) getDrawable()).getBitmap();
        Bitmap mbm = getViewBitmap(ColorPickerImageView.this);
        //面积过滤
        int centerX = mbm.getWidth() / 2;
        int centerY = centerX;
        int radius = centerX;
        if (x < 0 || y < 0 || x > mbm.getWidth() || y > mbm.getHeight()
                || (((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY)) > radius * radius))
            return true;
        int rgbPixel = mbm.getPixel(x, y);
        sendToDevice(rgbPixel);
//                Message msg = mHandle.obtainMessage();
//                msg.what = WHAT_SEND_TO_DEVICE;
//                msg.arg1 = rgbPixel;
//                mHandle.removeMessages(WHAT_SEND_TO_DEVICE);
//                mHandle.sendMessageDelayed(msg,100);
        if (event.getAction() == MotionEvent.ACTION_MOVE) {//如果拖动
            iconLastPoint.set((int) event.getX(), (int) event.getY());
            invalidate();
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {//如果点击
            int mov_x = (int) event.getX();
            int mov_y = (int) event.getY();
            iconLastPoint.set(mov_x, mov_y);
            invalidate();
        }
        return true;
    }

    private Bitmap getViewBitmap(View v) {
        v.clearFocus(); //
        v.setPressed(false); //
        // 能画缓存就返回false
        boolean willNotCache = v.willNotCacheDrawing();
        v.setWillNotCacheDrawing(false);
        int color = v.getDrawingCacheBackgroundColor();
        v.setDrawingCacheBackgroundColor(0);
        if (color != 0) {
            v.destroyDrawingCache();
        }
        v.buildDrawingCache();
        Bitmap cacheBitmap = v.getDrawingCache();
        if (cacheBitmap == null) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
        // Restore the view
        v.destroyDrawingCache();
        v.setWillNotCacheDrawing(willNotCache);
        v.setDrawingCacheBackgroundColor(color);
        return bitmap;
    }

    private void sendToDevice(int rgbPixel) {
        if (listener != null) listener.onColor(rgbPixel);
//        Log.i("Value", "x: " + x + "  y:" + y);
//        Log.i("Value", "pixel: " + Integer.toHexString(rgbPixel));
//        Log.i("Value", "rgb: r---" + Color.red(rgbPixel) + "  g-- " + Color.green(rgbPixel) + " b--" + Color.blue(rgbPixel));
//        byte[] beforHandle = ApplicationManager.getInstance().getGlobalCmd();
//        byte[] sendCmd = LightingXDataUtil.setColorOnlyRGB(Color.red(rgbPixel), Color.green(rgbPixel), Color.blue(rgbPixel), beforHandle);
//        RxBleHelper.getInstance(mContext.getApplicationContext()).write(sendCmd);
    }

    public void setListener(ColorListener listener) {
        this.listener = listener;
    }

    public interface ColorListener {
        void onColor(int rgbPixel);
    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        getParent().requestDisallowInterceptTouchEvent(true);
//        return super.dispatchTouchEvent(event);
//    }
}
