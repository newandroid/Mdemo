package css.com.designpattern.chapter1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileOutputStream;

/**
 * Created by css on 2018-03-13.
 */

public class DiskCache implements ImageCache{
    private static final String cacheDir = "sdcard/cache/";

    @Override
    public  Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }

    @Override
    public  void put(String url,Bitmap bitmap){
        try (FileOutputStream outputStream = new FileOutputStream(cacheDir+url)){
            bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
