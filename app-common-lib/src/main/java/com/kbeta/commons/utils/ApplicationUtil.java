/**
 *
 * Copyright 2014 Travo, Inc. All rights reserved.
 * AppliationUtil.java
 *
 */
package com.kbeta.commons.utils;

import android.content.Context;

/**
 * @author: dk
 * @date:2016/3/22
 * @email:dk-26@163.com
 */
public class ApplicationUtil
{
    private static Context context;
    
    public static void init(Context context)
    {
        if(context == null)
            throw new IllegalArgumentException("context cannot be null!");
        ApplicationUtil.context = context;
    }
    
    public static Context getContext()
    {
        if(context == null)
            throw new IllegalArgumentException("context cannot be null!");
        return context;
    }

}
