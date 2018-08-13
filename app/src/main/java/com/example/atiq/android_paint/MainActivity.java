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
    private Paint paint;
    private float currX, currY;
    private Rect blue, gray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


}
