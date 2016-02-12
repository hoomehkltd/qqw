package me.next.slidebottompanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by NeXT on 15/8/3.
 */
public class DarkFrameLayout extends FrameLayout {

    public static final int MAX_ALPHA = 0X9f;

    private int alpha = 0x00;
    private Paint mFadePaint;

    private SlideBottomPanel slideBottomPanel;

    public DarkFrameLayout(Context context) {
        this(context, null);
        Log.d("position1","");
    }

    public DarkFrameLayout(Context context, AttributeSet attrs) {

        this(context, attrs, 0);
        Log.d("position1", "");
    }

    public DarkFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("position1", "");
//        mFadePaint = new Paint();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.d("position1", "");
//        drawFade(canvas);
    }

    private void drawFade(Canvas canvas) {
//        mFadePaint.setColor(Color.argb(alpha, 0, 0, 0));
//        canvas.drawRect(0, 0, getMeasuredWidth(), getHeight(), mFadePaint);
    }

    public void fade(boolean fade) {
//        alpha = fade ? 0x8f : 0x00;
//        invalidate();
    }

    public void fade(int alpha) {
        this.alpha = alpha;
        invalidate();
        Log.d("position1", "");
    }

    public void fade() {
        invalidate();
        Log.d("position1", "");
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return slideBottomPanel.isPanelShowing();
    }

    public int getCurrentAlpha() {
        return alpha;
    }

    public void setSlideBottomPanel(SlideBottomPanel slideBottomPanel) {
        this.slideBottomPanel = slideBottomPanel;
    }
}
