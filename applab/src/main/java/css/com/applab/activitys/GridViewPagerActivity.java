package css.com.applab.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridPagerAdapter;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class GridViewPagerActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridViewPager gridViewPager = new GridViewPager(this);
        setContentView(gridViewPager);
        ViewGroup.LayoutParams layoutParams = gridViewPager.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        gridViewPager.setAdapter(new GridPagerAdapter() {
            @Override
            public int getRowCount() {
                return 1;
            }

            @Override
            public int getColumnCount(int row) {
                return 4;
            }

            @Override
            public View instantiateItem(ViewGroup container, int row, int column) {
                Button button = new Button(GridViewPagerActivity.this);
                button.setWidth(100);
                button.setHeight(100);
                button.setText("row:" + row + " column:" + column);
                container.addView(button);
                return button;
            }

            @Override
            public void destroyItem(ViewGroup container, int row, int column, Object object) {
                container.removeView((View) object);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view.equals(object) ;
            }
        });
    }
}
