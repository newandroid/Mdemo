
package css.com.applab.countrylist.layout;


import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class ProgressDialogLayout {
    public ProgressDialogLayout() {
    }

    public static LinearLayout create(Context context) {
        LinearLayout root = new LinearLayout(context);
        LayoutParams params = new LayoutParams(-2, -2);
        root.setLayoutParams(params);
        root.setOrientation(1);
        ProgressBar bar = new ProgressBar(context);
        android.widget.LinearLayout.LayoutParams barParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        bar.setLayoutParams(barParams);
        cn.smssdk.gui.layout.SizeHelper.prepare(context);
        int padding = cn.smssdk.gui.layout.SizeHelper.fromPxWidth(20);
        bar.setPadding(padding, padding, padding, padding);
        root.addView(bar);
        return root;
    }
}
