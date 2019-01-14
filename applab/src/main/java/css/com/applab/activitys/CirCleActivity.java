package css.com.applab.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import css.com.applab.view.AntialiasingView;

public class CirCleActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AntialiasingView iv = new AntialiasingView(this);
        setContentView(iv);
        ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
    }
}
