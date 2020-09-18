package com.example.leeeyou.sampleofcustomview.demo7.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by leeeyou on 16/5/5.
 */
public class CustomLayout extends ViewGroup {

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int parentDesireWidth = 0;
        int parentDesireHeight = 0;

        if (getChildCount() > 0) {

            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);

                CustomLayoutParams layoutParams = (CustomLayoutParams) childAt.getLayoutParams();

                measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);

                parentDesireWidth += childAt.getMeasuredWidth()
                        + layoutParams.leftMargin
                        + layoutParams.rightMargin;
                parentDesireHeight += childAt.getMeasuredHeight()
                        + layoutParams.topMargin
                        + layoutParams.bottomMargin;
            }

            parentDesireWidth += getPaddingLeft() + getPaddingRight();
            parentDesireHeight += getPaddingTop() + getPaddingBottom();

            parentDesireWidth = Math.max(parentDesireWidth, getSuggestedMinimumWidth());
            parentDesireHeight = Math.max(parentDesireHeight, getSuggestedMinimumHeight());

            //resolveSize 这个方法的主要作用就是根据你提供的大小和模式，返回你想要的大小值，这个里面根据传入模式的不同来做相应的处理。
            setMeasuredDimension(resolveSize(parentDesireWidth, widthMeasureSpec),
                    resolveSize(parentDesireHeight, heightMeasureSpec));
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int parentPaddingTop = getPaddingTop();
        int parentPaddingLeft = getPaddingLeft();

        if (getChildCount() > 0) {

            int mutilHeight = 0;

            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);

                CustomLayoutParams childLayoutParams = (CustomLayoutParams) child.getLayoutParams();

                child.layout(parentPaddingLeft + childLayoutParams.leftMargin,
                        mutilHeight + parentPaddingTop + childLayoutParams.topMargin,
                        child.getMeasuredWidth() + parentPaddingLeft + childLayoutParams.leftMargin,
                        child.getMeasuredHeight() + mutilHeight + parentPaddingTop + childLayoutParams.topMargin);

                mutilHeight += child.getMeasuredHeight()
                        + childLayoutParams.topMargin
                        + childLayoutParams.bottomMargin;
            }
        }
    }

    private class CustomLayoutParams extends MarginLayoutParams {

        public CustomLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public CustomLayoutParams(int width, int height) {
            super(width, height);
        }

        public CustomLayoutParams(MarginLayoutParams source) {
            super(source);
        }

        public CustomLayoutParams(LayoutParams source) {
            super(source);
        }
    }

    @Override
    protected CustomLayoutParams generateDefaultLayoutParams() {
        return new CustomLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new CustomLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new CustomLayoutParams(getContext(), attrs);
    }

    @Override
    protected boolean checkLayoutParams(LayoutParams p) {
        return p instanceof CustomLayoutParams;
    }
}
