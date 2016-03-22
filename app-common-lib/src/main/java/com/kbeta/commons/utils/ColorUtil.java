package com.kbeta.commons.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;

/**
 * @author: dk
 * @date:2016/3/22
 * @email:dk-26@163.com
 */
public class ColorUtil {
	public static int getColor(int id){
		return ApplicationUtil.getContext().getResources().getColor(id);
	}

    public static int getColor(Context context, int id) {
        return context.getResources().getColor(id);
    }

    public static int getColor(String str, int def) {
        if (TextUtils.isEmpty(str)) {
            return def;
        }
        try {
            int v = Integer.valueOf(str);
            return getColorByInt(v);
        } catch (Exception e) {
            return def;
        }
    }

    public static int getColorByInt(int color) {
        return 0xFF000000 | color;
    }

    public static ColorStateList getColorList(int id)
    {
        return ApplicationUtil.getContext().getResources().getColorStateList(id);
    }

    public static int parseColorFromInt(int color){
        return Color.parseColor(String.format("#%06X", 0xFFFFFF & color));
    }
}
