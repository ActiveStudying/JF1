package vn.edu.activestudy.activestudy.task.login;

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
public class LoginCMD {

    private static final String TAG = LoginCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_LOGIN;

    public static void execute(final TaskListener listener) throws JSONException {


        String authenId = Utils.getAuthenId();
        String accountId = Utils.getAccountID();
        String deviceId = Utils.getDeviceID();
        String cloudKey = Utils.getCloudKey();


        RequestLogin request = new RequestLogin();
        request.setAuthenId(authenId);
        request.setAccountId(accountId);
        request.setDeviceId(deviceId);
        request.setCloudKey(cloudKey);


        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseLogin resp = new Gson().fromJson(response.toString(), ResponseLogin.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseLogin resp = new ResponseLogin();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "login_request");
    }
}
