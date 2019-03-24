package css.com.applab.countrylist;


import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import css.com.applab.R;
import css.com.applab.countrylist.layout.ContactsListviewItemLayout;

public class DefaultContactViewItem implements ContactItemMaker {
    public DefaultContactViewItem() {
    }

    public View getView(final HashMap<String, Object> user, View convertView, final ViewGroup parent) {
        DefaultContactViewItem.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new DefaultContactViewItem.ViewHolder();
            convertView = ContactsListviewItemLayout.create(parent.getContext());
            int resId = 1883242498;
            viewHolder.ivContact = (AsyncImageView)((View)convertView).findViewById(resId);
            resId = 1883242499;
            viewHolder.tvName = (TextView)((View)convertView).findViewById(resId);
            resId = 1883242500;
            viewHolder.tvContact = (TextView)((View)convertView).findViewById(resId);
            resId = 1883242501;
            viewHolder.btnAdd = (Button)((View)convertView).findViewById(resId);
            resId = 1883242497;
            viewHolder.bg = ((View)convertView).findViewById(resId);
            ((View)convertView).setTag(viewHolder);
        } else {
            viewHolder = (DefaultContactViewItem.ViewHolder)((View)convertView).getTag();
        }

        if (user != null) {
            int resId;
            String iconUrl;
            if (user.containsKey("fia")) {
                viewHolder.tvName.setText(String.valueOf(user.get("nickname")));
                viewHolder.tvContact.setVisibility(0);
                iconUrl = (String)user.get("displayname");
                if (TextUtils.isEmpty(iconUrl)) {
                    viewHolder.tvContact.setText(String.valueOf(user.get("phone")));
                } else {
                    viewHolder.tvContact.setText(iconUrl);
                }

                resId = R.getStringRes(parent.getContext(), "smssdk_add_contact");
                if (resId > 0) {
                    viewHolder.btnAdd.setText(resId);
                }
            } else {
                iconUrl = (String)user.get("displayname");
                if (TextUtils.isEmpty(iconUrl)) {
                    ArrayList<HashMap<String, Object>> phones = (ArrayList)user.get("phones");
                    if (phones != null && phones.size() > 0) {
                        String cp = (String)((HashMap)phones.get(0)).get("phone");
                        viewHolder.tvName.setText(cp);
                    }
                } else {
                    viewHolder.tvName.setText(iconUrl);
                }

                viewHolder.tvContact.setVisibility(8);
                resId = R.getStringRes(parent.getContext(), "smssdk_invite");
                if (resId > 0) {
                    viewHolder.btnAdd.setText(resId);
                }
            }

            viewHolder.bg.setBackgroundColor(-1);
            if (user.containsKey("isnew")) {
                boolean isNew = Boolean.valueOf(String.valueOf(user.get("isnew")));
                if (isNew) {
                    viewHolder.bg.setBackgroundColor(-525057);
                }
            }

            iconUrl = user.containsKey("avatar") ? (String)user.get("avatar") : null;
            resId = R.getBitmapRes(parent.getContext(), "smssdk_cp_default_avatar");
            if (resId > 0) {
                viewHolder.ivContact.execute((String)null, resId);
            }

            if (!TextUtils.isEmpty(iconUrl)) {
                Log.w(user.get("displayname") + " icon url ==>> ", iconUrl);
                Bitmap bm = BitmapProcessor.getBitmapFromCache(iconUrl);
                if (bm != null && !bm.isRecycled()) {
                    viewHolder.ivContact.setImageBitmap(bm);
                } else {
                    viewHolder.ivContact.execute(iconUrl, resId);
                }
            }

            viewHolder.btnAdd.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (user.containsKey("fia")) {
                        Toast.makeText(parent.getContext(), String.valueOf(user), 0).show();
                    } else {
                        ContactDetailPage contactDetailPage = new ContactDetailPage();
                        contactDetailPage.setContact(user);
                        contactDetailPage.show(parent.getContext(), (Intent)null);
                    }

                }
            });
        }

        return (View)convertView;
    }

    public class ViewHolder {
        public View bg;
        public AsyncImageView ivContact;
        public TextView tvName;
        public TextView tvContact;
        public Button btnAdd;

        public ViewHolder() {
        }
    }
}
