package css.com.applab.activitys;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import css.com.applab.R;
import css.com.applab.view.EditTextDialog;

public class EditextDialogCompatibleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editext_dialog_compatible);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextDialog editTextDialog = new EditTextDialog(EditextDialogCompatibleActivity.this);
                editTextDialog.show();
            }
        });
    }
}
