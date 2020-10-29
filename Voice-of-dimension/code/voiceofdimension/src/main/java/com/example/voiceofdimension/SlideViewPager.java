package com.example.voiceofdimension;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class SlideViewPager extends ViewPager {

    private boolean isCanScroll = true;

    public SlideViewPager(Context context) {
        super(context);

    }

    public SlideViewPager(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    //设置能否换页
    public void setIsScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x,y);
    }


    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        // TODO Auto-generated method stub
        if (isCanScroll) {
            return super.onTouchEvent(arg0);
        } else {
            return false;
        }

    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        // TODO Auto-generated method stub
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        // TODO Auto-generated method stub
        super.setCurrentItem(item);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        // 是否允许滑动
        if (isCanScroll) {
            return super.onInterceptTouchEvent(arg0);
        } else {
            return false;
        }

    }
}
