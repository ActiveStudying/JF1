package vn.edu.activestudy.activestudy.task.activateOTP;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.activestudy.activestudy.ASApplication;
import vn.edu.activestudy.activestudy.ASController;
import vn.edu.activestudy.activestudy.callback.TaskListener;
import vn.edu.activestudy.activestudy.common.Constants;
import vn.edu.activestudy.activestudy.common.ResponseCode;
import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.util.PreferenceUtil;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ActivateOtpCMD {
    private static final String TAG = ActivateOtpCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_ACTIVE_CODE;

    public static void execute(Context context, String otpCode, final TaskListener listener) throws JSONException {

        String activationId = PreferenceUtil.getString(context, Constants.PREFERENCE_ACTIVATION_ID, "");
        String accountId = PreferenceUtil.getString(context, Constants.PREFERENCE_ACCOUNT_ID, "");

        RequestActivateOTP request = new RequestActivateOTP();
        request.setAccountId(accountId);
        request.setActivationId(activationId);
        request.setOtpCode(otpCode);
        request.setDeviceId(PreferenceUtil.getString(ASApplication.getContext(), Constants.PREFERENCE_DEVICE_ID, ""));

        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseActivateOTP resp = new Gson().fromJson(response.toString(), ResponseActivateOTP.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseActivateOTP resp = new ResponseActivateOTP();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "activate_otp_request");
    }
}
