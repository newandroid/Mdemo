package css.com.applab.countrylist.layout;


import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import css.com.applab.R;

public class ContactDetailPageLayout extends BasePageLayout {
    public ContactDetailPageLayout(Context c) {
        super(c, false);
    }

    protected void onCreateContent(LinearLayout parent) {
        cn.smssdk.gui.layout.SizeHelper.prepare(this.context);
        LinearLayout wrapperLayout = new LinearLayout(this.context);
        LayoutParams wrapperParams = new LayoutParams(-1, -2);
        wrapperParams.setMargins(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(25), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(30), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(25), 0);
        wrapperLayout.setLayoutParams(wrapperParams);
        wrapperLayout.setBackgroundDrawable(cn.smssdk.gui.layout.DrawableHelper.createCornerBgNormal(this.context));
        wrapperLayout.setOrientation(0);
        parent.addView(wrapperLayout);
        ImageView contactIcon = new ImageView(this.context);
        contactIcon.setId(117571591);
        LayoutParams imageParams = new LayoutParams(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(88), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(88));
        int margin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(16);
        imageParams.setMargins(margin, margin, margin, margin);
        contactIcon.setLayoutParams(imageParams);
        contactIcon.setScaleType(ScaleType.FIT_CENTER);
        int resid = R.getBitmapRes(this.context, "smssdk_default_avatar");
        contactIcon.setBackgroundResource(resid);
        wrapperLayout.addView(contactIcon);
        LinearLayout innerLayout = new LinearLayout(this.context);
        LayoutParams innerParams = new LayoutParams(-1, -2);
        innerParams.setMargins(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(4), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(10), 0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(15));
        innerLayout.setLayoutParams(innerParams);
        innerLayout.setOrientation(1);
        wrapperLayout.addView(innerLayout);
        TextView contactName = new TextView(this.context);
        contactName.setId(117571592);
        LayoutParams contactNameParams = new LayoutParams(-2, -2);
        contactNameParams.topMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(10);
        contactName.setLayoutParams(contactNameParams);
        contactName.setTextColor(-16777216);
        contactName.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(24));
        innerLayout.addView(contactName);
        LinearLayout nestLayout = new LinearLayout(this.context);
        LayoutParams nestParams = new LayoutParams(-1, -2);
        nestParams.setMargins(0, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(10), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(15), 0);
        nestLayout.setLayoutParams(nestParams);
        nestLayout.setOrientation(0);
        innerLayout.addView(nestLayout);
        TextView tvPhone = new TextView(this.context);
        LayoutParams tvPhoneParams = new LayoutParams(-2, -2);
        tvPhone.setLayoutParams(tvPhoneParams);
        resid = R.getStringRes(this.context, "smssdk_contacts_phones");
        tvPhone.setText(resid);
        tvPhone.setTextColor(-16777216);
        tvPhone.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(20));
        nestLayout.addView(tvPhone);
        TextView contactPhone = new TextView(this.context);
        contactPhone.setId(117571593);
        LayoutParams contactPhoneParams = new LayoutParams(-2, -2);
        contactPhoneParams.leftMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(10);
        contactPhone.setLayoutParams(contactPhoneParams);
        contactPhone.setTextColor(-16777216);
        contactPhone.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(20));
        nestLayout.addView(contactPhone);
        TextView tv = new TextView(this.context);
        tv.setId(1881145354);
        LayoutParams tvParams = new LayoutParams(-2, -2);
        tvParams.setMargins(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(26), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(24), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(26), 0);
        tvParams.gravity = 1;
        tv.setLayoutParams(tvParams);
        tv.setTextColor(-10724260);
        tv.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(28));
        parent.addView(tv);
        Button inviteBtn = new Button(this.context);
        inviteBtn.setId(1881145355);
        LayoutParams inviteParams = new LayoutParams(-1, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(72));
        inviteParams.setMargins(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(26), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(22), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(26), 0);
        inviteBtn.setLayoutParams(inviteParams);
        resid = R.getBitmapRes(this.context, "smssdk_btn_enable");
        inviteBtn.setBackgroundResource(resid);
        resid = R.getStringRes(this.context, "smssdk_send_invitation");
        inviteBtn.setText(resid);
        inviteBtn.setTextColor(-1);
        inviteBtn.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(28));
        inviteBtn.setPadding(0, 0, 0, 0);
        parent.addView(inviteBtn);
    }
}
