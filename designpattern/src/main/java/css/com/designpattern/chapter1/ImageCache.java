package css.com.designpattern.chapter1;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by css on 2018-03-13.
 */

public class ImageCache {
    LruCache<String, Bitmap> imageCache;

    public ImageCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        imageCache = new LruCache<String, Bitmap>(maxMemory) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public Bitmap get(String url) {
        return imageCache.get(url);
    }

    public void put(String url, Bitmap bitmap) {
        imageCache.put(url, bitmap);
    }

}
