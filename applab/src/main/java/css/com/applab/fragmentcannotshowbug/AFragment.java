package css.com.applab.fragmentcannotshowbug;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentTransaction;
import css.com.applab.R;

public class AFragment extends BaseLazyFragment {

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_a,container,false);
        return result;
    }

    @Override
    protected void initData() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        BFragment b = new BFragment();
        fragmentTransaction.add(R.id.root,b);
        fragmentTransaction.commit();
    }
}
