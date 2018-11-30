package css.com.applab.fragmentcannotshowbug;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import css.com.applab.R;

public class BFragment extends BaseLazyFragment {
    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_b,container,false);
        return result;
    }

    @Override
    protected void initData() {

    }
}
