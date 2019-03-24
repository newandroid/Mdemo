
package css.com.applab.countrylist;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;

import css.com.applab.R;
import css.com.applab.countrylist.layout.RegisterPageLayout;
import css.com.applab.countrylist.layout.SendMsgDialogLayout;

public class RegisterPage extends FakeActivity implements OnClickListener, TextWatcher {
    private static final String DEFAULT_COUNTRY_ID = "42";
    private EventHandler callback;
    private TextView tvCountry;
    private EditText etPhoneNum;
    private TextView tvCountryNum;
    private ImageView ivClear;
    private Button btnNext;
    private String currentId;
    private String currentCode;
    private EventHandler handler;
    private Dialog pd;
    private OnSendMessageHandler osmHandler;

    public RegisterPage() {
    }

    public void setRegisterCallback(EventHandler callback) {
        this.callback = callback;
    }

    public void setOnSendMessageHandler(OnSendMessageHandler h) {
        this.osmHandler = h;
    }

    public void show(Context context) {
        super.show(context, (Intent)null);
    }

    public void onCreate() {
        RegisterPageLayout page = new RegisterPageLayout(this.activity);
        LinearLayout layout = page.getLayout();
        if (layout != null) {
            this.activity.setContentView(layout);
            this.currentId = "42";
            View llBack = this.activity.findViewById(117506049);
            TextView tv = (TextView)this.activity.findViewById(117506050);
            int resId = R.getStringRes(this.activity, "smssdk_regist");
            if (resId > 0) {
                tv.setText(resId);
            }

            View viewCountry = this.activity.findViewById(117571585);
            this.btnNext = (Button)this.activity.findViewById(117571590);
            this.tvCountry = (TextView)this.activity.findViewById(117571586);
            String[] country = this.getCurrentCountry();
            if (country != null) {
                this.currentCode = country[1];
                this.tvCountry.setText(country[0]);
            }

            this.tvCountryNum = (TextView)this.activity.findViewById(117571587);
            this.tvCountryNum.setText("+" + this.currentCode);
            this.etPhoneNum = (EditText)this.activity.findViewById(117571588);
            this.etPhoneNum.setText("");
            this.etPhoneNum.addTextChangedListener(this);
            this.etPhoneNum.requestFocus();
            if (this.etPhoneNum.getText().length() > 0) {
                this.btnNext.setEnabled(true);
                this.ivClear = (ImageView)this.activity.findViewById(117571589);
                this.ivClear.setVisibility(0);
                resId = R.getBitmapRes(this.activity, "smssdk_btn_enable");
                if (resId > 0) {
                    this.btnNext.setBackgroundResource(resId);
                }
            }

            this.ivClear = (ImageView)this.activity.findViewById(117571589);
            llBack.setOnClickListener(this);
            this.btnNext.setOnClickListener(this);
            this.ivClear.setOnClickListener(this);
            viewCountry.setOnClickListener(this);
            this.handler = new EventHandler() {
                public void afterEvent(final int event, final int result, final Object data) {
                    RegisterPage.this.runOnUIThread(new Runnable() {
                        public void run() {
                            if (RegisterPage.this.pd != null && RegisterPage.this.pd.isShowing()) {
                                RegisterPage.this.pd.dismiss();
                            }

                            if (result == -1) {
                                if (event == 2) {
                                    boolean smart = (Boolean)data;
                                    RegisterPage.this.afterVerificationCodeRequested(smart);
                                }
                            } else {
                                if (event == 2 && data != null && data instanceof UserInterruptException) {
                                    return;
                                }

                                int status = 0;

                                try {
                                    ((Throwable)data).printStackTrace();
                                    Throwable throwable = (Throwable)data;
                                    JSONObject object = new JSONObject(throwable.getMessage());
                                    String des = object.optString("detail");
                                    status = object.optInt("status");
                                    if (!TextUtils.isEmpty(des)) {
                                        Toast.makeText(RegisterPage.this.activity, des, 0).show();
                                        return;
                                    }
                                } catch (Exception var5) {
                                    SMSLog.getInstance().w(var5);
                                }

                                int resId = false;
                                int resIdx;
                                if (status >= 400) {
                                    resIdx = R.getStringRes(RegisterPage.this.activity, "smssdk_error_desc_" + status);
                                } else {
                                    resIdx = R.getStringRes(RegisterPage.this.activity, "smssdk_network_error");
                                }

                                if (resIdx > 0) {
                                    Toast.makeText(RegisterPage.this.activity, resIdx, 0).show();
                                }
                            }

                        }
                    });
                }
            };
        }

    }

    private String[] getCurrentCountry() {
        String mcc = this.getMCC();
        String[] country = null;
        if (!TextUtils.isEmpty(mcc)) {
            country = SMSSDK.getCountryByMCC(mcc);
        }

        if (country == null) {
            Log.w("SMSSDK", "no country found by MCC: " + mcc);
            country = SMSSDK.getCountry("42");
        }

        return country;
    }

    private String getMCC() {
        TelephonyManager tm = (TelephonyManager)this.activity.getSystemService("phone");
        String networkOperator = tm.getNetworkOperator();
        return !TextUtils.isEmpty(networkOperator) ? networkOperator : tm.getSimOperator();
    }

    public void onResume() {
        SMSSDK.registerEventHandler(this.handler);
    }

    public void onPause() {
        SMSSDK.unregisterEventHandler(this.handler);
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int resId;
        if (s.length() > 0) {
            this.btnNext.setEnabled(true);
            this.ivClear.setVisibility(0);
            resId = R.getBitmapRes(this.activity, "smssdk_btn_enable");
            if (resId > 0) {
                this.btnNext.setBackgroundResource(resId);
            }
        } else {
            this.btnNext.setEnabled(false);
            this.ivClear.setVisibility(8);
            resId = R.getBitmapRes(this.activity, "smssdk_btn_disenable");
            if (resId > 0) {
                this.btnNext.setBackgroundResource(resId);
            }
        }

    }

    public void afterTextChanged(Editable s) {
    }

    public void onClick(View v) {
        int id = v.getId();
        int id_ll_back = 117506049;
        int id_rl_country = 117571585;
        int id_btn_next = 117571590;
        int id_iv_clear = 117571589;
        if (id == id_ll_back) {
            this.finish();
        } else if (id == id_rl_country) {
            CountryPage countryPage = new CountryPage();
            countryPage.setCountryId(this.currentId);
            countryPage.showForResult(this.activity, (Intent)null, this);
        } else if (id == id_btn_next) {
            String phone = this.etPhoneNum.getText().toString().trim().replaceAll("\\s*", "");
            String code = this.tvCountryNum.getText().toString().trim();
            this.showDialog(phone, code);
        } else if (id == id_iv_clear) {
            this.etPhoneNum.getText().clear();
        }

    }

    public void onResult(HashMap<String, Object> data) {
        if (data != null) {
            int page = (Integer)data.get("page");
            if (page == 1) {
                this.currentId = (String)data.get("id");
                String[] country = SMSSDK.getCountry(this.currentId);
                if (country != null) {
                    this.currentCode = country[1];
                    this.tvCountryNum.setText("+" + this.currentCode);
                    this.tvCountry.setText(country[0]);
                }
            } else if (page == 2) {
                Object res = data.get("res");
                HashMap<String, Object> phoneMap = (HashMap)data.get("phone");
                if (res != null && phoneMap != null) {
                    int resId = R.getStringRes(this.activity, "smssdk_your_ccount_is_verified");
                    if (resId > 0) {
                        Toast.makeText(this.activity, resId, 0).show();
                    }

                    if (this.callback != null) {
                        this.callback.afterEvent(3, -1, phoneMap);
                    }

                    this.finish();
                }
            }
        }

    }

    private String splitPhoneNum(String phone) {
        StringBuilder builder = new StringBuilder(phone);
        builder.reverse();
        int i = 4;

        for(int len = builder.length(); i < len; i += 5) {
            builder.insert(i, ' ');
        }

        builder.reverse();
        return builder.toString();
    }

    public void showDialog(final String phone, final String code) {
        int resId = R.getStyleRes(this.activity, "CommonDialog");
        if (resId > 0) {
            String phoneNum = code + " " + this.splitPhoneNum(phone);
            final Dialog dialog = new Dialog(this.getContext(), resId);
            LinearLayout layout = SendMsgDialogLayout.create(this.getContext());
            if (layout != null) {
                dialog.setContentView(layout);
                ((TextView)dialog.findViewById(1881145357)).setText(phoneNum);
                TextView tv = (TextView)dialog.findViewById(1882193924);
                resId = R.getStringRes(this.activity, "smssdk_make_sure_mobile_detail");
                if (resId > 0) {
                    String text = this.getContext().getString(resId);
                    tv.setText(Html.fromHtml(text));
                }

                ((Button)dialog.findViewById(1882193921)).setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                        if (RegisterPage.this.pd != null && RegisterPage.this.pd.isShowing()) {
                            RegisterPage.this.pd.dismiss();
                        }

                        RegisterPage.this.pd = CommonDialog.ProgressDialog(RegisterPage.this.activity);
                        if (RegisterPage.this.pd != null) {
                            RegisterPage.this.pd.show();
                        }

                        Log.e("verification phone ==>>", phone);
                        SMSSDK.getVerificationCode(code, phone.trim(), RegisterPage.this.osmHandler);
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

    private void afterVerificationCodeRequested(boolean smart) {
        String phone = this.etPhoneNum.getText().toString().trim().replaceAll("\\s*", "");
        String code = this.tvCountryNum.getText().toString().trim();
        if (code.startsWith("+")) {
            code = code.substring(1);
        }

        String formatedPhone = "+" + code + " " + this.splitPhoneNum(phone);
        if (smart) {
            cn.smssdk.gui.SmartVerifyPage smartPage = new cn.smssdk.gui.SmartVerifyPage();
            smartPage.setPhone(phone, code, formatedPhone);
            smartPage.showForResult(this.activity, (Intent)null, this);
        } else {
            IdentifyNumPage page = new IdentifyNumPage();
            page.setPhone(phone, code, formatedPhone);
            page.showForResult(this.activity, (Intent)null, this);
        }

    }
}
