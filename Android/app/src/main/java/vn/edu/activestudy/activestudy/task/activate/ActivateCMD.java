package vn.edu.activestudy.activestudy.task.activate;

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
import vn.edu.activestudy.activestudy.model.entity.DeviceInfo;
import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 8/24/2015.
 */
public class ActivateCMD {

    private static final String TAG = ActivateCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_ACTIVE;

    public static void execute(String accountId, DeviceInfo deviceInfo, final TaskListener listener) throws JSONException {
        RequestActivate request = new RequestActivate();
        request.setAccountId(accountId);
        request.setDeviceInfo(deviceInfo);

        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseActivate resp = new Gson().fromJson(response.toString(), ResponseActivate.class);
                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                ResponseActivate resp = new ResponseActivate();
                Result result = new Result();
                result.setCode(ResponseCode.ERROR);
                resp.setResult(result);
                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "activate_request");
    }

}
