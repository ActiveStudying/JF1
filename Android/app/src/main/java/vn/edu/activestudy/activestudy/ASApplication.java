package vn.edu.activestudy.activestudy;

import android.app.Application;
import android.content.Context;

import com.orm.SugarApp;

/**
 * Created by dell123 on 8/24/2015.
 */
public class ASApplication extends SugarApp {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
