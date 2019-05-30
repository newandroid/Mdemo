package css.com.applab.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import css.com.applab.R;


public class EditTextDialog extends Dialog {
    private TextView nameTv;

    public interface OnDialogItemClickListener {
        /**
         * 点击item 事件的回调方法
         */
        void onOkClick(String content);
    }


    public void setOnItemListener(OnDialogItemClickListener listener) {
        this.listener = listener;
    }

    private OnDialogItemClickListener listener;


    public EditTextDialog(Context context) {
        super(context, R.style.MyDialog);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_confirm);
        TextView content = findViewById(R.id.nameEt);
        nameTv = findViewById(R.id.nameTv);
        findViewById(R.id.okTv).setOnClickListener(v -> {
            dismiss();
            if (listener != null) listener.onOkClick(content.getText().toString());
        });
        findViewById(R.id.cancelTv).setOnClickListener(v -> {
            dismiss();
        });
    }

    public void setNameTv(int strResId) {
        nameTv.setText(strResId);
    }

    public void setNameTv(String name) {
        nameTv.setText(name);
    }
}
