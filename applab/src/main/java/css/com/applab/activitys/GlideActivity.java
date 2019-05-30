package css.com.applab.activitys;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import css.com.applab.R;

public class GlideActivity extends AppCompatActivity {
    ImageView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        content = findViewById(R.id.content);
//        Glide.with(this)
//                .load("https://www.czxiu.com/assets/z/wakeup/demo.gif?1531591753")
//                .into(content);
        Glide.with(this)
                .load(R.drawable.ic_launcher_foreground)
                .into(content);
    }
}
