package css.com.applab.countrylist;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import css.com.applab.R;

public class ContactDetailPage extends FakeActivity implements OnClickListener {
    private String phoneName = "";
    private ArrayList<String> phoneList = new ArrayList();

    public ContactDetailPage() {
    }

    public void onCreate() {
        cn.smssdk.gui.layout.ContactDetailPageLayout page = new cn.smssdk.gui.layout.ContactDetailPageLayout(this.activity);
        LinearLayout layout = page.getLayout();
        if (layout != null) {
            int resId = false;
            this.activity.setContentView(layout);
            this.activity.findViewById(117506049).setOnClickListener(this);
            TextView tvTitle = (TextView)this.activity.findViewById(117506050);
            int resId = R.getStringRes(this.activity, "smssdk_contacts_detail");
            tvTitle.setText(resId);
            TextView tvContactName = (TextView)this.activity.findViewById(117571592);
            tvContactName.setText(this.phoneName);
            TextView tvPhonesList = (TextView)this.activity.findViewById(117571593);
            StringBuilder phones = new StringBuilder();
            Iterator var8 = this.phoneList.iterator();

            String hint;
            while(var8.hasNext()) {
                hint = (String)var8.next();
                phones.append("\n");
                phones.append(hint);
            }

            if (phones.length() > 0) {
                phones.deleteCharAt(0);
                tvPhonesList.setText(phones.toString());
            }

            TextView tvInviteHint = (TextView)this.activity.findViewById(1881145354);
            resId = R.getStringRes(this.activity, "smssdk_not_invite");
            hint = this.getContext().getResources().getString(resId, new Object[]{this.phoneName});
            tvInviteHint.setText(Html.fromHtml(hint));
            this.activity.findViewById(1881145355).setOnClickListener(this);
        }

    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void setContact(HashMap<String, Object> contact) {
        ArrayList phones;
        if (contact.containsKey("displayname")) {
            this.phoneName = String.valueOf(contact.get("displayname"));
        } else if (contact.containsKey("phones")) {
            phones = (ArrayList)contact.get("phones");
            if (phones != null && phones.size() > 0) {
                this.phoneName = (String)((HashMap)phones.get(0)).get("phone");
            }
        }

        phones = (ArrayList)contact.get("phones");
        if (phones != null && phones.size() > 0) {
            Iterator var3 = phones.iterator();

            while(var3.hasNext()) {
                HashMap<String, Object> phone = (HashMap)var3.next();
                String pn = (String)phone.get("phone");
                this.phoneList.add(pn);
            }
        }

    }

    public void onClick(View v) {
        int id = v.getId();
        int id_ll_back = 117506049;
        int id_btn_invite = 1881145355;
        if (id == id_ll_back) {
            this.finish();
        } else if (id == id_btn_invite) {
            if (this.phoneList.size() > 1) {
                this.showDialog();
                return;
            }

            String phone = this.phoneList.size() > 0 ? (String)this.phoneList.get(0) : "";
            this.sendMsg(phone);
        }

    }

    private void sendMsg(String phone) {
        Uri smsToUri = Uri.parse("smsto:" + phone);
        Intent intent = new Intent("android.intent.action.SENDTO", smsToUri);
        int resId = R.getStringRes(this.activity, "smssdk_invite_content");
        if (resId > 0) {
            intent.putExtra("sms_body", this.activity.getString(resId));
        }

        if (intent.resolveActivity(this.getContext().getPackageManager()) != null) {
            this.startActivity(intent);
        }

    }

    private void showDialog() {
        String[] phones = new String[this.phoneList.size()];
        phones = (String[])this.phoneList.toArray(phones);
        Builder builder = new Builder(this.activity);
        int resId = R.getStringRes(this.activity, "smssdk_invite_content");
        if (resId > 0) {
            builder.setTitle(resId);
        }

        builder.setCancelable(true);
        resId = R.getStringRes(this.activity, "smssdk_cancel");
        if (resId > 0) {
            builder.setNegativeButton(resId, new android.content.DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }

        builder.setItems(phones, new android.content.DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ContactDetailPage.this.sendMsg((String)ContactDetailPage.this.phoneList.get(which));
            }
        });
        builder.create().show();
    }
}