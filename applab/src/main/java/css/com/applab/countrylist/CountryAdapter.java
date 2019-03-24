package css.com.applab.countrylist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.mob.tools.utils.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import cn.smssdk.SMSSDK;
import cn.smssdk.gui.GroupListView.GroupAdapter;
import cn.smssdk.gui.layout.SizeHelper;
import cn.smssdk.utils.SMSLog;

public class CountryAdapter extends GroupAdapter {
    private HashMap<Character, ArrayList<String[]>> rawData = SMSSDK.getGroupedCountryList();
    private ArrayList<String> titles;
    private ArrayList<ArrayList<String[]>> countries;
    private cn.smssdk.gui.SearchEngine sEngine;

    public CountryAdapter(cn.smssdk.gui.GroupListView view) {
        super(view);
        this.initSearchEngine();
        this.search((String)null);
    }

    private void initSearchEngine() {
        this.sEngine = new cn.smssdk.gui.SearchEngine();
        ArrayList<String> countries = new ArrayList();
        Iterator var2 = this.rawData.entrySet().iterator();

        while(var2.hasNext()) {
            Entry<Character, ArrayList<String[]>> ent = (Entry)var2.next();
            ArrayList<String[]> cl = (ArrayList)ent.getValue();
            Iterator var5 = cl.iterator();

            while(var5.hasNext()) {
                String[] paire = (String[])var5.next();
                countries.add(paire[0]);
            }
        }

        this.sEngine.setIndex(countries);
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
        this.countries = new ArrayList();
        var5 = this.rawData.entrySet().iterator();

        label37:
        while(var5.hasNext()) {
            Entry<Character, ArrayList<String[]>> ent = (Entry)var5.next();
            ArrayList<String[]> cl = (ArrayList)ent.getValue();
            ArrayList<String[]> list = new ArrayList();
            Iterator var9 = cl.iterator();

            while(true) {
                String[] paire;
                do {
                    if (!var9.hasNext()) {
                        if (list.size() > 0) {
                            this.titles.add(String.valueOf(ent.getKey()));
                            this.countries.add(list);
                        }
                        continue label37;
                    }

                    paire = (String[])var9.next();
                } while(!isEmptyToken && !resMap.containsKey(paire[0]));

                list.add(paire);
            }
        }

    }

    public int getGroupCount() {
        return this.titles == null ? 0 : this.titles.size();
    }

    public int getCount(int group) {
        if (this.countries == null) {
            return 0;
        } else {
            ArrayList<String[]> list = (ArrayList)this.countries.get(group);
            return list == null ? 0 : list.size();
        }
    }

    public String getGroupTitle(int group) {
        return this.titles.size() != 0 ? ((String)this.titles.get(group)).toString() : null;
    }

    public String[] getItem(int group, int position) {
        String[] countriesArray = null;
        if (this.countries.size() != 0) {
            try {
                countriesArray = (String[])((ArrayList)this.countries.get(group)).get(position);
            } catch (Throwable var5) {
                SMSLog.getInstance().w(var5);
            }

            return countriesArray;
        } else {
            return null;
        }
    }

    public View getTitleView(int group, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            LinearLayout ll = new LinearLayout(parent.getContext());
            ll.setOrientation(1);
            ll.setBackgroundColor(-1);
            convertView = ll;
            SizeHelper.prepare(parent.getContext());
            tv = new TextView(parent.getContext());
            tv.setTextSize(0, (float)SizeHelper.fromPxWidth(16));
            int resId = R.getColorRes(parent.getContext(), "smssdk_lv_title_color");
            if (resId > 0) {
                tv.setTextColor(parent.getContext().getResources().getColor(resId));
            }

            int dp_6 = SizeHelper.fromPxWidth(14);
            tv.setPadding(0, dp_6, 0, dp_6);
            tv.setLayoutParams(new LayoutParams(-1, -2));
            ll.addView(tv);
            View vDiv = new View(parent.getContext());
            vDiv.setBackgroundColor(-1842205);
            ll.addView(vDiv, new LayoutParams(-1, 1));
        }

        String title = this.getGroupTitle(group);
        tv = (TextView)((LinearLayout)convertView).getChildAt(0);
        tv.setText(title);
        return (View)convertView;
    }

    public void onGroupChange(View titleView, String title) {
        TextView tv = (TextView)((LinearLayout)titleView).getChildAt(0);
        tv.setText(title);
    }

    public View getView(int group, int position, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            LinearLayout ll = new LinearLayout(parent.getContext());
            ll.setBackgroundColor(-1);
            convertView = ll;
            SizeHelper.prepare(parent.getContext());
            tv = new TextView(parent.getContext());
            int resId = R.getColorRes(parent.getContext(), "smssdk_lv_tv_color");
            if (resId > 0) {
                tv.setTextColor(parent.getContext().getResources().getColor(resId));
            }

            tv.setTextSize(0, (float)SizeHelper.fromPxWidth(24));
            int dp_16 = SizeHelper.fromPxWidth(30);
            tv.setPadding(0, dp_16, 0, dp_16);
            ll.addView(tv, new LayoutParams(-1, -2));
        }

        String[] data = this.getItem(group, position);
        if (data != null) {
            tv = (TextView)((LinearLayout)convertView).getChildAt(0);
            tv.setText(data[0]);
        }

        return (View)convertView;
    }
}
