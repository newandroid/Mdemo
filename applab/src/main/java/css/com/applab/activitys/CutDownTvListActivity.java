package css.com.applab.activitys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import css.com.applab.R;
import css.com.applab.view.CountdownTv;

public class CutDownTvListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    List<Bean> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_down_tv_list);
        recyclerView = findViewById(R.id.recycleView);
        adapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.HORIZONTAL));

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        refresh();
        findViewById(R.id.btn).setOnClickListener(v -> {
//            refresh();
            adapter.notifyDataSetChanged();
        });
    }

    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cutdown_list, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            System.out.println("MyAdapter.onBindViewHolder position:" + position);
            Bean item = datas.get(position);
            holder.textView.start(item.getLastTimestap(), item.getPeriodSecond(), item.isOn());
            holder.positionTv.setText(String.valueOf(position));
            holder.switchView.setChecked(!CountdownTv.isNeedStopTimer(item.getLastTimestap(), item.getPeriodSecond(), item.isOn()));
            holder.switchView.setOnClickListener(v -> {
                item.isOn = !item.isOn;
                item.setLastTimestap(System.currentTimeMillis());
                recyclerView.post(() -> {
                    notifyItemChanged(position);
                });

            });
            holder.textView.setListener(() -> {
                recyclerView.post(() -> {
                    System.out.println("position:" + position + " holder.textView:" + holder.textView);
                    notifyItemChanged(position);
                });
            });
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
    }

    private static class MyHolder extends RecyclerView.ViewHolder {
        CountdownTv textView;
        Switch switchView;
        TextView positionTv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.contentTv);
            switchView = itemView.findViewById(R.id.switchView);
            positionTv = itemView.findViewById(R.id.positionTv);

        }
    }

    private class Bean {
        private boolean isOn;
        private long lastTimestap;
        private int periodSecond;

        public boolean isOn() {
            return isOn;
        }

        public void setOn(boolean on) {
            isOn = on;
        }

        public long getLastTimestap() {
            return lastTimestap;
        }

        public void setLastTimestap(long lastTimestap) {
            this.lastTimestap = lastTimestap;
        }

        public int getPeriodSecond() {
            return periodSecond;
        }

        public void setPeriodSecond(int periodSecond) {
            this.periodSecond = periodSecond;
        }
    }

    private void refresh() {
        datas.clear();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Bean bean = new Bean();
            bean.lastTimestap = currentTimeMillis;
            bean.isOn = false;
            bean.periodSecond = 20;
            datas.add(bean);
        }
        recyclerView.post(() -> {
            adapter.notifyDataSetChanged();
        });

    }
}
