package css.com.applab.activitys;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import css.com.applab.rxjava2.TimeoutTest;

/**
 * create by css on 2019/1/15
 */
public class Rxjava2RuntimeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimeoutTest.main(null);
    }
}
