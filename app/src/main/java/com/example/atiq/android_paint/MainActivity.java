package com.example.atiq.android_paint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.graphics.PointF;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        //

        for(int j=0; j< 31; j++)
        {

            for(int i=0; i<23;i++)
            {
                RectF rectF1 = new RectF(left1,top1,right1,bottom1);
                can.drawArc(rectF1, 0, 180, false, paint);

                left1 = right1;
                right1 = left1+20;
            }
            System.out.println("\n");

            left1 = 10;
            top1 = bottom1 + 1;
            right1 = 30;
            bottom1 = 30+top1 - 6;

        }

        LinearLayout l1 = (LinearLayout)findViewById(R.id.drawarea);
        l1.setBackgroundDrawable(new BitmapDrawable(bg));

    }

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        Toast.makeText(this, "there was a touch", Toast.LENGTH_SHORT).show();


       // mPreviousX = x;
        //mPreviousY = y;
        return true;
    }


}
