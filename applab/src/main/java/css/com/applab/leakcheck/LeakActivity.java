package css.com.applab.leakcheck;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

public class LeakActivity extends Activity implements LeakCallBack {
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button = new Button(this);
        setContentView(button);
        System.out.println("LeakActivity.onCreate");
        new WorkClass(this).doSomething();
//        button.setOnClickListener(v -> {
//
//            finish();
//        });
    }

    @Override
    public void onCall() {
        button.setText("oncall");
        System.out.println("LeakActivity.onCall button:"+button);
    }
}
