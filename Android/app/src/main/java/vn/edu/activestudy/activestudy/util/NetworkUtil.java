package vn.edu.activestudy.activestudy.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
	
	public static synchronized boolean isNetworkAvailable(Context context) {
		ConnectivityManager conMgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();
		if (networkInfo == null) {
			return false;
		}
		if (!networkInfo.isConnected()) {
			return false;
		}
		if (!networkInfo.isAvailable()) {
			return false;
		}
		return true;
	}
}
