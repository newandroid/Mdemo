package css.com.applab.countrylist;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class GroupListView extends RelativeLayout {
    private ListView lvBody;
    private GroupListView.InnerAdapter innerAdapter;
    private GroupListView.GroupAdapter adapter;
    private View tvTitle;
    private int curFirstItem;
    private int titleHeight;
    private OnScrollListener osListener;
    private GroupListView.OnItemClickListener oicListener;

    public GroupListView(Context context) {
        super(context);
        this.init(context);
    }

    public GroupListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public GroupListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init(context);
    }

    private void init(Context context) {
        this.lvBody = new ListView(context);
        this.lvBody.setCacheColorHint(0);
        this.lvBody.setSelector(new ColorDrawable());
        this.lvBody.setVerticalScrollBarEnabled(false);
        this.lvBody.setOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (GroupListView.this.osListener != null) {
                    GroupListView.this.osListener.onScrollStateChanged(view, scrollState);
                }

            }

            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                GroupListView.this.curFirstItem = firstVisibleItem;
                if (GroupListView.this.tvTitle != null) {
                    GroupListView.this.onScroll();
                }

                if (GroupListView.this.osListener != null) {
                    GroupListView.this.osListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
                }

            }
        });
        this.lvBody.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                if (GroupListView.this.oicListener != null) {
                    int group = GroupListView.this.innerAdapter.getItemGroup(position);
                    int item = position - (Integer)GroupListView.this.innerAdapter.titleIndex.get(group) - 1;
                    GroupListView.this.oicListener.onItemClick(GroupListView.this, view, group, item);
                }

            }
        });
        this.lvBody.setLayoutParams(new LayoutParams(-1, -1));
        this.addView(this.lvBody);
    }

    public void setDividerHeight(int height) {
        this.lvBody.setDividerHeight(height);
    }

    public void setDivider(Drawable divider) {
        this.lvBody.setDivider(divider);
    }

    public void setAdapter(GroupListView.GroupAdapter adapter) {
        this.adapter = adapter;
        this.innerAdapter = new GroupListView.InnerAdapter(adapter);
        this.lvBody.setAdapter(this.innerAdapter);
        this.setTitle();
    }

    public GroupListView.GroupAdapter getAdapter() {
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
            this.tvTitle = this.innerAdapter.getView(position, (View)null, this);
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
            this.adapter.onGroupChange(this.tvTitle, title);
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
            this.adapter.onGroupChange(this.tvTitle, title);
        }

    }

    public void setOnScrollListener(OnScrollListener l) {
        this.osListener = l;
    }

    public void setOnItemClickListener(GroupListView.OnItemClickListener listener) {
        this.oicListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(GroupListView var1, View var2, int var3, int var4);
    }

    public abstract static class GroupAdapter {
        protected final GroupListView view;

        public GroupAdapter(GroupListView view) {
            this.view = view;
        }

        public abstract int getGroupCount();

        public abstract int getCount(int var1);

        public abstract String getGroupTitle(int var1);

        public abstract Object getItem(int var1, int var2);

        public abstract View getTitleView(int var1, View var2, ViewGroup var3);

        public abstract View getView(int var1, int var2, View var3, ViewGroup var4);

        public void notifyDataSetChanged() {
            this.view.notifyDataSetChanged();
        }

        public abstract void onGroupChange(View var1, String var2);
    }

    private static class InnerAdapter extends BaseAdapter {
        private GroupListView.GroupAdapter adapter;
        private ArrayList<Object> listData;
        private ArrayList<Integer> titleIndex;
        private ArrayList<Integer> lastItemIndex;

        public InnerAdapter(GroupListView.GroupAdapter adapter) {
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
            if (this.isTitle(position)) {
                if (convertView != null) {
                    convertView = this.adapter.getTitleView(group, convertView, parent);
                } else {
                    convertView = this.adapter.getTitleView(group, (View)null, parent);
                }
            } else {
                int item = position - (Integer)this.titleIndex.get(group) - 1;
                convertView = this.adapter.getView(group, item, convertView, parent);
            }

            return convertView;
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
