package com.kbeta.commons.utils;

import android.content.Context;

/**
 * ScreenUtils
 * <ul>
 * <strong>Convert between dp and sp</strong>
 * <li>{@link DensityUtils#dpToPx(Context, float)}</li>
 * <li>{@link DensityUtils#pxToDp(Context, float)}</li>
 * </ul>
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-14
 */
public class DensityUtils {

    private static float density = -1F;
    private static int widthPixels = -1;
    private static int heightPixels = -1;


    private DensityUtils() {
        throw new AssertionError();
    }


    public static float dpToPx(Context context, float dp) {
        if (context == null) {
            return -1;
        }
        return dp * getDensity();
    }

    public static float pxToDp(Context context, float px) {
        if (context == null) {
            return -1;
        }
        return px / getDensity();
    }

    public static int dpToPxInt(Context context, float dp) {
        return (int)(dpToPx(context, dp) + 0.5f);
    }

    public static int pxToDpCeilInt(Context context, float px) {
        return (int)(pxToDp(context, px) + 0.5f);
    }

    public static float getDensity() {
        if (density <= 0F) {
            density = ApplicationUtil.getContext().getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int getScreenWidth() {
        if (widthPixels <= 0) {
            widthPixels = ApplicationUtil.getContext().getResources().getDisplayMetrics().widthPixels;
        }
        return widthPixels;
    }


    public static int getScreenHeight() {
        if (heightPixels <= 0) {
            heightPixels = ApplicationUtil.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        return heightPixels;
    }

}
