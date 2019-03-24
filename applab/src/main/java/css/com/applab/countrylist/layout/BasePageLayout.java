//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package css.com.applab.countrylist.layout;


import android.content.Context;
import android.widget.LinearLayout;

public abstract class BasePageLayout {
    LinearLayout layout = null;
    Context context = null;

    public BasePageLayout(Context c, boolean isSearch) {
        this.context = c;
        this.layout = new LinearLayout(this.context);
        LayoutParams params = new LayoutParams(-1, -1);
        this.layout.setLayoutParams(params);
        this.layout.setOrientation(1);
        this.layout.setBackgroundColor(-1);
        LinearLayout title = cn.smssdk.gui.layout.TitleLayout.create(this.context, isSearch);
        this.layout.addView(title);
        this.onCreateContent(this.layout);
    }

    public LinearLayout getLayout() {
        return this.layout;
    }

    protected abstract void onCreateContent(LinearLayout var1);
}
