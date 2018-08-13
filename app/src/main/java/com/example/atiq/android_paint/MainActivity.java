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
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.graphics.PointF;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MY Painting";
    private float currX, currY;
    private Paint paint = new Paint();
    private Bitmap bg = Bitmap.createBitmap(480,800, Bitmap.Config.ARGB_8888);
    private Canvas can = new Canvas(bg);


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
        currX = event.getX();
        currY = event.getY();
        float radious  = (float) 30.0;
        System.out.println(currX +" ,,, " + currY);
        can.drawCircle(currX, currY, radious, paint);
        LinearLayout l1 = (LinearLayout)findViewById(R.id.drawarea);
        l1.setBackgroundDrawable(new BitmapDrawable(bg));
        return super.onTouchEvent(event);
    }
}
