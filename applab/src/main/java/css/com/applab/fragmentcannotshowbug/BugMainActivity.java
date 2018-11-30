package css.com.applab.fragmentcannotshowbug;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import css.com.applab.R;

public class BugMainActivity extends AppCompatActivity {

    AFragment aFragment1;
    AFragment aFragment2;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.hide(aFragment2);
                    fragmentTransaction.show(aFragment1);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.hide(aFragment1);
                    fragmentTransaction2.show(aFragment2);
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        aFragment1 = new AFragment();
        aFragment2 = new AFragment();
        fragmentTransaction.add(R.id.fragmentcontainer,aFragment1,aFragment1.toString());
        fragmentTransaction.hide(aFragment1);
        fragmentTransaction.add(R.id.fragmentcontainer,aFragment2,aFragment2.toString());
        fragmentTransaction.hide(aFragment2);
        fragmentTransaction.show(aFragment1);
        fragmentTransaction.commit();
    }

}
