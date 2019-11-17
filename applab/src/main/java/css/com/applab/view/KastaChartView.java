package css.com.applab.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * create by css on 2019/3/20
 */
public class KastaChartView extends View {
    private int totalWidth = 0;
    private int totalHeight = 0;
    private Paint outLinePaint = new Paint();
    private Paint pointPaint = new Paint();
    private Paint pointLinePaint = new Paint();
    private Paint pointDottedLinePaint = new Paint();
    private Path pointDottedLinePath = new Path();
    private List<Point> points = new ArrayList<>();
    float[] linePoint;
    /**
     * dp
     */
    private static final int MIN_WIDTH = 100;
    /**
     * dp
     */
    private static final int MIN_HEIGHT = 100;

    public KastaChartView(Context context) {
        super(context);
        init();
    }

    public KastaChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KastaChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        randomPoints();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, totalWidth, totalHeight, outLinePaint);
        canvas.drawLines(linePoint, pointLinePaint);
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            canvas.drawCircle(point.x, point.y,dip2px(5),pointPaint);
            pointDottedLinePath.moveTo(point.x,point.y);
            pointDottedLinePath.lineTo(point.x,totalHeight);
//            canvas.drawLine(point.x,point.y,point.x,totalHeight,pointDottedLinePaint);
        }
        canvas.drawPath(pointDottedLinePath,pointDottedLinePaint);
    }

    private void init() {
        outLinePaint.setColor(Color.parseColor("#28292a"));
        outLinePaint.setStrokeWidth(dip2px(5));
        outLinePaint.setStyle(Paint.Style.STROKE);

        pointPaint.setColor(Color.parseColor("#28292a"));
        pointPaint.setStrokeWidth(dip2px(5));

        pointLinePaint.setColor(Color.parseColor("#28292a"));
        pointLinePaint.setStrokeWidth(dip2px(2));
        pointLinePaint.setStrokeJoin(Paint.Join.ROUND);
        pointLinePaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        pointDottedLinePaint.setStyle(Paint.Style.STROKE);
        pointDottedLinePaint.setAntiAlias(true);
        pointDottedLinePaint.setStrokeWidth(dip2px(2));
        pointDottedLinePaint.setColor(Color.parseColor("#28292a"));
        //绘制长度为4的实线后再绘制长度为4的空白区域，0位间隔
        pointDottedLinePaint.setPathEffect(new DashPathEffect(new float[]{dip2px(2.5f),dip2px(4)},0));
    }

    private int dip2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private void randomPoints() {
        points.clear();
        for (int i = 0; i < 10; i++) {
            Point point = new Point();
            point.x = (int) (totalWidth * Math.random());
            point.y = (int) (totalHeight * Math.random());
            points.add(point);
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });
        for (Point point : points) {
            System.out.print("[x:" + point.x + " y:" + point.y + "]");
            System.out.print("  ");
        }
        System.out.println();
        linePoint = new float[(points.size() - 1) * 4];
        for (int i = 0; i < points.size() - 1; i++) {
            Point pointStart = points.get(i);
            linePoint[i * 4] = pointStart.x;
            linePoint[i * 4 + 1] = pointStart.y;
            Point pointEnd = points.get(i + 1);
            linePoint[i * 4 + 2] = pointEnd.x;
            linePoint[i * 4 + 3] = pointEnd.y;
        }
        for (float v : linePoint) {
            System.out.print(v + " ");
        }
        System.out.println();
    }


}
