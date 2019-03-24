package css.com.applab.countrylist;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import css.com.applab.R;

public class ContactsListView extends RelativeLayout {
    private ListView lvBody;
    private ContactsListView.InnerAdapter innerAdapter;
    private ContactsListView.GroupAdapter adapter;
    private TextView tvTitle;
    private int curFirstItem;
    private int titleHeight;
    private OnScrollListener osListener;

    public ContactsListView(Context context) {
        super(context);
        this.init(context);
    }

    public ContactsListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public ContactsListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init(context);
    }

    private void init(Context context) {
        this.lvBody = new ListView(context);
        this.lvBody.setCacheColorHint(0);
        this.lvBody.setSelector(new ColorDrawable());
        int resId = R.getBitmapRes(context, "smssdk_cl_divider");
        if (resId > 0) {
            this.lvBody.setDivider(context.getResources().getDrawable(resId));
        }

        this.lvBody.setDividerHeight(1);
        this.lvBody.setVerticalScrollBarEnabled(false);
        this.lvBody.setOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (ContactsListView.this.osListener != null) {
                    ContactsListView.this.osListener.onScrollStateChanged(view, scrollState);
                }

            }

            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                ContactsListView.this.curFirstItem = firstVisibleItem;
                if (ContactsListView.this.tvTitle != null) {
                    ContactsListView.this.onScroll();
                }

                if (ContactsListView.this.osListener != null) {
                    ContactsListView.this.osListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
                }

            }
        });
        this.lvBody.setLayoutParams(new LayoutParams(-1, -1));
        this.addView(this.lvBody);
    }

    public void setAdapter(ContactsListView.GroupAdapter adapter) {
        this.adapter = adapter;
        this.innerAdapter = new ContactsListView.InnerAdapter(adapter);
        this.lvBody.setAdapter(this.innerAdapter);
        this.setTitle();
    }

    public ContactsListView.GroupAdapter getAdapter() {
        return this.adapter;
    }

    private void notifyDataSetChanged() {
        this.innerAdapter.notifyDataSetChanged();
        this.setTitle();
    }

    private void setTitle() {
        if (this.tvTitle != null) {
            this.removeView(this.tvTitle);
        }

        if (this.innerAdapter.getCount() != 0) {
            int group = this.innerAdapter.getItemGroup(this.curFirstItem);
            int position = (Integer)this.innerAdapter.titleIndex.get(group);
            this.tvTitle = (TextView)this.innerAdapter.getView(position, (View)null, this);
            LayoutParams lp = new LayoutParams(-1, -2);
            lp.addRule(9);
            lp.addRule(10);
            this.addView(this.tvTitle, lp);
            this.tvTitle.measure(0, 0);
            this.titleHeight = this.tvTitle.getMeasuredHeight();
            this.onScroll();
        }
    }

    public void setSelection(int group) {
        this.setSelection(group, -1);
    }

    public void setSelection(int group, int position) {
        int titleIndex = (Integer)this.innerAdapter.titleIndex.get(group);
        int selection = titleIndex + position + 1;
        this.lvBody.setSelection(selection);
    }

    private void onScroll() {
        LayoutParams lp = (LayoutParams)this.tvTitle.getLayoutParams();
        int group;
        String title;
        if (this.innerAdapter.isLastItem(this.curFirstItem)) {
            group = this.innerAdapter.getItemGroup(this.curFirstItem);
            title = this.adapter.getGroupTitle(group);
            this.tvTitle.setText(title);
            int top = this.lvBody.getChildAt(1).getTop();
            if (top < this.titleHeight) {
                lp.setMargins(0, top - this.titleHeight, 0, 0);
                this.tvTitle.setLayoutParams(lp);
                return;
            }
        }

        lp.topMargin = 0;
        this.tvTitle.setLayoutParams(lp);
        if (this.innerAdapter.isTitle(this.curFirstItem)) {
            group = this.innerAdapter.getItemGroup(this.curFirstItem);
            title = this.adapter.getGroupTitle(group);
            this.tvTitle.setText(title);
        }

    }

    public void setOnScrollListener(OnScrollListener l) {
        this.osListener = l;
    }

    public abstract static class GroupAdapter {
        protected final ContactsListView view;

        public GroupAdapter(ContactsListView view) {
            this.view = view;
        }

        public abstract int getGroupCount();

        public abstract int getCount(int var1);

        public abstract String getGroupTitle(int var1);

        public abstract Object getItem(int var1, int var2);

        public abstract TextView getTitleView(int var1, TextView var2, ViewGroup var3);

        public abstract View getView(int var1, int var2, View var3, ViewGroup var4);

        public void notifyDataSetChanged() {
            this.view.notifyDataSetChanged();
        }
    }

    private static class InnerAdapter extends BaseAdapter {
        private ContactsListView.GroupAdapter adapter;
        private ArrayList<Object> listData;
        private ArrayList<Integer> titleIndex;
        private ArrayList<Integer> lastItemIndex;

        public InnerAdapter(ContactsListView.GroupAdapter adapter) {
            this.adapter = adapter;
            this.listData = new ArrayList();
            this.titleIndex = new ArrayList();
            this.lastItemIndex = new ArrayList();
            this.init();
        }

        private void init() {
            this.listData.clear();
            this.titleIndex.clear();
            this.lastItemIndex.clear();
            int g = 0;

            for(int gc = this.adapter.getGroupCount(); g < gc; ++g) {
                int c = this.adapter.getCount(g);
                if (c > 0) {
                    this.titleIndex.add(this.listData.size());
                    this.listData.add(this.adapter.getGroupTitle(g));

                    for(int i = 0; i < c; ++i) {
                        this.listData.add(this.adapter.getItem(g, i));
                    }

                    this.lastItemIndex.add(this.listData.size() - 1);
                }
            }

        }

        public int getCount() {
            return this.listData.size();
        }

        public Object getItem(int position) {
            return this.listData.get(position);
        }

        public long getItemId(int position) {
            return (long)position;
        }

        public int getItemGroup(int position) {
            int size = this.titleIndex.size();

            for(int i = 0; i < size; ++i) {
                int titleIndex = (Integer)this.titleIndex.get(i);
                if (position < titleIndex) {
                    return i - 1;
                }
            }

            return size - 1;
        }

        public boolean isTitle(int position) {
            int i = 0;

            for(int size = this.titleIndex.size(); i < size; ++i) {
                if ((Integer)this.titleIndex.get(i) == position) {
                    return true;
                }
            }

            return false;
        }

        public int getViewTypeCount() {
            return 2;
        }

        public int getItemViewType(int position) {
            return this.isTitle(position) ? 0 : 1;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            int group = this.getItemGroup(position);
            Object convertView;
            if (this.isTitle(position)) {
                if (convertView != null && convertView instanceof TextView) {
                    convertView = this.adapter.getTitleView(group, (TextView)convertView, parent);
                } else {
                    convertView = this.adapter.getTitleView(group, (TextView)null, parent);
                }
            } else {
                int item = position - (Integer)this.titleIndex.get(group) - 1;
                convertView = this.adapter.getView(group, item, convertView, parent);
            }

            return (View)convertView;
        }

        public void notifyDataSetChanged() {
            this.init();
            super.notifyDataSetChanged();
        }

        public boolean isLastItem(int position) {
            int i = 0;

            for(int size = this.lastItemIndex.size(); i < size; ++i) {
                if ((Integer)this.lastItemIndex.get(i) == position) {
                    return true;
                }
            }

            return false;
        }
    }
}
