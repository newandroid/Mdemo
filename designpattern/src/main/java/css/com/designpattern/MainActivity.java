package css.com.designpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import css.com.designpattern.chapter1.ImageLoader;

public class MainActivity extends AppCompatActivity {
    ImageButton imageView;
    String imageUrl = "https://www.baidu.com/img/bd_logo1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iv_src);

    }

    public void myclick(View view) {
        new ImageLoader(this).displayImage(imageUrl,imageView);
    }
}
