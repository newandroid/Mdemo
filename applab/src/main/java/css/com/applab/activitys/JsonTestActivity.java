package css.com.applab.activitys;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import css.com.applab.R;
import css.com.applab.utils.BinaryUtils;

public class JsonTestActivity extends AppCompatActivity {
    private TextView contentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_test);
        contentTv = findViewById(R.id.contentTv);
        Number number = new Number() {
            @Override
            public int intValue() {
                return 1;
            }

            @Override
            public long longValue() {
                return 2;
            }

            @Override
            public float floatValue() {
                return 3.0f;
            }

            @Override
            public double doubleValue() {
                return 4.0;
            }
        };
        byte[] bytes = {1, 2, 3};
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("fuck", JSONObject.numberToString(number));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        contentTv.setText(jsonObject.toString());
        System.out.println(jsonObject.toString());
        try {
            System.out.println(jsonObject.get("fuck"));
            System.out.println(jsonObject.get("fuck").toString());
            System.out.println(BinaryUtils.bytesToHexString(jsonObject.get("fuck").toString().getBytes()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
