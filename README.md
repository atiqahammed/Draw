# Android-Paint

## Drawing on touch
Initially I was trying to implement some functionality with which I could drow something touching the screen. Following code helped me i that case.

```java
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentXCoordinate = event.getX();
        currentYCoordinate = event.getY();
        float radious  = (float) 30.0;
        
        canvas.drawCircle(currentXCoordinate, currentYCoordinate, radious, paint);
        LinearLayout l1 = (LinearLayout)findViewById(R.id.drawarea);
        l1.setBackgroundDrawable(new BitmapDrawable(myBitMap));
        return super.onTouchEvent(event);
    }
