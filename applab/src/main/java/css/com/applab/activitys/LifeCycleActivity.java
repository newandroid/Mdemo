package css.com.applab.activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import css.com.applab.R;
import css.com.applab.fragments.LifeCycleFragment;

public class LifeCycleActivity extends AppCompatActivity {
    private static final String TAG = "LifeCycleActivity";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fragmentcontainer,new LifeCycleFragment());
        LifeCycleFragment lifeCycleFragment = new LifeCycleFragment();
        fragmentTransaction.add(R.id.fragmentcontainer, lifeCycleFragment, "flag");
        fragmentTransaction.addToBackStack("hahah");
        int commit = fragmentTransaction.commit();
        button.setOnClickListener(v -> {
//            supportFragmentManager.popBackStackImmediate("flag", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            supportFragmentManager.popBackStackImmediate("hahah", FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            fragmentTransaction.remove(lifeCycleFragment);
//            supportFragmentManager.popBackStack("hahah",);

        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "], outPersistentState = [" + outPersistentState + "]");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onStateNotSaved() {
        Log.d(TAG, "onStateNotSaved() called");
        super.onStateNotSaved();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.d(TAG, "onWindowFocusChanged() called with: hasFocus = [" + hasFocus + "]");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }
}
