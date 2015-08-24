package vn.edu.activestudy.activestudy;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.google.android.gcm.GCMBaseIntentService;

import vn.edu.activestudy.activestudy.common.Constants;

public class GCMIntentService extends GCMBaseIntentService {

    private static final String TAG = "GCMIntentService";

    public GCMIntentService() {
        super(Constants.PROJECT_NUMBER);
    }

    @Override
    protected void onMessage(Context context, Intent intent) {

    }

    @Override
    protected void onError(Context context, String s) {

    }

    @Override
    protected void onRegistered(Context context, String s) {

    }

    @Override
    protected void onUnregistered(Context context, String s) {

    }

}
