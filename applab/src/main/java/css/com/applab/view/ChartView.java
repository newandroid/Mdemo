package css.com.applab.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import org.jetbrains.annotations.Nullable;


/**
 * create by css on 2019/3/20
 */
public class ChartView extends View {
    private int totalWidth = 0;
    private int totalHeight = 0;
    /**
     * dp
     */
    private static final int MIN_WIDTH = 100;
    /**
     * dp
     */
    private static final int MIN_HEIGHT = 100;

    public ChartView(Context context) {
        super(context);
        init();
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);//如果不写这个会怎么样
        //这里方法套路都是一样，不管三七 二十一，上来就先把mode 和 size 获取出来。
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //重点来了，判断模式，这个模式哪里来的呢，就是在编写xml的时候，设置的layout_width
        switch (widthMode) {
            //如果是AT_MOST，不能超过父View的宽度, wrap_content 走的是这里
            case MeasureSpec.AT_MOST:
                totalWidth = dip2px(MIN_WIDTH);
                break;
            //如果是精确的，好说，是多少，就给多少, match_parent, 40dp 走的是这里
            case MeasureSpec.EXACTLY:
                totalWidth = widthSize;
                break;
            //这种情况，纯属在这里打酱油的，可以不考虑
            case MeasureSpec.UNSPECIFIED://我是路过的
                totalWidth = widthSize;
                break;
        }

        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                totalHeight = dip2px(MIN_HEIGHT);
                break;
            case MeasureSpec.EXACTLY:
                totalHeight = heightSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                totalHeight = heightSize;
                break;
        }
        //最后不要忘记了，调用父类的测量方法
        setMeasuredDimension(totalWidth, totalHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }

    private void init() {

    }

    private int dip2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }



}
