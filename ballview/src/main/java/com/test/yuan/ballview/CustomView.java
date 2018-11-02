package com.test.yuan.ballview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;



/**
 * date:2018/11/01
 * author:袁明磊(123)
 * function:
 */
class CustomView extends View {

    Paint paint;
    int cx;
    int cy;
    int w;
    int h;
    boolean math;

    //创建point对象 参数为x坐标和y坐标

   // PointF point = new PointF(100,100);
    // Rect rect = new Rect();

    public CustomView(Context context) {
        super(context);
        initData();
    }

   public CustomView(Context context, AttributeSet attr){
        super(context,attr);
       initData();
   }

    public CustomView(Context context, AttributeSet attr,int sef)
    {
        super(context,attr,sef);
        initData();
    }


    private void initData() {
        paint=new Paint();
        //设置画笔颜色
        paint.setColor(Color.RED);

        //设置画笔的宽度
        paint.setStrokeWidth(20);
        //设置一个实心的
        paint.setStyle(Paint.Style.FILL);
        //抗锯齿
        paint.setAntiAlias(true);
    }


        //参数为圆的横坐标 ,纵坐标,半径,创建
        //如果圆形出不来 说明你xml里定义的宽和高的空间不够大 这里是圆在屏幕的坐标位置 xml定义的是圆能够显示的区域 如果你定义的太小 圆的坐标又超过了这个区域 就会显示不出来 xml里定义宽和高充满屏幕就可以了

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = this.getWidth();

        int height = this.getHeight();

        cx =  width/2;
        cy = height/2;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            //当手指按下会触发ACTION_DOWN

            case MotionEvent.ACTION_DOWN:

                  int x = (int) event.getX();
                  int y = (int) event.getY();
                   math = idMath(x, y);
                   postInvalidate();//该方法会调用onDraw方法，重新绘图
                 break;


            //当手指滑动会触发ACTION_MOVE
            case MotionEvent.ACTION_MOVE:
                // 移动
                if(math){
                    cx = (int) event.getX();
                    cy = (int) event.getY();
                    postInvalidate();
                }


                break;
                //当手指抬起会触发ACTION_UP
            case MotionEvent.ACTION_UP:

                break;
        }
        /*
         * 备注1：此处一定要将return super.onTouchEvent(event)修改为return true，原因是：
         * 1）父类的onTouchEvent(event)方法可能没有做任何处理，但是返回了false。
         * 2)一旦返回false，在该方法中再也不会收到MotionEvent.ACTION_MOVE及MotionEvent.ACTION_UP事件。
         */
        //return super.onTouchEvent(event);
        return true;
    }

    private boolean idMath(int x, int y) {
        double result =  Math.sqrt((x - cx) * (x - cx) + (y - cy) * (y - cy));
        if(result<=100){
            return true;
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        canvas.drawCircle(cx,cy,100,paint);

    }

             /*
             * 备注1：此处一定要将return super.onTouchEvent(event)修改为return true，原因是：
             * 1）父类的onTouchEvent(event)方法可能没有做任何处理，但是返回了false。
             * 2)一旦返回false，在该方法中再也不会收到MotionEvent.ACTION_MOVE及MotionEvent.ACTION_UP事件。
             */


}
