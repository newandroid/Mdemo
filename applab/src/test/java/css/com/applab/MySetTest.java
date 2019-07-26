package css.com.applab;

import android.bluetooth.le.ScanResult;

import androidx.annotation.Nullable;

/**
 * create by css on 2019/7/23
 */
public class MySetTest {
    private ScanResult scanResult;

    public MySetTest(ScanResult scanResult) {
        this.scanResult = scanResult;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        return scanResult.getDevice().getAddress().equals(((MySetTest) obj).scanResult.getDevice().getAddress());
    }

    @Override
    public int hashCode() {
        return scanResult.getDevice().getAddress().hashCode();
    }
}
