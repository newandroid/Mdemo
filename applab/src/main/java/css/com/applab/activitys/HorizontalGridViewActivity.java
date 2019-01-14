package css.com.applab.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.widget.HorizontalGridView;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalGridViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HorizontalGridView recyclerView = new HorizontalGridView(this);
        setContentView(recyclerView);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        recyclerView.setLayoutParams(layoutParams);
        recyclerView.setNumRows(5);
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(new Button(parent.getContext())){};
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                TextView itemView = (TextView) holder.itemView;
                itemView.setText(""+position);
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });
    }
}
