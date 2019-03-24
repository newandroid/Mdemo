package css.com.applab.countrylist;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.tools.FakeActivity;
import com.mob.tools.utils.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.layout.ContactListPageLayout;
import cn.smssdk.utils.SMSLog;

public class ContactsPage extends FakeActivity implements OnClickListener, TextWatcher {
    private EditText etSearch;
    private ContactsListView listView;
    private ContactsAdapter adapter;
    private ContactItemMaker itemMaker;
    private Dialog pd;
    private EventHandler handler;
    private ArrayList<HashMap<String, Object>> friendsInApp;
    private ArrayList<HashMap<String, Object>> contactsInMobile;

    public ContactsPage() {
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
                ContactsPage.this.afterPrepare();
            }
        });
    }

    private void afterPrepare() {
        this.runOnUIThread(new Runnable() {
            public void run() {
                ContactsPage.this.friendsInApp = new ArrayList();
                ContactsPage.this.contactsInMobile = new ArrayList();
                ContactListPageLayout page = new ContactListPageLayout(ContactsPage.this.activity);
                LinearLayout layout = page.getLayout();
                if (layout != null) {
                    ContactsPage.this.activity.setContentView(layout);
                    ContactsPage.this.initView();
                    ContactsPage.this.initData();
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

    public void show(Context context) {
        this.show(context, new cn.smssdk.gui.DefaultContactViewItem());
    }

    public void show(Context context, ContactItemMaker maker) {
        this.itemMaker = maker;
        super.show(context, (Intent)null);
    }

    private void initView() {
        this.listView = (ContactsListView)this.activity.findViewById(1881145361);
        this.activity.findViewById(117506049).setOnClickListener(this);
        this.activity.findViewById(117506052).setOnClickListener(this);
        this.activity.findViewById(117571589).setOnClickListener(this);
        TextView tv = (TextView)this.activity.findViewById(117506050);
        int resId = R.getStringRes(this.activity, "smssdk_search_contact");
        if (resId > 0) {
            tv.setText(resId);
        }

        this.etSearch = (EditText)this.activity.findViewById(117506054);
        this.etSearch.addTextChangedListener(this);
    }

    private void initData() {
        this.handler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == -1) {
                    if (event == 4) {
                        ArrayList<HashMap<String, Object>> rawList = (ArrayList)data;
                        if (rawList == null) {
                            ContactsPage.this.contactsInMobile = new ArrayList();
                        } else {
                            ContactsPage.this.contactsInMobile = (ArrayList)rawList.clone();
                        }

                        ContactsPage.this.refreshContactList();
                    } else if (event == 6) {
                        ContactsPage.this.friendsInApp = (ArrayList)data;
                        SMSSDK.getContacts(false);
                    }
                } else {
                    ContactsPage.this.runOnUIThread(new Runnable() {
                        public void run() {
                            if (ContactsPage.this.pd != null && ContactsPage.this.pd.isShowing()) {
                                ContactsPage.this.pd.dismiss();
                            }

                            int resId = R.getStringRes(ContactsPage.this.activity, "smssdk_network_error");
                            if (resId > 0) {
                                Toast.makeText(ContactsPage.this.activity, resId, 0).show();
                            }

                        }
                    });
                }

            }
        };
        SMSSDK.registerEventHandler(this.handler);
        if (this.friendsInApp != null && this.friendsInApp.size() > 0) {
            SMSSDK.getContacts(false);
        } else {
            SMSSDK.getFriendsInApp();
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
        } catch (Exception var4) {
            SMSLog.getInstance().w(var4);
        }

        return super.onKeyEvent(keyCode, event);
    }

    public void onDestroy() {
        SMSSDK.unregisterEventHandler(this.handler);
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (this.adapter != null) {
            this.adapter.search(s.toString());
            this.adapter.notifyDataSetChanged();
        }

    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
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
            this.etSearch.requestFocus();
            this.etSearch.getText().clear();
        } else if (id == id_iv_clear) {
            this.etSearch.getText().clear();
        }

    }

    private void refreshContactList() {
        ArrayList<ContactEntry> phone2Contact = new ArrayList();
        Iterator var2 = this.contactsInMobile.iterator();

        while(true) {
            HashMap contact;
            ArrayList phones;
            Iterator var5;
            HashMap friend;
            String cp;
            ContactEntry ent;
            do {
                do {
                    if (!var2.hasNext()) {
                        ArrayList<HashMap<String, Object>> tmpFia = new ArrayList();
                        int p2cSize = phone2Contact.size();
                        Iterator var16 = this.friendsInApp.iterator();

                        while(true) {
                            HashMap friend;
                            String phone;
                            do {
                                if (!var16.hasNext()) {
                                    this.friendsInApp = tmpFia;
                                    HashSet<HashMap<String, Object>> tmpCon = new HashSet();
                                    var5 = phone2Contact.iterator();

                                    while(true) {
                                        HashMap con;
                                        do {
                                            do {
                                                if (!var5.hasNext()) {
                                                    this.contactsInMobile.clear();
                                                    this.contactsInMobile.addAll(tmpCon);
                                                    var5 = this.friendsInApp.iterator();

                                                    while(true) {
                                                        HashMap contact;
                                                        do {
                                                            if (!var5.hasNext()) {
                                                                this.runOnUIThread(new Runnable() {
                                                                    public void run() {
                                                                        if (ContactsPage.this.pd != null && ContactsPage.this.pd.isShowing()) {
                                                                            ContactsPage.this.pd.dismiss();
                                                                        }

                                                                        ContactsPage.this.adapter = new ContactsAdapter(ContactsPage.this.listView, ContactsPage.this.friendsInApp, ContactsPage.this.contactsInMobile);
                                                                        ContactsPage.this.adapter.setContactItemMaker(ContactsPage.this.itemMaker);
                                                                        ContactsPage.this.listView.setAdapter(ContactsPage.this.adapter);
                                                                    }
                                                                });
                                                                return;
                                                            }

                                                            friend = (HashMap)var5.next();
                                                            contact = (HashMap)friend.remove("contact");
                                                        } while(contact == null);

                                                        String phone = String.valueOf(friend.get("phone"));
                                                        if (phone != null) {
                                                            ArrayList<HashMap<String, Object>> phones = (ArrayList)contact.get("phones");
                                                            if (phones != null && phones.size() > 0) {
                                                                ArrayList<HashMap<String, Object>> tmpPs = new ArrayList();
                                                                Iterator var28 = phones.iterator();

                                                                while(var28.hasNext()) {
                                                                    HashMap<String, Object> p = (HashMap)var28.next();
                                                                    String cp = (String)p.get("phone");
                                                                    if (!phone.equals(cp)) {
                                                                        tmpPs.add(p);
                                                                    }
                                                                }

                                                                contact.put("phones", tmpPs);
                                                            }
                                                        }

                                                        friend.put("displayname", contact.get("displayname"));
                                                    }
                                                }

                                                ContactEntry ent = (ContactEntry)var5.next();
                                                cp = ent.getKey();
                                                con = ent.getValue();
                                            } while(cp == null);
                                        } while(con == null);

                                        boolean shouldAdd = true;
                                        Iterator var10 = this.friendsInApp.iterator();

                                        while(var10.hasNext()) {
                                            HashMap<String, Object> friend = (HashMap)var10.next();
                                            String phone = String.valueOf(friend.get("phone"));
                                            if (cp.equals(phone)) {
                                                shouldAdd = false;
                                                break;
                                            }
                                        }

                                        if (shouldAdd) {
                                            tmpCon.add(con);
                                        }
                                    }
                                }

                                friend = (HashMap)var16.next();
                                phone = String.valueOf(friend.get("phone"));
                            } while(phone == null);

                            for(int i = 0; i < p2cSize; ++i) {
                                ent = (ContactEntry)phone2Contact.get(i);
                                String cp = ent.getKey();
                                if (phone.equals(cp)) {
                                    friend.put("contact", ent.getValue());
                                    friend.put("fia", true);
                                    tmpFia.add((HashMap)friend.clone());
                                }
                            }
                        }
                    }

                    contact = (HashMap)var2.next();
                    phones = (ArrayList)contact.get("phones");
                } while(phones == null);
            } while(phones.size() <= 0);

            var5 = phones.iterator();

            while(var5.hasNext()) {
                friend = (HashMap)var5.next();
                cp = (String)friend.get("phone");
                ent = new ContactEntry(cp, contact);
                phone2Contact.add(ent);
            }
        }
    }
}
