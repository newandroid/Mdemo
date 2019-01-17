package css.com.applab.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.css.uilib.HelloWorldView;

import androidx.annotation.Nullable;

/**
 * create by css on 2019/1/17
 */
public class UilibLoadActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HelloWorldView helloWorldView = new HelloWorldView(this);
        setContentView(helloWorldView);
        ViewGroup.LayoutParams layoutParams = helloWorldView.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
    }
}
