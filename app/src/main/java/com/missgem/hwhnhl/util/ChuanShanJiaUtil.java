package com.missgem.hwhnhl.util;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;

public class ChuanShanJiaUtil {
    public static float getScreenWidthDp(Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        float width = context.getResources().getDisplayMetrics().widthPixels;
        return width / (scale <= 0 ? 1 : scale) + 0.5f;
    }

    //全面屏、刘海屏适配
//    public static float getHeight(Activity activity) {
//        hideBottomUIMenu(activity);
//        float height;
//        int realHeight = getRealHeight(activity);
//        if (ChuanShanJiaUtil.hasNotchScreen(activity)) {
//            height = px2dip(activity, realHeight - getStatusBarHeight(activity));
//        } else {
//            height = px2dip(activity, realHeight);
//        }
//        return height;
//    }

    public static void hideBottomUIMenu(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            //隐藏虚拟按键，并且全屏
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
                View v = activity.getWindow().getDecorView();
                v.setSystemUiVisibility(View.GONE);
            } else if (Build.VERSION.SDK_INT >= 19) {
                //for new api versions.
                View decorView = activity.getWindow().getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        //                    | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE;
                decorView.setSystemUiVisibility(uiOptions);
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取屏幕真实高度，不包含下方虚拟导航栏
    public static int getRealHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealMetrics(dm);
        } else {
            display.getMetrics(dm);
        }
        int realHeight = dm.heightPixels;
        return realHeight;
    }

    //获取状态栏高度
    public static float getStatusBarHeight(Context context) {
        float height = 0;
        int resourceId = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = context.getApplicationContext().getResources().getDimensionPixelSize(resourceId);
        }
        return height;
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / (scale <= 0 ? 1 : scale) + 0.5f);
    }

    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * 判断是否是刘海屏
     *
     * @return
     */
//    public static boolean hasNotchScreen(Activity activity) {
//        return isAndroidPHasNotch(activity)
//                || getInt("ro.miui.notch", activity) == 1
//                || hasNotchAtHuawei(activity)
//                || hasNotchAtOPPO(activity)
//                || hasNotchAtVivo(activity);
//    }

    /**
     * Android P 刘海屏判断
     *
     * @param activity
     * @return
     */
    public static boolean isAndroidPHasNotch(Activity activity) {
        boolean result = false;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            DisplayCutout displayCutout = null;
            try {
                WindowInsets windowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                if (windowInsets != null) {
                    displayCutout = windowInsets.getDisplayCutout();
                }
                if (displayCutout != null) {
                    result = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 小米刘海屏判断.
     *
     * @return 0 if it is not notch ; return 1 means notch
     * @throws IllegalArgumentException if the key exceeds 32 characters
     */
//    public static int getInt(String key, Activity activity) {
//        int result = 0;
//        if (isMiui()) {
//            try {
//                ClassLoader classLoader = activity.getClassLoader();
//                @SuppressWarnings("rawtypes")
//                Class SystemProperties = classLoader.loadClass("android.os.SystemProperties");
//                //参数类型
//                @SuppressWarnings("rawtypes")
//                Class[] paramTypes = new Class[2];
//                paramTypes[0] = String.class;
//                paramTypes[1] = int.class;
//                Method getInt = SystemProperties.getMethod("getInt", paramTypes);
//                //参数
//                Object[] params = new Object[2];
//                params[0] = new String(key);
//                params[1] = new Integer(0);
//                result = (Integer) getInt.invoke(SystemProperties, params);
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }

}