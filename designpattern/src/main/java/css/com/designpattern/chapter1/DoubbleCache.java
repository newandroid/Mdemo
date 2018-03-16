package css.com.designpattern.chapter1;

import android.graphics.Bitmap;

/**
 * Created by css on 2018-03-16.
 */

public class DoubbleCache implements ImageCache {
    MemoryCache memoryCache = new MemoryCache();
    DiskCache diskCache = new DiskCache();

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
            if(bitmap!=null)
            memoryCache.put(url, bitmap);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }
}
