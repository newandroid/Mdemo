package css.com.applab.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import css.com.applab.R;

public class RedGreenActivity extends Activity {
    TextView one;
    TextView two;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_green);
        one = findViewById(R.id.oneTv);
        two = findViewById(R.id.twoTv);
        int[] res = new int[]{R.drawable.shape_red,R.drawable.shape_green};
        findViewById(R.id.root).setOnClickListener(v -> {
            int[] randomResult = new int[2];
            for (int i = 0; i < 2; i++) {
                double random = Math.random();
                if (random>0.5){
                    randomResult[i] = res[0];
                    System.out.println("i:"+i+" res:red");
                }else {
                    randomResult[i] = res[1];
                    System.out.println("i:"+i+" res:green");
                }
            }
            one.setBackgroundResource(randomResult[0]);
            two.setBackgroundResource(randomResult[1]);

        });
    }


}
