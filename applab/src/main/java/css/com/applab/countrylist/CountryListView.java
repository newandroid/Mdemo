package css.com.applab.countrylist;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import css.com.applab.R;
import css.com.applab.countrylist.layout.SizeHelper;

public class CountryListView extends RelativeLayout implements OnTouchListener {
    private cn.smssdk.gui.GroupListView lvContries;
    private TextView tvScroll;
    private LinearLayout llScroll;
    private CountryAdapter adapter;

    public CountryListView(Context context) {
        super(context);
        this.init(context);
    }

    public CountryListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public CountryListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init(context);
    }

    private void init(Context context) {
        SizeHelper.prepare(context);
        this.lvContries = new cn.smssdk.gui.GroupListView(context);
        this.lvContries.setDividerHeight(SizeHelper.fromPxWidth(1));
        int resId = R.getBitmapRes(context, "smssdk_cl_divider");
        if (resId > 0) {
            this.lvContries.setDivider(context.getResources().getDrawable(resId));
        }

        this.adapter = new CountryAdapter(this.lvContries);
        this.lvContries.setAdapter(this.adapter);
        LayoutParams lpContries = new LayoutParams(-1, -1);
        int dp_9 = SizeHelper.fromPxWidth(12);
        lpContries.setMargins(dp_9, 0, dp_9, 0);
        this.addView(this.lvContries, lpContries);
        this.tvScroll = new TextView(context);
        resId = R.getColorRes(context, "smssdk_white");
        if (resId > 0) {
            this.tvScroll.setTextColor(context.getResources().getColor(resId));
        }

        resId = R.getBitmapRes(context, "smssdk_country_group_scroll_down");
        if (resId > 0) {
            this.tvScroll.setBackgroundResource(resId);
        }

        this.tvScroll.setTextSize(0, (float)SizeHelper.fromPxWidth(80));
        this.tvScroll.setTypeface(Typeface.DEFAULT);
        this.tvScroll.setVisibility(8);
        this.tvScroll.setGravity(17);
        int dp_80 = SizeHelper.fromPxWidth(120);
        LayoutParams lp = new LayoutParams(dp_80, dp_80);
        lp.addRule(13);
        this.addView(this.tvScroll, lp);
        this.llScroll = new LinearLayout(context);
        resId = R.getBitmapRes(context, "smssdk_country_group_scroll_up");
        if (resId > 0) {
            this.llScroll.setBackgroundResource(resId);
        }

        this.llScroll.setOrientation(1);
        this.llScroll.setOnTouchListener(this);
        lp = new LayoutParams(-2, -2);
        lp.addRule(11);
        lp.addRule(15);
        lp.rightMargin = SizeHelper.fromPxWidth(7);
        this.addView(this.llScroll, lp);
        this.initScroll(context);
    }

    private void initScroll(Context context) {
        this.llScroll.removeAllViews();
        SizeHelper.prepare(context);
        int size = this.adapter.getGroupCount();
        int dp_3 = SizeHelper.fromPxWidth(6);
        int dp_2 = SizeHelper.fromPxWidth(4);

        for(int i = 0; i < size; ++i) {
            TextView tv = new TextView(context);
            tv.setText(this.adapter.getGroupTitle(i));
            tv.setTextSize(0, (float)SizeHelper.fromPxWidth(18));
            tv.setGravity(17);
            tv.setPadding(dp_3, dp_2, dp_3, dp_2);
            this.llScroll.addView(tv);
        }

    }

    public boolean onTouch(View v, MotionEvent event) {
        float x;
        int resId;
        switch(event.getAction()) {
        case 0:
            resId = R.getBitmapRes(v.getContext(), "smssdk_country_group_scroll_down");
            if (resId > 0) {
                v.setBackgroundResource(resId);
            }

            x = event.getX();
            float y = event.getY();
            ViewGroup vg = (ViewGroup)v;
            this.onScroll(vg, x, y);
            break;
        case 1:
        case 3:
            resId = R.getBitmapRes(v.getContext(), "smssdk_country_group_scroll_up");
            if (resId > 0) {
                v.setBackgroundResource(resId);
            }

            this.tvScroll.setVisibility(8);
            break;
        case 2:
            float x = event.getX();
            x = event.getY();
            ViewGroup vg = (ViewGroup)v;
            this.onScroll(vg, x, x);
        }

        return true;
    }

    public void onScroll(ViewGroup llScroll, float x, float y) {
        int i = 0;

        for(int count = llScroll.getChildCount(); i < count; ++i) {
            TextView v = (TextView)llScroll.getChildAt(i);
            if (x >= (float)v.getLeft() && x <= (float)v.getRight() && y >= (float)v.getTop() && y <= (float)v.getBottom()) {
                this.lvContries.setSelection(i);
                this.tvScroll.setVisibility(0);
                this.tvScroll.setText(v.getText());
                break;
            }
        }

    }

    public void onSearch(String token) {
        this.adapter.search(token);
        this.adapter.notifyDataSetChanged();
        if (this.adapter.getGroupCount() == 0) {
            this.llScroll.setVisibility(8);
        } else {
            this.llScroll.setVisibility(0);
        }

        this.initScroll(this.getContext());
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.lvContries.setOnItemClickListener(listener);
    }

    public String[] getCountry(int group, int position) {
        return this.adapter.getItem(group, position);
    }
}
