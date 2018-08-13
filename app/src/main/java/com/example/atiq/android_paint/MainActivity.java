package com.example.atiq.android_paint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Desenho";

    private ShapeDrawable rectangle;
    private Paint paint;
    private float currX, currY;
    private Rect blue, gray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

        Bitmap bg = Bitmap.createBitmap(480,800, Bitmap.Config.ARGB_8888);
        Canvas can = new Canvas(bg);

        int left1 = 10;
        int top1 = 10;
        int right1 = 30;
        int bottom1 = 30;



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currX = event.getX();
        currY = event.getY();
        //invalidate();
        System.out.println(currX +" ,,, " + currY);
        //Log.d(TAG, "View's On touch is called! X= "+currX + ", Y= "+currY);
        return super.onTouchEvent(event);
    }

    // pause of master for touch listener
}
