
/*
 * PreferenceUtils.java
 *
 * Date: 01-Nov-2013
 * 
 * Modification Logs:
 * DATE        AUTHOR  DESCRIPTION
 *  ---------------------------------------------- *
 * 03-Nov-2013 BaVV    
 */

package vn.edu.activestudy.activestudy.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class PreferenceUtil {
	
    private static final String TAG = PreferenceUtil.class.getSimpleName();

    private static final String PREFERENCE_NAME = "edu.activestudy";
    private static final int PREFERENCE_MODE = Context.MODE_PRIVATE;
 
    private PreferenceUtil() {
    	
    }
    
    public static boolean getBoolean(final Context context, final String key) {
    	final SharedPreferences pref = getPreference(context);
    	return pref.getBoolean(key, false);
    }

    public static void setBoolean(final Context context, final String key, final boolean value) {
    	final SharedPreferences pref = getPreference(context);
        final Editor editor = pref.edit();
        
        editor.putBoolean(key, value);
        boolean result = editor.commit();
        Log.i(TAG, "*** COMMIT BOOLEAN RESULT = " + result + "  " + key + " = " + value);
    }

    public static String getString(final Context context, final String key, final String defValue) {
        final SharedPreferences pref = getPreference(context);
        return pref.getString(key, defValue);
    }

    public static void setString(final Context context, final String key, final String value) {
        final SharedPreferences pref = getPreference(context);
        final Editor editor = pref.edit();
        editor.putString(key, value);
        boolean result = editor.commit();
        Log.i(TAG, "*** COMMIT STRING RESULT = " + result + "  " + key + " = " + value);
    }

    public static int getInt(final Context context, final String key, final int defValue) {
        final SharedPreferences pref = getPreference(context);
        return pref.getInt(key, defValue);
    }

    public static void setInt(final Context context, final String key, final int value) {
        final SharedPreferences pref = getPreference(context);
        final Editor editor = pref.edit();
        editor.putInt(key, value);
        boolean result = editor.commit();
        Log.i(TAG, "*** COMMIT INTEGER RESULT = " + result + "  " + key + " = " + value);
    }

    public static long getLong(final Context context, final String key) {
        final SharedPreferences pref = getPreference(context);
        return pref.getLong(key, -1L);
    }

    public static void setLong(final Context context, final String key, final long value) {
        final SharedPreferences pref = getPreference(context);
        final Editor editor = pref.edit();
        editor.putLong(key, value);
        boolean result = editor.commit();
        Log.i(TAG, "*** COMMIT LONG RESULT = " + result + "  " + key + " = " + value);
    }

	public static void resetPref(final Context context) {
		final SharedPreferences pref = getPreference(context);
        final Editor editor = pref.edit();
        
        editor.clear();
        editor.commit();
	}
	
    private static SharedPreferences getPreference(final Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME, PREFERENCE_MODE);
    }

}

