package vn.edu.activestudy.activestudy.task.updateaccountinfo;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.activestudy.activestudy.ASController;
import vn.edu.activestudy.activestudy.callback.TaskListener;
import vn.edu.activestudy.activestudy.common.Constants;
import vn.edu.activestudy.activestudy.common.ResponseCode;
import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.getaccountinfo.RequestGetAccountInfo;
import vn.edu.activestudy.activestudy.util.PreferenceUtil;

/**
 * Created by dell123 on 8/28/2015.
 */
public class UpdateAccountInfoCMD {
    private static final String TAG = UpdateAccountInfoCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_UPDATE_ACCOUNT_INFO;

    public static void execute(Context context, final TaskListener listener) throws JSONException {

        String sessionId = PreferenceUtil.getString(context, Constants.PREFERENCE_SESSION_ID, "");
        String accountId = PreferenceUtil.getString(context, Constants.PREFERENCE_ACCOUNT_ID, "");
        String deviceId = PreferenceUtil.getString(context, Constants.PREFERENCE_DEVICE_ID, "");

        RequestUpdateAccInfo request = new RequestUpdateAccInfo();
        request.setAccountId(accountId);
        request.setDeviceId(deviceId);
        request.setSessionId(sessionId);

        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseUpdateAccInfo resp = new Gson().fromJson(response.toString(), ResponseUpdateAccInfo.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseUpdateAccInfo resp = new ResponseUpdateAccInfo();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "updateAccountInfo");
    }
}
