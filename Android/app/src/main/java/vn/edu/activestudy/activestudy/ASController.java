package vn.edu.activestudy.activestudy;

import android.content.Context;
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
import vn.edu.activestudy.activestudy.model.entity.DeviceInfo;
import vn.edu.activestudy.activestudy.task.activate.ActivateCMD;
import vn.edu.activestudy.activestudy.task.activate.ResponseActivate;
import vn.edu.activestudy.activestudy.task.activate.ResultDataActivate;
import vn.edu.activestudy.activestudy.util.ToastUtil;
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

    public void activate(final String accountId, DeviceInfo deviceInfo) {
        try {
            ActivateCMD.execute(accountId, deviceInfo, new TaskListener() {
                @Override
                public void onResult(Object resp) {
                    ResponseActivate response = (ResponseActivate) resp;
                    Result result = response.getResult();
                    switch (result.getCode()) {
                        case ResponseCode.SUCCESS:
                            ResultDataActivate resultData = (ResultDataActivate) response.getResultData();

                            String activationId = resultData.getActivationId();
                            ToastUtil.makeLongToast(activationId);
                            //TODO: process continue response

                            break;
                        case ResponseCode.ERROR:
                            break;
                        case ResponseCode.SYSTEM_ERROR:
                            break;

                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
