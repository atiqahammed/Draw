package com.example.atiq.android_paint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.graphics.PointF;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Desenho";
    private ShapeDrawable rectangle;
    //private Paint paint;
    private float currX, currY;
    private Rect blue, gray;

    Paint paint = new Paint();


    Bitmap bg = Bitmap.createBitmap(480,800, Bitmap.Config.ARGB_8888);
    Canvas can = new Canvas(bg);




    public static final boolean DEBUG_SHOW_POINTS = false;
    public static final int POINT_TYPE_SAMPLED = 1;
    public static final int POINT_TYPE_INTERPOLATED = 2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        paint.setAntiAlias(false);
        currX = event.getX();
        currY = event.getY();
        //invalidate();
        float radious  = (float) 1.0;
        System.out.println(currX +" ,,, " + currY);

        can.drawCircle(currX, currY, radious, paint);
        paint.setAntiAlias(true);
        //Log.d(TAG, "View's On touch is called! X= "+currX + ", Y= "+currY);
        return super.onTouchEvent(event);
    }




}
