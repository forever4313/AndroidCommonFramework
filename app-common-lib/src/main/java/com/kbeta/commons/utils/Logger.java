package com.kbeta.commons.utils;

import android.util.Log;

import java.util.Date;

public class Logger
{
    private static final String LOGTAG = "MY_app";

    public enum SCOPE {
        NETWORK     (0x00000001),
        IMAGELOADER (0x00000010),
        EXCEPTION   (0x00000100),
        FRAMEWORK   (0x00001000),
        ALL         (0x00001111);

        private int code;

        SCOPE(int i) {
            code = i;
        }

        public int getCode() {
            return code;
        }
    }

    private static DebugScope debugScopes = new DebugScope();

    private static Date curretTime;

    public static void initDebugLog()
    {
        debugScopes.turnOn(SCOPE.ALL).turnOff(SCOPE.IMAGELOADER);
    }

    public static void log(SCOPE scope, String clz, String msg)
    {
        innerPrint(scope, clz, msg);
    }

    public static void log(SCOPE scope, String msg)
    {
        log(scope, null, msg);
    }
    
    public static void log(String clz, String msg)
    {
        log(SCOPE.ALL, clz, msg);
    }

    public static void log(String clz, Throwable e)
    {
        log(SCOPE.EXCEPTION, clz, e.getMessage());
    }

    private static void innerPrint(SCOPE scope, String clz, String msg)
    {
        if (!debugScopes.contains(scope))
            return;
        if (clz == null || clz.trim().length() == 0)
        {
            Log.d(LOGTAG, scope.name() + " :: " + msg);
        }
        else
        {
            Log.d(LOGTAG, scope.name() + " :: " + clz + ": " + msg);
        }
    }


    private static class DebugScope {
        private int code = 0;

        public boolean contains(SCOPE scope) {
            return (code & scope.getCode()) != 0;
        }

        public DebugScope turnOn(SCOPE scope) {
            code |= scope.getCode();
            return this;
        }

        public DebugScope turnOff(SCOPE scope) {
            code &= (~scope.getCode() & SCOPE.ALL.getCode());
            return this;
        }
    }
}
