package css.com.applab.countrylist;


import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import css.com.applab.R;
import css.com.applab.countrylist.layout.BackVerifyDialogLayout;
import css.com.applab.countrylist.layout.IdentifyNumPageLayout;
import css.com.applab.countrylist.layout.SendMsgDialogLayout;

public class IdentifyNumPage extends FakeActivity implements OnClickListener, TextWatcher {
    private static final int RETRY_INTERVAL = 60;
    private static final int MIN_REQUEST_VOICE_VERIFY_INTERVAL = 1000;
    private String phone;
    private String code;
    private String formatedPhone;
    private int time = 60;
    private EventHandler handler;
    private Dialog pd;
    private EditText etIdentifyNum;
    private TextView tvTitle;
    private TextView tvPhone;
    private TextView tvIdentifyNotify;
    private TextView tvUnreceiveIdentify;
    private ImageView ivClear;
    private Button btnSubmit;
    private Button btnSounds;
    private BroadcastReceiver smsReceiver;
    private int SHOWDIALOGTYPE = 1;
    private long lastRequestVVTime;

    public IdentifyNumPage() {
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
            this.etIdentifyNum.addTextChangedListener(this);
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
            this.btnSounds = (Button)this.findViewById(1881145358);
            this.btnSounds.setOnClickListener(this);
            this.handler = new EventHandler() {
                public void afterEvent(int event, int result, Object data) {
                    if (event == 3) {
                        IdentifyNumPage.this.afterSubmit(result, data);
                    } else if (event == 2) {
                        IdentifyNumPage.this.afterGet(result, data);
                    } else if (event == 8) {
                        IdentifyNumPage.this.afterGetVoice(result, data);
                    }

                }
            };
            SMSSDK.registerEventHandler(this.handler);
            this.countDown();
        }

        try {
            if (DeviceHelper.getInstance(this.activity).checkPermission("android.permission.RECEIVE_SMS")) {
                this.smsReceiver = new cn.smssdk.gui.SMSReceiver(new VerifyCodeReadListener() {
                    public void onReadVerifyCode(final String verifyCode) {
                        IdentifyNumPage.this.runOnUIThread(new Runnable() {
                            public void run() {
                                IdentifyNumPage.this.etIdentifyNum.setText(verifyCode);
                            }
                        });
                    }
                });
                this.activity.registerReceiver(this.smsReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
            }
        } catch (Throwable var5) {
            var5.printStackTrace();
            this.smsReceiver = null;
        }

    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public boolean onFinish() {
        SMSSDK.unregisterEventHandler(this.handler);
        if (this.smsReceiver != null) {
            try {
                this.activity.unregisterReceiver(this.smsReceiver);
            } catch (Throwable var2) {
                var2.printStackTrace();
            }
        }

        return super.onFinish();
    }

    private void countDown() {
        this.runOnUIThread(new Runnable() {
            public void run() {
                IdentifyNumPage.this.time--;
                int resId;
                String unReceive;
                if (IdentifyNumPage.this.time == 0) {
                    resId = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_unreceive_identify_code");
                    if (resId > 0) {
                        unReceive = IdentifyNumPage.this.getContext().getString(resId, new Object[]{IdentifyNumPage.this.time});
                        IdentifyNumPage.this.tvUnreceiveIdentify.setText(Html.fromHtml(unReceive));
                    }

                    IdentifyNumPage.this.tvUnreceiveIdentify.setEnabled(true);
                    IdentifyNumPage.this.btnSounds.setVisibility(0);
                    IdentifyNumPage.this.time = 60;
                } else {
                    resId = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_receive_msg");
                    if (resId > 0) {
                        unReceive = IdentifyNumPage.this.getContext().getString(resId, new Object[]{IdentifyNumPage.this.time});
                        IdentifyNumPage.this.tvUnreceiveIdentify.setText(Html.fromHtml(unReceive));
                    }

                    IdentifyNumPage.this.tvUnreceiveIdentify.setEnabled(false);
                    IdentifyNumPage.this.runOnUIThread(this, 1000L);
                }

            }
        }, 1000L);
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int resId;
        if (s.length() > 0) {
            this.btnSubmit.setEnabled(true);
            this.ivClear.setVisibility(0);
            resId = R.getBitmapRes(this.activity, "smssdk_btn_enable");
            if (resId > 0) {
                this.btnSubmit.setBackgroundResource(resId);
            }
        } else {
            this.btnSubmit.setEnabled(false);
            this.ivClear.setVisibility(8);
            resId = R.getBitmapRes(this.activity, "smssdk_btn_disenable");
            if (resId > 0) {
                this.btnSubmit.setBackgroundResource(resId);
            }
        }

    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
    }

    public void onClick(View v) {
        int id = v.getId();
        int id_ll_back = 117506049;
        int id_btn_submit = 1881145360;
        int id_tv_unreceive_identify = 1881145359;
        int id_iv_clear = 117571589;
        int id_btn_sounds = 1881145358;
        if (id == id_ll_back) {
            this.runOnUIThread(new Runnable() {
                public void run() {
                    IdentifyNumPage.this.showNotifyDialog();
                }
            });
        } else if (id == id_btn_submit) {
            String verificationCode = this.etIdentifyNum.getText().toString().trim();
            if (!TextUtils.isEmpty(this.code)) {
                if (this.pd != null && this.pd.isShowing()) {
                    this.pd.dismiss();
                }

                this.pd = CommonDialog.ProgressDialog(this.activity);
                if (this.pd != null) {
                    this.pd.show();
                }

                SMSSDK.submitVerificationCode(this.code, this.phone, verificationCode);
            } else {
                int resId = R.getStringRes(this.activity, "smssdk_write_identify_code");
                if (resId > 0) {
                    Toast.makeText(this.getContext(), resId, 0).show();
                }
            }
        } else if (id == id_tv_unreceive_identify) {
            this.SHOWDIALOGTYPE = 1;
            this.showDialog(this.SHOWDIALOGTYPE);
        } else if (id == id_iv_clear) {
            this.etIdentifyNum.getText().clear();
        } else if (id == id_btn_sounds) {
            long time = System.currentTimeMillis();
            if (time - this.lastRequestVVTime > 1000L) {
                this.lastRequestVVTime = time;
                this.SHOWDIALOGTYPE = 2;
                this.showDialog(this.SHOWDIALOGTYPE);
            }
        }

    }

    private void showDialog(int type) {
        int resId;
        final Dialog dialog;
        if (type == 1) {
            resId = R.getStyleRes(this.activity, "CommonDialog");
            if (resId > 0) {
                dialog = new Dialog(this.getContext(), resId);
                TextView tv = new TextView(this.getContext());
                if (type == 1) {
                    resId = R.getStringRes(this.activity, "smssdk_resend_identify_code");
                } else {
                    resId = R.getStringRes(this.activity, "smssdk_send_sounds_identify_code");
                }

                if (resId > 0) {
                    tv.setText(resId);
                }

                tv.setTextSize(2, 18.0F);
                resId = R.getColorRes(this.activity, "smssdk_white");
                if (resId > 0) {
                    tv.setTextColor(this.getContext().getResources().getColor(resId));
                }

                int dp_10 = R.dipToPx(this.getContext(), 10);
                tv.setPadding(dp_10, dp_10, dp_10, dp_10);
                dialog.setContentView(tv);
                tv.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                        IdentifyNumPage.this.tvUnreceiveIdentify.setEnabled(false);
                        if (IdentifyNumPage.this.pd != null && IdentifyNumPage.this.pd.isShowing()) {
                            IdentifyNumPage.this.pd.dismiss();
                        }

                        IdentifyNumPage.this.pd = CommonDialog.ProgressDialog(IdentifyNumPage.this.activity);
                        if (IdentifyNumPage.this.pd != null) {
                            IdentifyNumPage.this.pd.show();
                        }

                        SMSSDK.getVerificationCode(IdentifyNumPage.this.code, IdentifyNumPage.this.phone.trim(), (OnSendMessageHandler)null);
                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        IdentifyNumPage.this.tvUnreceiveIdentify.setEnabled(true);
                    }
                });
                dialog.show();
            }
        } else if (type == 2) {
            resId = R.getStyleRes(this.activity, "CommonDialog");
            if (resId > 0) {
                dialog = new Dialog(this.getContext(), resId);
                LinearLayout layout = SendMsgDialogLayout.create(this.activity);
                if (layout != null) {
                    dialog.setContentView(layout);
                    TextView tv_title = (TextView)dialog.findViewById(1882193923);
                    resId = R.getStringRes(this.activity, "smssdk_make_sure_send_sounds");
                    if (resId > 0) {
                        tv_title.setText(resId);
                    }

                    TextView tv = (TextView)dialog.findViewById(1882193924);
                    resId = R.getStringRes(this.activity, "smssdk_send_sounds_identify_code");
                    if (resId > 0) {
                        String text = this.getContext().getString(resId);
                        tv.setText(text);
                    }

                    ((Button)dialog.findViewById(1882193921)).setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            dialog.dismiss();
                            SMSSDK.getVoiceVerifyCode(IdentifyNumPage.this.code, IdentifyNumPage.this.phone);
                        }
                    });
                    ((Button)dialog.findViewById(1882193922)).setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.setCanceledOnTouchOutside(true);
                    dialog.show();
                }
            }
        }

    }

    private void afterSubmit(final int result, final Object data) {
        this.runOnUIThread(new Runnable() {
            public void run() {
                if (IdentifyNumPage.this.pd != null && IdentifyNumPage.this.pd.isShowing()) {
                    IdentifyNumPage.this.pd.dismiss();
                }

                if (result == -1) {
                    HashMap<String, Object> res = new HashMap();
                    res.put("res", true);
                    res.put("page", 2);
                    res.put("phone", data);
                    IdentifyNumPage.this.setResult(res);
                    IdentifyNumPage.this.finish();
                } else {
                    ((Throwable)data).printStackTrace();
                    String message = ((Throwable)data).getMessage();
                    int resId = 0;

                    try {
                        JSONObject json = new JSONObject(message);
                        int status = json.getInt("status");
                        resId = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_error_detail_" + status);
                    } catch (JSONException var5) {
                        var5.printStackTrace();
                    }

                    if (resId == 0) {
                        resId = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_virificaition_code_wrong");
                    }

                    if (resId > 0) {
                        Toast.makeText(IdentifyNumPage.this.activity, resId, 0).show();
                    }
                }

            }
        });
    }

    private void afterGet(final int result, final Object data) {
        this.runOnUIThread(new Runnable() {
            public void run() {
                if (IdentifyNumPage.this.pd != null && IdentifyNumPage.this.pd.isShowing()) {
                    IdentifyNumPage.this.pd.dismiss();
                }

                if (result == -1) {
                    int resId = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_virificaition_code_sent");
                    if (resId > 0) {
                        Toast.makeText(IdentifyNumPage.this.activity, resId, 0).show();
                    }

                    resId = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_receive_msg");
                    if (resId > 0) {
                        String unReceive = IdentifyNumPage.this.getContext().getString(resId, new Object[]{IdentifyNumPage.this.time});
                        IdentifyNumPage.this.tvUnreceiveIdentify.setText(Html.fromHtml(unReceive));
                    }

                    IdentifyNumPage.this.btnSounds.setVisibility(8);
                    IdentifyNumPage.this.time = 60;
                    IdentifyNumPage.this.countDown();
                } else {
                    ((Throwable)data).printStackTrace();
                    Throwable throwable = (Throwable)data;
                    int status = 0;

                    try {
                        JSONObject object = new JSONObject(throwable.getMessage());
                        String des = object.optString("detail");
                        status = object.optInt("status");
                        if (!TextUtils.isEmpty(des)) {
                            Toast.makeText(IdentifyNumPage.this.activity, des, 0).show();
                            return;
                        }
                    } catch (JSONException var5) {
                        SMSLog.getInstance().w(var5);
                    }

                    int resIdx = false;
                    int resIdxx;
                    if (status >= 400) {
                        resIdxx = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_error_desc_" + status);
                    } else {
                        resIdxx = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_network_error");
                    }

                    if (resIdxx > 0) {
                        Toast.makeText(IdentifyNumPage.this.activity, resIdxx, 0).show();
                    }
                }

            }
        });
    }

    private void afterGetVoice(final int result, final Object data) {
        this.runOnUIThread(new Runnable() {
            public void run() {
                if (IdentifyNumPage.this.pd != null && IdentifyNumPage.this.pd.isShowing()) {
                    IdentifyNumPage.this.pd.dismiss();
                }

                if (result == -1) {
                    int resId = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_send_sounds_success");
                    if (resId > 0) {
                        Toast.makeText(IdentifyNumPage.this.activity, resId, 0).show();
                    }

                    IdentifyNumPage.this.btnSounds.setVisibility(8);
                } else {
                    ((Throwable)data).printStackTrace();
                    Throwable throwable = (Throwable)data;
                    int status = 0;

                    try {
                        JSONObject object = new JSONObject(throwable.getMessage());
                        String des = object.optString("detail");
                        status = object.optInt("status");
                        if (!TextUtils.isEmpty(des)) {
                            Toast.makeText(IdentifyNumPage.this.activity, des, 0).show();
                            return;
                        }
                    } catch (JSONException var5) {
                        SMSLog.getInstance().w(var5);
                    }

                    int resIdx = false;
                    int resIdxx;
                    if (status >= 400) {
                        resIdxx = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_error_desc_" + status);
                    } else {
                        resIdxx = R.getStringRes(IdentifyNumPage.this.activity, "smssdk_network_error");
                    }

                    if (resIdxx > 0) {
                        Toast.makeText(IdentifyNumPage.this.activity, resIdxx, 0).show();
                    }
                }

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
                        IdentifyNumPage.this.finish();
                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
            }
        }

    }

    public boolean onKeyEvent(int keyCode, KeyEvent event) {
        if (keyCode == 4 && event.getAction() == 0) {
            this.runOnUIThread(new Runnable() {
                public void run() {
                    IdentifyNumPage.this.showNotifyDialog();
                }
            });
            return true;
        } else {
            return false;
        }
    }
}
