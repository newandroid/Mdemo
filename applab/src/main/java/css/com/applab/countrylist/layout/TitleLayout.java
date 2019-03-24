package css.com.applab.countrylist.layout;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import css.com.applab.R;

public class TitleLayout {
    static final int inHeight = 74;
    static final int lineHeight = 2;

    public TitleLayout() {
    }

    static LinearLayout create(Context context, boolean isSearch) {
        SizeHelper.prepare(context);
        LayoutParams params = new LayoutParams(-1, -2);
        LinearLayout titleLayout = new LinearLayout(context);
        titleLayout.setLayoutParams(params);
        titleLayout.setOrientation(1);
        View topLine = new View(context);
        LayoutParams topLineParams = new LayoutParams(-1, SizeHelper.fromPxWidth(1));
        topLine.setLayoutParams(topLineParams);
        topLine.setBackgroundColor(-12236213);
        titleLayout.addView(topLine);
        if (isSearch) {
            createSearch(titleLayout, context);
        } else {
            createNormal(titleLayout, context);
        }

        View bottomLine = new View(context);
        LayoutParams bottomLineParams = new LayoutParams(-1, SizeHelper.fromPxWidth(2));
        bottomLine.setLayoutParams(bottomLineParams);
        bottomLine.setBackgroundColor(-15066083);
        titleLayout.addView(bottomLine);
        return titleLayout;
    }

    private static void createNormal(LinearLayout titleLayout, Context context) {
        int height = SizeHelper.fromPx(74);
        LayoutParams inParams = new LayoutParams(-1, height);
        LinearLayout inLayout = new LinearLayout(context);
        inLayout.setLayoutParams(inParams);
        inLayout.setBackgroundColor(-13617865);
        LayoutParams backParams = new LayoutParams(-2, -1);
        LinearLayout backLayout = new LinearLayout(context);
        backLayout.setLayoutParams(backParams);
        backLayout.setId(117506049);
        backLayout.setPadding(SizeHelper.fromPx(14), 0, SizeHelper.fromPx(26), 0);
        LayoutParams arrowParams = new LayoutParams(SizeHelper.fromPx(15), SizeHelper.fromPx(25));
        arrowParams.gravity = 16;
        arrowParams.rightMargin = SizeHelper.fromPx(14);
        ImageView backArrow = new ImageView(context);
        backArrow.setLayoutParams(arrowParams);
        int res = R.getBitmapRes(context, "smssdk_back_arrow");
        backArrow.setBackgroundResource(res);
        LayoutParams logoParams = new LayoutParams(SizeHelper.fromPx(30), SizeHelper.fromPx(44));
        logoParams.gravity = 16;
        logoParams.rightMargin = SizeHelper.fromPx(14);
        ImageView backLogo = new ImageView(context);
        backLogo.setLayoutParams(logoParams);
        res = R.getBitmapRes(context, "smssdk_sharesdk_icon");
        backLogo.setBackgroundResource(res);
        backLayout.addView(backArrow);
        backLayout.addView(backLogo);
        inLayout.addView(backLayout);
        LayoutParams titleParams = new LayoutParams(-2, -2);
        titleParams.gravity = 16;
        TextView title = new TextView(context);
        title.setLayoutParams(titleParams);
        title.setId(117506050);
        title.setTextColor(-3158065);
        title.setTextSize(0, (float)SizeHelper.fromPx(32));
        inLayout.addView(title);
        titleLayout.addView(inLayout);
    }

    private static void createSearch(LinearLayout titleLayout, Context context) {
        int height = SizeHelper.fromPx(74);
        LayoutParams inParams = new LayoutParams(-1, height);
        LinearLayout inLayout = new LinearLayout(context);
        inLayout.setLayoutParams(inParams);
        inLayout.setBackgroundColor(-13617865);
        inLayout.setBaselineAligned(false);
        LayoutParams backParams = new LayoutParams(-2, -1);
        LinearLayout backLayout = new LinearLayout(context);
        backLayout.setLayoutParams(backParams);
        backLayout.setId(117506049);
        backLayout.setPadding(SizeHelper.fromPx(14), 0, SizeHelper.fromPx(26), 0);
        LayoutParams arrowParams = new LayoutParams(SizeHelper.fromPx(15), SizeHelper.fromPx(25));
        arrowParams.gravity = 16;
        arrowParams.rightMargin = SizeHelper.fromPxWidth(14);
        ImageView backArrow = new ImageView(context);
        backArrow.setLayoutParams(arrowParams);
        int res = R.getBitmapRes(context, "smssdk_back_arrow");
        backArrow.setBackgroundResource(res);
        LayoutParams logoParams = new LayoutParams(SizeHelper.fromPx(30), SizeHelper.fromPx(44));
        logoParams.gravity = 16;
        logoParams.rightMargin = SizeHelper.fromPx(14);
        ImageView backLogo = new ImageView(context);
        backLogo.setLayoutParams(logoParams);
        res = R.getBitmapRes(context, "smssdk_sharesdk_icon");
        backLogo.setBackgroundResource(res);
        backLayout.addView(backArrow);
        backLayout.addView(backLogo);
        inLayout.addView(backLayout);
        LayoutParams innerTitleParams = new LayoutParams(-2, -1, 1.0F);
        LinearLayout innerTitleLayout = new LinearLayout(context);
        innerTitleLayout.setLayoutParams(innerTitleParams);
        innerTitleLayout.setId(117506051);
        inLayout.addView(innerTitleLayout);
        LayoutParams titleParams = new LayoutParams(0, -2, 1.0F);
        titleParams.gravity = 16;
        TextView title = new TextView(context);
        title.setLayoutParams(titleParams);
        title.setId(117506050);
        res = R.getStringRes(context, "smssdk_choose_country");
        title.setText(res);
        title.setTextColor(-3158065);
        title.setTextSize(0, (float)SizeHelper.fromPx(32));
        innerTitleLayout.addView(title);
        LayoutParams searchImageParams = new LayoutParams(SizeHelper.fromPx(70), -2);
        searchImageParams.gravity = 16;
        ImageView searchImage = new ImageView(context);
        searchImage.setLayoutParams(searchImageParams);
        searchImage.setId(117506052);
        res = R.getBitmapRes(context, "smssdk_search_icon");
        searchImage.setImageResource(res);
        searchImage.setScaleType(ScaleType.CENTER_INSIDE);
        searchImage.setPadding(SizeHelper.fromPx(15), 0, SizeHelper.fromPx(15), 0);
        innerTitleLayout.addView(searchImage);
        LayoutParams innerSearchParams = new LayoutParams(-2, -2, 1.0F);
        innerSearchParams.gravity = 16;
        innerSearchParams.rightMargin = SizeHelper.fromPx(18);
        LinearLayout innerSearchLayout = new LinearLayout(context);
        innerSearchLayout.setLayoutParams(innerSearchParams);
        innerSearchLayout.setId(117506053);
        res = R.getBitmapRes(context, "smssdk_input_bg_focus");
        innerSearchLayout.setBackgroundResource(res);
        innerSearchLayout.setPadding(SizeHelper.fromPx(14), 0, SizeHelper.fromPx(14), 0);
        innerSearchLayout.setVisibility(8);
        inLayout.addView(innerSearchLayout);
        LayoutParams searchIconParams = new LayoutParams(SizeHelper.fromPx(36), SizeHelper.fromPx(36));
        searchIconParams.gravity = 16;
        searchIconParams.rightMargin = SizeHelper.fromPx(8);
        ImageView searchIcon = new ImageView(context);
        searchIcon.setLayoutParams(searchIconParams);
        res = R.getBitmapRes(context, "smssdk_search_icon");
        searchIcon.setImageResource(res);
        searchIcon.setScaleType(ScaleType.CENTER_INSIDE);
        innerSearchLayout.addView(searchIcon);
        LayoutParams identifyParams = new LayoutParams(0, -2, 1.0F);
        identifyParams.gravity = 16;
        EditText identify = new EditText(context);
        identify.setLayoutParams(identifyParams);
        identify.setId(117506054);
        res = R.getStringRes(context, "smssdk_search");
        identify.setHint(res);
        identify.setTextColor(-1);
        identify.setBackgroundDrawable((Drawable)null);
        identify.setSingleLine(true);
        innerSearchLayout.addView(identify);
        LayoutParams clearParams = new LayoutParams(SizeHelper.fromPx(30), SizeHelper.fromPx(30));
        clearParams.gravity = 16;
        clearParams.rightMargin = SizeHelper.fromPxWidth(5);
        ImageView clear = new ImageView(context);
        clear.setLayoutParams(clearParams);
        clear.setId(117571589);
        res = R.getBitmapRes(context, "smssdk_clear_search");
        clear.setImageResource(res);
        clear.setScaleType(ScaleType.FIT_CENTER);
        innerSearchLayout.addView(clear);
        titleLayout.addView(inLayout);
    }
}
