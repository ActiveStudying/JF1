package vn.edu.activestudy.activestudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.google.android.gcm.GCMRegistrar;

import org.json.JSONException;

import vn.edu.activestudy.activestudy.callback.TaskListener;
import vn.edu.activestudy.activestudy.common.Constants;
import vn.edu.activestudy.activestudy.common.ResponseCode;
import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.activate.ActivateCMD;
import vn.edu.activestudy.activestudy.task.activate.ResponseActivate;
import vn.edu.activestudy.activestudy.task.activate.ResultDataActivate;
import vn.edu.activestudy.activestudy.task.activateOTP.ActivateOtpCMD;
import vn.edu.activestudy.activestudy.task.activateOTP.ResponseActivateOTP;
import vn.edu.activestudy.activestudy.task.activateOTP.ResultDataActivateOtp;
import vn.edu.activestudy.activestudy.util.PreferenceUtil;
import vn.edu.activestudy.activestudy.util.network.LruBitmapCache;

/**
 * Created by dell123 on 8/17/2015.
 */
public class ASController {

    private final String TAG = ASController.class.getSimpleName();
    private static ASController mInstance;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private Context mContext;

    public ASController() {
        mContext = ASApplication.getContext();
    }

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

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext);
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    public void activate(final String accountId) {
        Log.d(TAG, "start activate");
        try {
            ActivateCMD.execute(accountId, new TaskListener() {
                @Override
                public void onResult(Object resp) {
                    ResponseActivate response = (ResponseActivate) resp;
                    Result result = response.getResult();
                    Log.d(TAG, "RESPONSE ACTIVATE: " + result.getCode());
                    Intent intent = new Intent(Constants.INTENT_ACTIVATE_COMPLETE);
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.INTENT_KEY, result.getCode());
                    switch (result.getCode()) {
                        case ResponseCode.ERROR:
                            Log.d(TAG, "RESPONSE ACTIVATE: ERROR");
                            break;
                        case ResponseCode.SYSTEM_ERROR:
                            Log.d(TAG, "RESPONSE ACTIVATE: SYSTEM ERROR");

                            break;
                        case ResponseCode.SUCCESS:
                            Log.d(TAG, "RESPONSE ACTIVATE: SUCCESS");

                            ResultDataActivate resultData = response.getResultData();

                            String activationId = resultData.getActivationId();

                            PreferenceUtil.setString(mContext, Constants.PREFERENCE_ACCOUNT_ID, accountId);
                            PreferenceUtil.setString(mContext, Constants.PREFERENCE_ACTIVATION_ID, activationId);

                            break;
                        case ResponseCode.MAUTHEN_ACCOUNTID_INVALIDFORMAT:
                            Log.d(TAG, "RESPONSE ACTIVATE: MAUTHEN ACCOUNTID INVALIDFORMAT");

                            break;
                        case ResponseCode.MAUTHEN_ACCOUNTID_UNEXIST:
                            Log.d(TAG, "RESPONSE ACTIVATE: MAUTHEN ACCOUNTID UNEXIST");

                            break;
                        case ResponseCode.MAUTHEN_DEVICEID_EMPTY:
                            Log.d(TAG, "RESPONSE ACTIVATE: MAUTHEN DEVICEID EMPTY");

                            break;
                    }
                    intent.putExtras(bundle);
                    mContext.sendBroadcast(intent);

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void activeWithOTP(String otp) {
        Log.d(TAG, "start activate wih otp");
        try {
            ActivateOtpCMD.execute(mContext, otp, new TaskListener() {
                @Override
                public void onResult(Object resp) {
                    ResponseActivateOTP response = (ResponseActivateOTP) resp;
                    Result result = response.getResult();
                    Log.d(TAG, "RESPONSE ACTIVATE: " + result.getCode());

                    Intent intent = new Intent(Constants.INTENT_ACTIVATE_WITH_OTP_COMPLETE);
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.INTENT_KEY, result.getCode());

                    switch (result.getCode()) {
                        case ResponseCode.ERROR:
                            Log.d(TAG, "RESPONSE ACTIVATE: ERROR");
                            break;
                        case ResponseCode.SYSTEM_ERROR:
                            Log.d(TAG, "RESPONSE ACTIVATE: SYSTEM ERROR");

                            break;
                        case ResponseCode.SUCCESS:
                            Log.d(TAG, "RESPONSE ACTIVATE: SUCCESS");

                            ResultDataActivateOtp resultData = response.getResultData();

                            String authenId = resultData.getAuthenId();

                            PreferenceUtil.setString(mContext, Constants.PREFERENCE_AUTHEN_ID, authenId);

                            break;
                        case ResponseCode.MAUTHEN_ACCOUNTID_INVALIDFORMAT:
                            Log.d(TAG, "RESPONSE ACTIVATE: MAUTHEN ACCOUNTID INVALIDFORMAT");

                            break;
                        case ResponseCode.MAUTHEN_ACCOUNTID_UNEXIST:
                            Log.d(TAG, "RESPONSE ACTIVATE: MAUTHEN ACCOUNTID UNEXIST");

                            break;
                        case ResponseCode.MAUTHEN_OTPCODE_INVALIDFORMAT:
                            Log.d(TAG, "RESPONSE ACTIVATE: MAUTHEN OTPCODE INVALIDFORMAT");

                            break;
                        case ResponseCode.OVER_NUMBERRETRY_OTPCODE:
                            Log.d(TAG, "RESPONSE ACTIVATE: OVER NUMBERRETRY OTPCODE");

                            break;
                    }
                    intent.putExtras(bundle);
                    mContext.sendBroadcast(intent);
                }
            });
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }


}
