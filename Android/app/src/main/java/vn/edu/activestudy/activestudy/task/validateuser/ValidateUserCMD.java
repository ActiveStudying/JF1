package vn.edu.activestudy.activestudy.task.validateuser;

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
public class ValidateUserCMD {
    private static final String TAG = ValidateUserCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_VALIDATE_USER;

    public static void execute(Context context, final TaskListener listener) throws JSONException {

        String sessionId = PreferenceUtil.getString(context, Constants.PREFERENCE_SESSION_ID, "");
        String accountId = PreferenceUtil.getString(context, Constants.PREFERENCE_ACCOUNT_ID, "");

        RequestValidateUser request = new RequestValidateUser();
        request.setSessionId(sessionId);
        request.setAccountId(accountId);

        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseValidateUser resp = new Gson().fromJson(response.toString(), ResponseValidateUser.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseValidateUser resp = new ResponseValidateUser();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "validateUser");
    }
}
