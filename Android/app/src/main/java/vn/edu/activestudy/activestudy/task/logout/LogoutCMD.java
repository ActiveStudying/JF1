package vn.edu.activestudy.activestudy.task.logout;

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
import vn.edu.activestudy.activestudy.util.PreferenceUtil;

/**
 * Created by dell123 on 8/28/2015.
 */
public class LogoutCMD {
    private static final String TAG = LogoutCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_LOGOUT;

    public static void execute(Context context, final TaskListener listener) throws JSONException {

        String accountId = PreferenceUtil.getString(context, Constants.PREFERENCE_ACCOUNT_ID, "");
        String sessionId = PreferenceUtil.getString(context, Constants.PREFERENCE_SESSION_ID, "");

        RequestLogout request = new RequestLogout();
        request.setAccountId(accountId);
        request.setSessionId(sessionId);

        String json = new Gson().toJson(request);
        Log.d(TAG, url + " " + json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.DELETE, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseLogout resp = new Gson().fromJson(response.toString(), ResponseLogout.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseLogout resp = new ResponseLogout();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "logout_request");
    }
}
