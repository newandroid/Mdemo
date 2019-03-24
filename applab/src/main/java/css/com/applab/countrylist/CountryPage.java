package css.com.applab.countrylist;


import android.app.Dialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import css.com.applab.R;
import css.com.applab.countrylist.layout.CountryListPageLayout;

public class CountryPage extends FakeActivity implements OnClickListener, TextWatcher, OnItemClickListener {
    private String id;
    private HashMap<String, String> countryRules;
    private EventHandler handler;
    private CountryListView listView;
    private EditText etSearch;
    private Dialog pd;

    public CountryPage() {
    }

    public void setCountryId(String id) {
        this.id = id;
    }

    public void setCountryRuls(HashMap<String, String> countryRules) {
        this.countryRules = countryRules;
    }

    public void onCreate() {
        if (this.pd != null && this.pd.isShowing()) {
            this.pd.dismiss();
        }

        this.pd = CommonDialog.ProgressDialog(this.activity);
        if (this.pd != null) {
            this.pd.show();
        }

        cn.smssdk.gui.SearchEngine.prepare(this.activity, new Runnable() {
            public void run() {
                CountryPage.this.afterPrepare();
            }
        });
    }

    private void afterPrepare() {
        this.runOnUIThread(new Runnable() {
            public void run() {
                CountryListPageLayout page = new CountryListPageLayout(CountryPage.this.activity);
                LinearLayout layout = page.getLayout();
                if (layout != null) {
                    CountryPage.this.activity.setContentView(layout);
                }

                if (CountryPage.this.countryRules != null && CountryPage.this.countryRules.size() > 0) {
                    if (CountryPage.this.pd != null && CountryPage.this.pd.isShowing()) {
                        CountryPage.this.pd.dismiss();
                    }

                    CountryPage.this.initPage();
                } else {
                    CountryPage.this.handler = new EventHandler() {
                        public void afterEvent(int event, final int result, final Object data) {
                            if (event == 1) {
                                CountryPage.this.runOnUIThread(new Runnable() {
                                    public void run() {
                                        if (CountryPage.this.pd != null && CountryPage.this.pd.isShowing()) {
                                            CountryPage.this.pd.dismiss();
                                        }

                                        if (result == -1) {
                                            CountryPage.this.onCountryListGot((ArrayList)data);
                                        } else {
                                            ((Throwable)data).printStackTrace();
                                            int resId = R.getStringRes(CountryPage.this.activity, "smssdk_network_error");
                                            if (resId > 0) {
                                                Toast.makeText(CountryPage.this.activity, resId, 0).show();
                                            }

                                            CountryPage.this.finish();
                                        }

                                    }
                                });
                            }

                        }
                    };
                    SMSSDK.registerEventHandler(CountryPage.this.handler);
                    SMSSDK.getSupportedCountries();
                }

            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    private void initPage() {
        this.activity.findViewById(117506049).setOnClickListener(this);
        this.activity.findViewById(117506052).setOnClickListener(this);
        this.activity.findViewById(117571589).setOnClickListener(this);
        int resId = 1881145362;
        this.listView = (CountryListView)this.activity.findViewById(resId);
        this.listView.setOnItemClickListener(this);
        resId = 117506054;
        this.etSearch = (EditText)this.activity.findViewById(resId);
        this.etSearch.addTextChangedListener(this);
    }

    private void onCountryListGot(ArrayList<HashMap<String, Object>> countries) {
        Iterator var2 = countries.iterator();

        while(var2.hasNext()) {
            HashMap<String, Object> country = (HashMap)var2.next();
            String code = (String)country.get("zone");
            String rule = (String)country.get("rule");
            if (!TextUtils.isEmpty(code) && !TextUtils.isEmpty(rule)) {
                if (this.countryRules == null) {
                    this.countryRules = new HashMap();
                }

                this.countryRules.put(code, rule);
            }
        }

        this.initPage();
    }

    public void onItemClick(cn.smssdk.gui.GroupListView parent, View view, int group, int position) {
        if (position >= 0) {
            String[] country = this.listView.getCountry(group, position);
            if (this.countryRules != null && this.countryRules.containsKey(country[1])) {
                this.id = country[2];
                this.finish();
            } else {
                int resId = R.getStringRes(this.activity, "smssdk_country_not_support_currently");
                if (resId > 0) {
                    Toast.makeText(this.activity, resId, 0).show();
                }
            }
        }

    }

    public void onClick(View v) {
        int id = v.getId();
        int id_ll_back = 117506049;
        int id_ivSearch = 117506052;
        int id_iv_clear = 117571589;
        if (id == id_ll_back) {
            this.finish();
        } else if (id == id_ivSearch) {
            int id_llTitle = 117506051;
            this.activity.findViewById(id_llTitle).setVisibility(8);
            int id_llSearch = 117506053;
            this.activity.findViewById(id_llSearch).setVisibility(0);
            this.etSearch.getText().clear();
            this.etSearch.requestFocus();
        } else if (id == id_iv_clear) {
            this.etSearch.getText().clear();
        }

    }

    public boolean onKeyEvent(int keyCode, KeyEvent event) {
        try {
            int resId = 117506053;
            if (keyCode == 4 && event.getAction() == 0 && this.activity.findViewById(resId).getVisibility() == 0) {
                this.activity.findViewById(resId).setVisibility(8);
                resId = 117506051;
                this.activity.findViewById(resId).setVisibility(0);
                this.etSearch.setText("");
                return true;
            }
        } catch (Throwable var4) {
            SMSLog.getInstance().w(var4);
        }

        return super.onKeyEvent(keyCode, event);
    }

    public boolean onFinish() {
        SMSSDK.unregisterEventHandler(this.handler);
        HashMap<String, Object> res = new HashMap();
        res.put("id", this.id);
        res.put("page", 1);
        this.setResult(res);
        return super.onFinish();
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        this.listView.onSearch(s.toString().toLowerCase());
    }

    public void afterTextChanged(Editable s) {
    }
}
