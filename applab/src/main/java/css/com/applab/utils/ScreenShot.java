package com.dashuf.disp.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import css.com.applab.utils.BitmapUtil;

/**
 * Function:
 * Created by dubin on 2016/10/8.
 */

public class ScreenShot {
    // 获取指定Activity的截屏，保存到png文件
    public static Bitmap takeScreenShot(Activity activity) {
        // View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();

        // 获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        System.out.println(statusBarHeight);

        // 获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay()
                .getHeight();
        // 去掉标题栏
        // Bitmap b = Bitmap.createBitmap(b1, 0, 25, 320, 455);
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        savePic(b, "/sdcard/screen_test.png");
        return b;
    }

    // 保存到sdcard
    public static void savePic(Bitmap b, String strFileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strFileName);
            if (null != fos) {
                b.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String writeToSDCard(Bitmap bitmap) {
        String filePath = "";
        Date date = new Date();
        String savePath = "/DCIM/Camera/";
        File photoFile;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); // 格式化时间
        String filename = format.format(date) + ".jpg";
        File fileFolder = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            fileFolder = new File(Environment.getExternalStorageDirectory()
                    + savePath);
        } else {
            fileFolder = new File(Environment.getRootDirectory()
                    + savePath);
        }
        if (!fileFolder.exists()) {
            fileFolder.mkdir();
        }
        photoFile = new File(fileFolder, filename);
        FileOutputStream outputStream = null; // 文件输出流
        try {
            outputStream = new FileOutputStream(photoFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            filePath = photoFile.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }

    /**
     * 把View对象转换成bitmap
     * */
    public static Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        if (bitmap != null) {
            System.out.println("这不是nullde1");
            Log.d(TAG, "nullde1");
        } else {
            System.out.println("这nullnulllnulnlul");
        }
        return bitmap;
    }

    // 程序入口1
    public static void shoot(Activity a) {
        ScreenShot.savePic(ScreenShot.takeScreenShot(a), "/sdcard/screen_test.png");
    }

    // 程序入口2
    public static void shootView(View view) {
        ScreenShot.savePic(ScreenShot.convertViewToBitmap(view),
                "sdcard/xx.png");
    }

    public static Bitmap getViewBitmap(View v,boolean compress) {
        v.clearFocus();
        v.setPressed(false);

        boolean willNotCache = v.willNotCacheDrawing();
        v.setWillNotCacheDrawing(false);

        // Reset the drawing cache background color to fully transparent
        // for the duration of this operation
        int color = v.getDrawingCacheBackgroundColor();
        v.setDrawingCacheBackgroundColor(0);

        if (color != 0) {
            v.destroyDrawingCache();
        }
        v.buildDrawingCache();
        Bitmap cacheBitmap = v.getDrawingCache();
        if (cacheBitmap == null) {
            Log.e("screenShot", "failed getViewBitmap(" + v + ")"+
                    new RuntimeException());
            return null;
        }

        Bitmap bitmap = null;
        if (compress) {
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)) {
                    out.flush();
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            bitmap = Bitmap.createBitmap(cacheBitmap);
        }
        // Restore the view
        v.destroyDrawingCache();
        v.setWillNotCacheDrawing(willNotCache);
        v.setDrawingCacheBackgroundColor(color);

        return bitmap;
    }

    /**
     * 截取scrollview的屏幕
     * **/
    public static Bitmap getBitmapByView(ScrollView scrollView) {
        int h = 0;
        Bitmap bitmap = null;
        // 获取listView实际高度
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            h += scrollView.getChildAt(i).getHeight();
            scrollView.getChildAt(i).setBackgroundResource(android.R.color.white);
        }
        Log.d(TAG, "实际高度:" + h);
        Log.d(TAG, " 高度:" + scrollView.getHeight());
        // 创建对应大小的bitmap
        bitmap = Bitmap.createBitmap(scrollView.getWidth(), h,
                Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        scrollView.draw(canvas);
        // 测试输出
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream("/sdcard/screen_test.png");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (null != out) {
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
//                out.flush();
//                out.close();
//            }
//        } catch (IOException e) {
//            // TODO: handle exception
//        }
        return bitmap;
    }

    private static String TAG = "screenShot";

    /**
     *  截图listview
     * **/
    public static Bitmap getbBitmap(ListView listView) {
        int h = 0;
        Bitmap bitmap = null;
        // 获取listView实际高度
        for (int i = 0; i < listView.getChildCount(); i++) {
            h += listView.getChildAt(i).getHeight();
        }
        Log.d(TAG, "实际高度:" + h);
        Log.d(TAG, "list 高度:" + listView.getHeight());
        // 创建对应大小的bitmap
        bitmap = Bitmap.createBitmap(listView.getWidth(), h,
                Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        listView.draw(canvas);
        // 测试输出
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream("/sdcard/screen_test.png");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (null != out) {
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
//                out.flush();
//                out.close();
//            }
//        } catch (IOException e) {
//            // TODO: handle exception
//        }
        return bitmap;
    }

}