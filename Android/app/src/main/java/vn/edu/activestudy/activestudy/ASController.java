package vn.edu.activestudy.activestudy;

import android.content.Context;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;

import vn.edu.activestudy.activestudy.common.Constants;

/**
 * Created by dell123 on 8/17/2015.
 */
public class ASController {

    private static ASController mInstance;

    public static ASController getInstance() {
        if (mInstance == null) {
            mInstance = new ASController();
        }
        return mInstance;
    }

    public String getRegistrationID(Context context) {
        String regID = GCMRegistrar.getRegistrationId(context);
        if (regID.length() == 0) {
            GCMRegistrar.register(context, Constants.PROJECT_NUMBER);
            regID = GCMRegistrar.getRegistrationId(context);
        }
        Log.d("ASController", regID);
        return regID;
    }

}
