package css.com.applab.activitys;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import css.com.applab.R;

public class BitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        View root = findViewById(R.id.root);
        root.post(() -> {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.circle_15_15);
            System.out.println("width:" + bitmap.getWidth() + " height:" + bitmap.getHeight());
            ImageView icon = findViewById(R.id.icon);
            icon.setImageBitmap(Bitmap.createScaledBitmap(bitmap, root.getWidth(), root.getHeight(), false));
        });

    }
}
