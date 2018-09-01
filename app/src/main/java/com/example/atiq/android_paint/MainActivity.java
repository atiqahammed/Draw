package com.example.atiq.android_paint;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MY Painting";
    private float currentXCoordinate, currentYCoordinate;
    private Paint paint;
    private Bitmap myBitMap;
    private Canvas canvas;
    private int GALLARY_REQUEST = 1, CAPTURE_REQUEST = 11;
    private static String capturedImagePath;
    private Uri file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);



        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        //Log.e("Width", "" + width);
        //Log.e("height", "" + height);


        myBitMap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(myBitMap);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentXCoordinate = event.getX();
        currentYCoordinate = event.getY();
        float radious  = (float) 30.0;
        canvas.drawCircle(currentXCoordinate, currentYCoordinate, radious, paint);
        LinearLayout layout = (LinearLayout)findViewById(R.id.drawarea);
        layout.setBackgroundDrawable(new BitmapDrawable(myBitMap));
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {


        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            //  Toast.makeText(this, "Drawing has been saved", Toast.LENGTH_SHORT).show();

            //return true;
        }

        try {

            File dir = new File(Environment.getExternalStorageDirectory(), "Test");
            if (!dir.exists() || !dir.isDirectory())
                dir.mkdirs();

            String path = dir.getAbsolutePath();
            //Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
            //Log.d(TAG, path);                     //log show the path
            // File file = new File(dir.getAbsolutePath() + "/Pic.jpg");
            //Log.d(TAG, file.getAbsolutePath());   //again path is shown here

            File file = new File(new File(path), "abc.jpg");

            Canvas canvas = new Canvas(myBitMap);

                FileOutputStream mFileOutStream = new FileOutputStream(file);

                //v.draw(canvas);
                myBitMap.compress(Bitmap.CompressFormat.PNG, 90, mFileOutStream);

                mFileOutStream.flush();
                mFileOutStream.close();
                String url = MediaStore.Images.Media.insertImage(getContentResolver(),
                        myBitMap, "title", null);

                Toast.makeText(this, "URI: " + url, Toast.LENGTH_SHORT).show();

                OutputStream outStream = new FileOutputStream(file);
                //String bytes = "khdfkas";
                //outStream.write(bytes.getBytes());
                //outStream.close();
                //Log.d(TAG, "onPictureTaken - wrote bytes: " + bytes.length);   //fail here
            } catch (FileNotFoundException e) {
                Log.d(TAG, "not done");                       //error is here (this exception is thrown)
            } catch (IOException e) {
                Log.d(TAG, "not");
            } finally {
            }





    /*
    int n = 1;

        Intent camera = new Intent(
                android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        //Folder is already created
        String dirName = Environment.getExternalStorageDirectory().getPath()
                + "/Test" + n + ".png";

        Uri uriSavedImage = Uri.fromFile(new File(dirName));
        camera.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        startActivityForResult(camera, 1);

        n++;


       // File filew = getPublicAlbumStorageDir("test");

        //Toast.makeText(this, "Drawing has been saved", Toast.LENGTH_SHORT).show();
        /*
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        */

        }

    /*

    public File getPublicAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
           // Log.e(LOG_TAG, "Directory not created");
            Toast.makeText(this, "not created", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(this, "created", Toast.LENGTH_SHORT).show();
        return file;
    }*/



}
