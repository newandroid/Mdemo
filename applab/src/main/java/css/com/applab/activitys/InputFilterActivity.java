package css.com.applab.activitys;

import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import css.com.applab.R;
import css.com.applab.utils.InputIllegalFilter;

public class InputFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_filter);
        EditText et = findViewById(R.id.editText);
        et.setFilters(new InputFilter[]{new InputIllegalFilter(this)});
    }
}
