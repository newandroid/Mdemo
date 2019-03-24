package css.com.applab.countrylist.layout;


import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import css.com.applab.R;

public class ListviewTitleLayout {
    public ListviewTitleLayout() {
    }

    static RelativeLayout create(Context context) {
        cn.smssdk.gui.layout.SizeHelper.prepare(context);
        RelativeLayout root = new RelativeLayout(context);
        LayoutParams params = new LayoutParams(-1, -1);
        root.setLayoutParams(params);
        TextView title = new TextView(context);
        title.setId(117506050);
        android.widget.RelativeLayout.LayoutParams titleParams = new android.widget.RelativeLayout.LayoutParams(-1, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(40));
        titleParams.topMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(-20);
        title.setLayoutParams(titleParams);
        title.setPadding(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(20), 0, 0, 0);
        title.setLineSpacing((float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(8), 1.0F);
        int resid = R.getStringRes(context, "smssdk_regist");
        title.setText(resid);
        title.setTextColor(-6710887);
        title.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(26));
        title.setGravity(16);
        title.setBackgroundColor(-1382162);
        root.addView(title);
        return root;
    }
}
