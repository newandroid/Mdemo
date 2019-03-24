package css.com.applab.countrylist.layout;


import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import css.com.applab.R;

public class ContactsListviewItemLayout {
    public ContactsListviewItemLayout() {
    }

    public static RelativeLayout create(Context context) {
        cn.smssdk.gui.layout.SizeHelper.prepare(context);
        RelativeLayout root = new RelativeLayout(context);
        root.setId(1883242497);
        LayoutParams params = new LayoutParams(-1, cn.smssdk.gui.layout.SizeHelper.fromPxWidth(95));
        root.setLayoutParams(params);
        int padding = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(14);
        root.setPadding(padding, padding, padding, padding);
        root.setGravity(16);
        root.setBackgroundColor(-1);
        AsyncImageView contactImage = new AsyncImageView(context);
        contactImage.setId(1883242498);
        android.widget.RelativeLayout.LayoutParams contactImageParams = new android.widget.RelativeLayout.LayoutParams(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(64), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(64));
        contactImageParams.addRule(9);
        contactImage.setLayoutParams(contactImageParams);
        contactImage.setScaleType(ScaleType.FIT_CENTER);
        root.addView(contactImage);
        LinearLayout wrapper = new LinearLayout(context);
        android.widget.RelativeLayout.LayoutParams wrapperParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        wrapperParams.addRule(1, 1883242498);
        wrapperParams.addRule(15);
        wrapperParams.leftMargin = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(12);
        wrapper.setLayoutParams(wrapperParams);
        wrapper.setOrientation(1);
        root.addView(wrapper);
        TextView name = new TextView(context);
        name.setId(1883242499);
        android.widget.LinearLayout.LayoutParams nameParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        name.setLayoutParams(nameParams);
        name.setTextColor(-13421773);
        name.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(28));
        wrapper.addView(name);
        TextView contact = new TextView(context);
        contact.setId(1883242500);
        android.widget.LinearLayout.LayoutParams contactParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        contact.setLayoutParams(contactParams);
        contact.setTextColor(-6710887);
        contact.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(22));
        wrapper.addView(contact);
        Button add = new Button(context);
        add.setId(1883242501);
        android.widget.RelativeLayout.LayoutParams addParams = new android.widget.RelativeLayout.LayoutParams(cn.smssdk.gui.layout.SizeHelper.fromPxWidth(92), cn.smssdk.gui.layout.SizeHelper.fromPxWidth(46));
        addParams.addRule(11);
        addParams.addRule(15);
        add.setLayoutParams(addParams);
        int resid = R.getStringRes(context, "smssdk_add_contact");
        add.setText(resid);
        add.setTextSize(0, (float) cn.smssdk.gui.layout.SizeHelper.fromPxWidth(22));
        add.setTextColor(-8816263);
        add.setBackgroundDrawable(cn.smssdk.gui.layout.DrawableHelper.createCornerBg(context));
        add.setPadding(0, 0, 0, 0);
        root.addView(add);
        return root;
    }
}
