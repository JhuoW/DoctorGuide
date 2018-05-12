package com.xzmc.zzzt.doctorguide.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.xzmc.zzzt.doctorguide.App;
import com.xzmc.zzzt.doctorguide.R;

/**
 * Created by zw on 17/6/10.
 */

public class Utils {
    /**
     * 隐藏软键盘显示
     *
     * @param activity
     */
    public static void hideSoftInputView(Activity activity) {
        if (activity.getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            InputMethodManager manager = (InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                manager.hideSoftInputFromWindow(currentFocus.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
    public static void goActivity(Context cxt, Class<?> clz) {
        Intent intent = new Intent(cxt, clz);
        cxt.startActivity(intent);
        ((Activity) cxt).overridePendingTransition(R.anim.slide_in_right,
                R.anim.slide_out_left);
    }

}
