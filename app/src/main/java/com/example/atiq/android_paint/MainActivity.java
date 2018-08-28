package com.example.atiq.android_paint;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.graphics.PointF;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStream;

import java.io.File;
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

        FileOutputStream outputStream;
        String filename = "myfile";
        String fileContents = "Hello world!";
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



       // File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "DCIM");
        //myBitMap.compress(Bitmap.CompressFormat.PNG, 100, file);


        Toast.makeText(this, "Drawing has been saved", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void captureProblemPhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

        startActivityForResult(intent, CAPTURE_REQUEST);
    }


    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "ComplainBoxPhoto");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        capturedImagePath = mediaStorageDir.getPath() + File.separator + "IMG_"+ timeStamp + ".jpg";
        return new File(capturedImagePath);
    }

}
