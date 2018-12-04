package css.com.applab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import css.com.applab.R;


/**
 * Created by RG on 2016/5/19.
 */
public class ShareUserAdapter extends BaseAdapter {

    private Context mContext;

    private OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onRemove(int position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return new Object();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout_share_users, null, false);
            holder = new ViewHolder();
            holder.iv = convertView.findViewById(R.id.item);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView iv;
    }

}
