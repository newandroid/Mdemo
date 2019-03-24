package css.com.applab.countrylist.layout;

import android.content.Context;

import css.com.applab.R;

public class SizeHelper {
    public static float designedDensity = 1.5F;
    public static int designedScreenWidth = 540;
    private static Context context = null;
    protected static SizeHelper helper;

    private SizeHelper() {
    }

    public static void prepare(Context c) {
        if (context == null || context != c.getApplicationContext()) {
            context = c;
        }

    }

    public static int fromPx(int px) {
        return R.designToDevice(context, designedDensity, px);
    }

    public static int fromPxWidth(int px) {
        return R.designToDevice(context, designedScreenWidth, px);
    }

    public static int fromDp(int dp) {
        int px = R.dipToPx(context, dp);
        return R.designToDevice(context, designedDensity, px);
    }
}
