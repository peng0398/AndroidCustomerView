package com.bob.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Author: bob
 * Date: 16-5-11.
 */
public class DragView extends LinearLayout {

    int lastX;
    int lastY;

    Scroller scroller;

    public DragView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        scroller = new Scroller(context);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:

                int deltaX = x - lastX;
                int deltaY = y - lastY;

                int transX = (int) (this.getTranslationX() + deltaX);
                int transY = (int) (this.getTranslationY() + deltaY);

                this.setTranslationX(transX);
                this.setTranslationY(transY);

                Log.i("DragView", "x: " + transX + " y: " + transY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        lastX = x;
        lastY = y;

        if (MotionEvent.ACTION_MOVE == event.getAction()) {
            return true;
        } else {
            return super.onTouchEvent(event);
        }
    }

    public void smoothScrollTo(int x, int y) {
        int scrollX = getScrollX();
        scroller.startScroll(scrollX, 0, 0 - x, 0, 1000);
        invalidate();
    }


    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }
}
