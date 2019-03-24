package css.com.applab.countrylist;

import android.app.Dialog;
import android.content.Context;
import android.widget.LinearLayout;

import css.com.applab.R;

public class CommonDialog {
    public CommonDialog() {
    }

    public static final Dialog ProgressDialog(Context context) {
        int resId = R.getStyleRes(context, "CommonDialog");
        if (resId > 0) {
            Dialog dialog = new Dialog(context, resId);
            LinearLayout layout = cn.smssdk.gui.layout.ProgressDialogLayout.create(context);
            if (layout != null) {
                dialog.setContentView(layout);
                return dialog;
            }
        }

        return null;
    }
}