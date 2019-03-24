//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



package css.com.applab.countrylist.layout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import css.com.applab.R;


public class BackVerifyDialogLayout {
    public BackVerifyDialogLayout() {
    }

    public static LinearLayout create(Context context) {
        cn.smssdk.gui.layout.SizeHelper.prepare(context);
        LinearLayout root = new LinearLayout(context);
        LayoutParams params = new LayoutParams(-2, -2);
        root.setLayoutParams(params);
        root.setOrientation(1);
        TextView dialogHint = new TextView(context);
        dialogHint.setId(1882193924);
        android.widget.LinearLayout.LayoutParams hintParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        hintParams.topMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(32);
        hintParams.bottomMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(32);
        dialogHint.setLayoutParams(hintParams);
        dialogHint.setPadding(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(18), 0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(18), 0);
        dialogHint.setLineSpacing((float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(8), 1.0F);
        int resid = R.getStringRes(context, "smssdk_make_sure_mobile_detail");
        dialogHint.setText(resid);
        dialogHint.setTextColor(-1);
        dialogHint.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(26));
        dialogHint.setGravity(17);
        root.addView(dialogHint);
        View line = new View(context);
        android.widget.LinearLayout.LayoutParams lineParams = new android.widget.LinearLayout.LayoutParams(-1, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1));
        line.setLayoutParams(lineParams);
        line.setBackgroundColor(-9211021);
        root.addView(line);
        LinearLayout wrapper = new LinearLayout(context);
        android.widget.LinearLayout.LayoutParams wrapperParams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        wrapper.setLayoutParams(wrapperParams);
        Button ok = new Button(context);
        ok.setId(1882193921);
        android.widget.LinearLayout.LayoutParams okParams = new android.widget.LinearLayout.LayoutParams(0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(78), 1.0F);
        okParams.leftMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(3);
        ok.setLayoutParams(okParams);
        resid = R.getBitmapRes(context, "smssdk_dialog_btn_back");
        ok.setBackgroundResource(resid);
        int padding = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(8);
        ok.setPadding(padding, padding, padding, padding);
        resid = R.getStringRes(context, "smssdk_ok");
        ok.setText(resid);
        ok.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(22));
        ok.setTextColor(-1);
        wrapper.addView(ok);
        View line2 = new View(context);
        android.widget.LinearLayout.LayoutParams line2Params = new android.widget.LinearLayout.LayoutParams(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1), -1);
        line2.setLayoutParams(line2Params);
        line2.setBackgroundColor(-9211021);
        wrapper.addView(line2);
        Button cancel = new Button(context);
        cancel.setId(1882193922);
        android.widget.LinearLayout.LayoutParams cancelParams = new android.widget.LinearLayout.LayoutParams(0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(78), 1.0F);
        cancelParams.rightMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(3);
        cancel.setLayoutParams(cancelParams);
        resid = R.getBitmapRes(context, "smssdk_dialog_btn_back");
        cancel.setBackgroundResource(resid);
        cancel.setPadding(padding, padding, padding, padding);
        resid = R.getStringRes(context, "smssdk_cancel");
        cancel.setText(resid);
        cancel.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(22));
        cancel.setTextColor(-1);
        wrapper.addView(cancel);
        root.addView(wrapper);
        return root;
    }
}
