
package css.com.applab.countrylist;


import android.app.Dialog;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

import css.com.applab.R;
import css.com.applab.countrylist.layout.BackVerifyDialogLayout;
import css.com.applab.countrylist.layout.IdentifyNumPageLayout;
import css.com.applab.countrylist.layout.SizeHelper;

public class SmartVerifyPage extends FakeActivity implements OnClickListener {
    private static final int RETRY_INTERVAL = 60;
    private String phone;
    private String code;
    private String formatedPhone;
    private int time = 60;
    private Dialog pd;
    private EditText etIdentifyNum;
    private TextView tvTitle;
    private TextView tvPhone;
    private TextView tvIdentifyNotify;
    private TextView tvUnreceiveIdentify;
    private ImageView ivClear;
    private Button btnSubmit;
    private boolean showSmart = false;

    public SmartVerifyPage() {
    }

    public void setPhone(String phone, String code, String formatedPhone) {
        this.phone = phone;
        this.code = code;
        this.formatedPhone = formatedPhone;
    }

    public void onCreate() {
        IdentifyNumPageLayout page = new IdentifyNumPageLayout(this.activity);
        LinearLayout layout = page.getLayout();
        if (layout != null) {
            this.activity.setContentView(layout);
            this.activity.findViewById(117506049).setOnClickListener(this);
            this.btnSubmit = (Button)this.activity.findViewById(1881145360);
            this.btnSubmit.setOnClickListener(this);
            this.btnSubmit.setEnabled(false);
            this.tvTitle = (TextView)this.activity.findViewById(117506050);
            int resId = R.getStringRes(this.activity, "smssdk_write_identify_code");
            if (resId > 0) {
                this.tvTitle.setText(resId);
            }

            this.etIdentifyNum = (EditText)this.activity.findViewById(117506054);
            this.tvIdentifyNotify = (TextView)this.activity.findViewById(1881145356);
            resId = R.getStringRes(this.activity, "smssdk_send_mobile_detail");
            String unReceive;
            if (resId > 0) {
                unReceive = this.getContext().getString(resId);
                this.tvIdentifyNotify.setText(Html.fromHtml(unReceive));
            }

            this.tvPhone = (TextView)this.activity.findViewById(1881145357);
            this.tvPhone.setText(this.formatedPhone);
            this.tvUnreceiveIdentify = (TextView)this.activity.findViewById(1881145359);
            resId = R.getStringRes(this.activity, "smssdk_receive_msg");
            if (resId > 0) {
                unReceive = this.getContext().getString(resId, new Object[]{this.time});
                this.tvUnreceiveIdentify.setText(Html.fromHtml(unReceive));
            }

            this.tvUnreceiveIdentify.setOnClickListener(this);
            this.tvUnreceiveIdentify.setEnabled(false);
            this.ivClear = (ImageView)this.activity.findViewById(117571589);
            this.ivClear.setOnClickListener(this);
            this.countDown();
        }

    }

    private void countDown() {
        this.runOnUIThread(new Runnable() {
            public void run() {
                SmartVerifyPage.this.time--;
                int resId;
                if (SmartVerifyPage.this.time == 58) {
                    SmartVerifyPage.this.btnSubmit.setEnabled(true);
                    resId = R.getBitmapRes(SmartVerifyPage.this.activity, "smssdk_btn_enable");
                    if (resId > 0) {
                        SmartVerifyPage.this.btnSubmit.setBackgroundResource(resId);
                    }

                    resId = R.getStringRes(SmartVerifyPage.this.activity, "smssdk_smart_verify_already");
                    SmartVerifyPage.this.etIdentifyNum.setText(resId);
                    SmartVerifyPage.this.etIdentifyNum.setEnabled(false);
                    SmartVerifyPage.this.etIdentifyNum.setPadding(0, 0, 0, 0);
                    SmartVerifyPage.this.etIdentifyNum.setTextSize(0, (float)SizeHelper.fromPxWidth(32));
                    SmartVerifyPage.this.etIdentifyNum.setGravity(17);
                    SmartVerifyPage.this.etIdentifyNum.invalidate();
                    resId = R.getStringRes(SmartVerifyPage.this.activity, "smssdk_smart_verify_tips");
                    SmartVerifyPage.this.tvIdentifyNotify.setText(resId);
                    SmartVerifyPage.this.tvUnreceiveIdentify.setVisibility(4);
                    SmartVerifyPage.this.showSmart = true;
                    SmartVerifyPage.this.time = 60;
                } else {
                    resId = R.getStringRes(SmartVerifyPage.this.activity, "smssdk_receive_msg");
                    if (resId > 0) {
                        String unReceive = SmartVerifyPage.this.getContext().getString(resId, new Object[]{SmartVerifyPage.this.time});
                        SmartVerifyPage.this.tvUnreceiveIdentify.setText(Html.fromHtml(unReceive));
                    }

                    SmartVerifyPage.this.tvUnreceiveIdentify.setEnabled(false);
                    SmartVerifyPage.this.runOnUIThread(this, 1000L);
                }

            }
        }, 1000L);
    }

    public void onClick(View v) {
        int id = v.getId();
        int id_ll_back = 117506049;
        int id_btn_submit = 1881145360;
        int id_iv_clear = 117571589;
        if (id == id_ll_back) {
            if (this.showSmart) {
                this.finish();
                return;
            }

            this.runOnUIThread(new Runnable() {
                public void run() {
                    SmartVerifyPage.this.showNotifyDialog();
                }
            });
        } else if (id == id_btn_submit) {
            HashMap<String, Object> resp = new HashMap();
            resp.put("country", this.code);
            resp.put("phone", this.phone);
            this.afterSubmit(resp);
        } else if (id == id_iv_clear) {
            this.etIdentifyNum.getText().clear();
        }

    }

    private void afterSubmit(final Object data) {
        this.runOnUIThread(new Runnable() {
            public void run() {
                if (SmartVerifyPage.this.pd != null && SmartVerifyPage.this.pd.isShowing()) {
                    SmartVerifyPage.this.pd.dismiss();
                }

                HashMap<String, Object> res = new HashMap();
                res.put("res", true);
                res.put("page", 2);
                res.put("phone", data);
                SmartVerifyPage.this.setResult(res);
                SmartVerifyPage.this.finish();
            }
        });
    }

    private void showNotifyDialog() {
        int resId = R.getStyleRes(this.activity, "CommonDialog");
        if (resId > 0) {
            final Dialog dialog = new Dialog(this.getContext(), resId);
            LinearLayout layout = BackVerifyDialogLayout.create(this.activity);
            if (layout != null) {
                dialog.setContentView(layout);
                resId = 1882193924;
                TextView tv = (TextView)dialog.findViewById(resId);
                resId = R.getStringRes(this.activity, "smssdk_close_identify_page_dialog");
                if (resId > 0) {
                    tv.setText(resId);
                }

                resId = 1882193921;
                Button waitBtn = (Button)dialog.findViewById(resId);
                resId = R.getStringRes(this.activity, "smssdk_wait");
                if (resId > 0) {
                    waitBtn.setText(resId);
                }

                waitBtn.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                resId = 1882193922;
                Button backBtn = (Button)dialog.findViewById(resId);
                resId = R.getStringRes(this.activity, "smssdk_back");
                if (resId > 0) {
                    backBtn.setText(resId);
                }

                backBtn.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                        SmartVerifyPage.this.finish();
                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
            }
        }

    }

    public boolean onKeyEvent(int keyCode, KeyEvent event) {
        if (keyCode == 4 && event.getAction() == 0) {
            this.finish();
            return true;
        } else {
            return false;
        }
    }
}
