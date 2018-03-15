package css.com.designpattern.chapter1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by css on 2018-
 */

public class ImageLoader {
    ImageCache imageCache;
    ExecutorService executorService
            = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    Activity context;

    public ImageLoader() {

    }
    public ImageLoader(Activity context){
        this.context = context;
    }

    public void displayImage(final String url, final ImageView imageView){
        Bitmap oldBitmap = imageCache.get(url);
        if (oldBitmap!=null){
            imageView.setImageBitmap(oldBitmap);
            return;
        }
        imageView.setTag(url);
        executorService.submit(() -> {
            Bitmap bitmap = downloadImage(url);
            if (bitmap==null)return;
            if (imageView.getTag().equals(url)){
                showImageInMainThread(imageView,bitmap);
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

    private void showImageInMainThread(final ImageView imageView,Bitmap bitmap){
       if (context!=null)context.runOnUiThread(() -> imageView.setImageBitmap(bitmap));
    }
}
