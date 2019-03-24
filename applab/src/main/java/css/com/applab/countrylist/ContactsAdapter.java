package css.com.applab.countrylist;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mob.tools.utils.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import cn.smssdk.gui.ContactsListView.GroupAdapter;
import cn.smssdk.gui.layout.SizeHelper;

public class ContactsAdapter extends GroupAdapter {
    private ArrayList<String> titles;
    private ArrayList<ArrayList<HashMap<String, Object>>> contacts;
    private ArrayList<HashMap<String, Object>> friendsInApp = new ArrayList();
    private ArrayList<HashMap<String, Object>> contactsOutApp = new ArrayList();
    private ContactItemMaker itemMaker;
    private cn.smssdk.gui.SearchEngine sEngine;

    public ContactsAdapter(cn.smssdk.gui.ContactsListView view, ArrayList<HashMap<String, Object>> friendsInApp, ArrayList<HashMap<String, Object>> contactsOutApp) {
        super(view);
        this.friendsInApp = friendsInApp;
        this.contactsOutApp = contactsOutApp;
        this.initSearchEngine();
        this.search((String)null);
    }

    private void initSearchEngine() {
        this.sEngine = new cn.smssdk.gui.SearchEngine();
        ArrayList<String> data = new ArrayList();
        Iterator var2 = this.friendsInApp.iterator();

        HashMap contact;
        String name;
        while(var2.hasNext()) {
            contact = (HashMap)var2.next();
            name = "";
            if (contact.containsKey("displayname")) {
                name = String.valueOf(contact.get("displayname"));
            }

            if (!TextUtils.isEmpty(name)) {
                data.add(name);
            }
        }

        var2 = this.contactsOutApp.iterator();

        while(var2.hasNext()) {
            contact = (HashMap)var2.next();
            name = "";
            if (contact.containsKey("displayname")) {
                name = String.valueOf(contact.get("displayname"));
            }

            if (!TextUtils.isEmpty(name)) {
                data.add(name);
            }
        }

        this.sEngine.setIndex(data);
    }

    public void search(String token) {
        ArrayList<String> res = this.sEngine.match(token);
        boolean isEmptyToken = false;
        if (res == null || res.size() <= 0) {
            res = new ArrayList();
            isEmptyToken = true;
        }

        HashMap<String, String> resMap = new HashMap();
        Iterator var5 = res.iterator();

        while(var5.hasNext()) {
            String r = (String)var5.next();
            resMap.put(r, r);
        }

        this.titles = new ArrayList();
        this.contacts = new ArrayList();
        if (this.friendsInApp.size() > 0) {
            this.reSortFia(resMap, isEmptyToken, this.friendsInApp);
        }

        if (this.contactsOutApp.size() > 0) {
            this.reSortFoa(resMap, isEmptyToken, this.contactsOutApp);
        }

    }

    private void reSortFia(HashMap<String, String> resMap, boolean isEmptyToken, ArrayList<HashMap<String, Object>> data) {
        ArrayList<HashMap<String, Object>> list = new ArrayList();
        Iterator var5 = data.iterator();

        while(true) {
            HashMap contact;
            String name;
            do {
                do {
                    if (!var5.hasNext()) {
                        if (list.size() > 0) {
                            int resId = R.getStringRes(this.view.getContext(), "smssdk_contacts_in_app");
                            if (resId > 0) {
                                this.titles.add(this.view.getContext().getResources().getString(resId));
                            }

                            this.contacts.add(list);
                        }

                        return;
                    }

                    contact = (HashMap)var5.next();
                    name = "";
                    if (contact.containsKey("displayname")) {
                        name = String.valueOf(contact.get("displayname"));
                    }
                } while(TextUtils.isEmpty(name));
            } while(!isEmptyToken && !resMap.containsKey(name));

            list.add(contact);
        }
    }

    private void reSortFoa(HashMap<String, String> resMap, boolean isEmptyToken, ArrayList<HashMap<String, Object>> data) {
        ArrayList<HashMap<String, Object>> list = new ArrayList();
        Iterator var5 = data.iterator();

        while(true) {
            HashMap contact;
            String name;
            do {
                do {
                    if (!var5.hasNext()) {
                        if (list.size() > 0) {
                            int resId = R.getStringRes(this.view.getContext(), "smssdk_contacts_out_app");
                            if (resId > 0) {
                                this.titles.add(this.view.getContext().getResources().getString(resId));
                            }

                            this.contacts.add(list);
                        }

                        return;
                    }

                    contact = (HashMap)var5.next();
                    name = "";
                    if (contact.containsKey("displayname")) {
                        name = String.valueOf(contact.get("displayname"));
                    }
                } while(TextUtils.isEmpty(name));
            } while(!isEmptyToken && !resMap.containsKey(name));

            list.add(contact);
        }
    }

    public void setContactItemMaker(ContactItemMaker itemMaker) {
        this.itemMaker = itemMaker;
    }

    public int getGroupCount() {
        return this.titles == null ? 0 : this.titles.size();
    }

    public int getCount(int group) {
        if (this.contacts == null) {
            return 0;
        } else {
            ArrayList<HashMap<String, Object>> list = (ArrayList)this.contacts.get(group);
            return list == null ? 0 : list.size();
        }
    }

    public String getGroupTitle(int group) {
        return this.titles.size() > 0 ? ((String)this.titles.get(group)).toString() : null;
    }

    public HashMap<String, Object> getItem(int group, int position) {
        return this.contacts.size() > 0 ? (HashMap)((ArrayList)this.contacts.get(group)).get(position) : null;
    }

    public TextView getTitleView(int group, TextView convertView, ViewGroup parent) {
        if (convertView == null) {
            SizeHelper.prepare(parent.getContext());
            convertView = new TextView(parent.getContext());
            convertView.setBackgroundColor(-1382162);
            convertView.setTextSize(0, (float)SizeHelper.fromPxWidth(25));
            convertView.setTextColor(-6710887);
            int padding = SizeHelper.fromPxWidth(18);
            convertView.setPadding(padding, 0, 0, 0);
            convertView.setWidth(-1);
            int height = SizeHelper.fromPxWidth(40);
            convertView.setHeight(height);
            convertView.setGravity(16);
        }

        String title = this.getGroupTitle(group);
        if (!TextUtils.isEmpty(title)) {
            convertView.setText(title);
        }

        return convertView;
    }

    public View getView(int group, int position, View convertView, ViewGroup parent) {
        HashMap<String, Object> data = this.getItem(group, position);
        return this.itemMaker.getView(data, convertView, parent);
    }
}
