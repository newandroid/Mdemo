package css.com.applab.countrylist.layout;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableHelper {
    public DrawableHelper() {
    }

    public static Drawable createCornerBg(Context c) {
        StateListDrawable sd = new StateListDrawable();
        sd.addState(new int[]{16842919}, createCornerBgPressed(c));
        sd.addState(new int[0], createCornerBgNormal(c));
        return sd;
    }

    public static Drawable createCornerBgNormal(Context c) {
        cn.smssdk.gui.layout.SizeHelper.prepare(c);
        int strokeWidth = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1);
        int roundRadius = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(6);
        int strokeColor = Color.parseColor("#ffc9c9cb");
        int fillColor = Color.parseColor("#ffffffff");
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(fillColor);
        gd.setCornerRadius((float)roundRadius);
        gd.setStroke(strokeWidth, strokeColor);
        return gd;
    }

    public static Drawable createCornerBgPressed(Context c) {
        cn.smssdk.gui.layout.SizeHelper.prepare(c);
        int strokeWidth = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(1);
        int roundRadius = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(6);
        int strokeColor = Color.parseColor("#ffc9c9cb");
        int fillColor = Color.parseColor("#afc9c9cb");
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(fillColor);
        gd.setCornerRadius((float)roundRadius);
        gd.setStroke(strokeWidth, strokeColor);
        return gd;
    }
}
