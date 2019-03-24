package css.com.applab.countrylist.layout;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import css.com.applab.R;


public class SendMsgDialogLayout {
    public SendMsgDialogLayout() {
    }

    public static LinearLayout create(Context context) {
        cn.smssdk.gui.layout.SizeHelper.prepare(context);
        LinearLayout root = new LinearLayout(context);
        LayoutParams params = new LayoutParams(-2, -2);
        root.setLayoutParams(params);
        root.setOrientation(1);
        TextView dialogTitle = new TextView(context);
        dialogTitle.setId(1882193923);
        android.widget.LinearLayout.LayoutParams titleParams = new android.widget.LinearLayout.LayoutParams(-2, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(92));
        dialogTitle.setLayoutParams(titleParams);
        dialogTitle.setPadding(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(20), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(20), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(20), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(20));
        int resid = R.getStringRes(context, "smssdk_make_sure_mobile_num");
        dialogTitle.setText(resid);
        dialogTitle.setTextColor(-12801001);
        dialogTitle.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(32));
        dialogTitle.setGravity(16);
        dialogTitle.setTypeface(Typeface.DEFAULT_BOLD);
        root.addView(dialogTitle);
        View line1 = new View(context);
        android.widget.LinearLayout.LayoutParams line1Params = new android.widget.LinearLayout.LayoutParams(-1, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1));
        line1.setLayoutParams(line1Params);
        line1.setBackgroundColor(-12801001);
        root.addView(line1);
        TextView dialogHint = new TextView(context);
        dialogHint.setId(1882193924);
        android.widget.LinearLayout.LayoutParams hintParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        hintParams.topMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(28);
        dialogHint.setLayoutParams(hintParams);
        dialogHint.setPadding(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(18), 0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(18), 0);
        resid = R.getStringRes(context, "smssdk_make_sure_mobile_detail");
        dialogHint.setText(resid);
        dialogHint.setTextColor(-1);
        dialogHint.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(24));
        root.addView(dialogHint);
        TextView phone = new TextView(context);
        phone.setId(1881145357);
        android.widget.LinearLayout.LayoutParams phoneParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        phoneParams.bottomMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(26);
        phone.setLayoutParams(phoneParams);
        phone.setPadding(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(18), 0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(18), 0);
        phone.setTextColor(-1);
        phone.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(24));
        root.addView(phone);
        View line2 = new View(context);
        android.widget.LinearLayout.LayoutParams line2Params = new android.widget.LinearLayout.LayoutParams(-1, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1));
        line2.setLayoutParams(line2Params);
        line2.setBackgroundColor(-9211021);
        root.addView(line2);
        LinearLayout wrapper = new LinearLayout(context);
        android.widget.LinearLayout.LayoutParams wrapperParams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        wrapper.setLayoutParams(wrapperParams);
        Button ok = new Button(context);
        ok.setId(1882193921);
        android.widget.LinearLayout.LayoutParams okParams = new android.widget.LinearLayout.LayoutParams(0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(80), 1.0F);
        okParams.rightMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1);
        ok.setLayoutParams(okParams);
        resid = R.getBitmapRes(context, "smssdk_dialog_btn_back");
        ok.setBackgroundResource(resid);
        int padding = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(18);
        ok.setPadding(padding, padding, padding, padding);
        resid = R.getStringRes(context, "smssdk_ok");
        ok.setText(resid);
        ok.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(22));
        ok.setTextColor(-1);
        wrapper.addView(ok);
        View line3 = new View(context);
        android.widget.LinearLayout.LayoutParams line3Params = new android.widget.LinearLayout.LayoutParams(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1), -1);
        line3.setLayoutParams(line3Params);
        line3.setBackgroundColor(-9211021);
        wrapper.addView(line3);
        Button cancel = new Button(context);
        cancel.setId(1882193922);
        android.widget.LinearLayout.LayoutParams cancelParams = new android.widget.LinearLayout.LayoutParams(0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(80), 1.0F);
        cancelParams.rightMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1);
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
