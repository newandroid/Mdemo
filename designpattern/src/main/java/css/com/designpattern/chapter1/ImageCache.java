package css.com.designpattern.chapter1;

import android.graphics.Bitmap;

/**
 * Created by css on 2018-03-16.
 */

public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url,Bitmap bitmap);
}
