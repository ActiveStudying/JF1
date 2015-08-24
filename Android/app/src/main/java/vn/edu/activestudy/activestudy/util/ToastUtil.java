package vn.edu.activestudy.activestudy.util;

import android.widget.Toast;

import vn.edu.activestudy.activestudy.ASApplication;

/**
 * Created by bamboo1391 on 28/05/2015.
 */
public class ToastUtil {

    public static void makeToast(String content) {
        Toast.makeText(ASApplication.getContext(), content, Toast.LENGTH_SHORT).show();
    }

    public static void makeLongToast(String content) {
        Toast.makeText(ASApplication.getContext(), content, Toast.LENGTH_LONG).show();
    }

}
