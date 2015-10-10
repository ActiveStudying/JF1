package vn.edu.activestudy.activestudy.task.getusergroup;

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
import vn.edu.activestudy.activestudy.util.Utils;

/**
 * Created by dell123 on 8/28/2015.
 */
public class GetUserGroupCMD {
    private static final String TAG = GetUserGroupCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_GET_USER_GROUP;

    public static void execute(final TaskListener listener) throws JSONException {

        RequestGetUserGroup request = new RequestGetUserGroup();
        request.setAccountId(Utils.getAccountID());
        request.setDeviceId(Utils.getDeviceID());
        request.setSessionId(Utils.getSessionID());

        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseGetUserGroup resp = new Gson().fromJson(response.toString(), ResponseGetUserGroup.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseGetUserGroup resp = new ResponseGetUserGroup();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "GetUserGroupCMD");
    }
}
