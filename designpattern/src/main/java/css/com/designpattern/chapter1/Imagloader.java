package css.com.designpattern.chapter1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by css on 2018-
 */

public class Imagloader {
    LruCache<String, Bitmap> imageCache;
    ExecutorService executorService
            = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Imagloader() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        imageCache = new LruCache<String, Bitmap>(maxMemory) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void displayImage(final String url, final ImageView imageView, Activity context){
        imageView.setTag(url);
        executorService.submit(() -> {
            Bitmap bitmap = downloadImage(url);
            if (bitmap==null)return;
            if (imageView.getTag().equals(url)){
                context.runOnUiThread(() -> imageView.setImageBitmap(bitmap));
            }
            imageCache.put(url,bitmap);
        });
    }

    public Bitmap downloadImage(String urlStr){
        Bitmap bitmap = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
}
