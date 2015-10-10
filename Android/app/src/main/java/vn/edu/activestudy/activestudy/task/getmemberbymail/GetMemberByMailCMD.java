package vn.edu.activestudy.activestudy.task.getmemberbymail;

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
 * Created by dell123 on 01/10/2015.
 */
public class GetMemberByMailCMD {

    private static final String TAG = GetMemberByMailCMD.class.getSimpleName();
    private static final String url = Constants.URL_SERVER + Constants.URL_GET_MEMBER_BY_MAIL;

    public void execute(final TaskListener listener) throws JSONException {

        RequestGetMemberByMail request = new RequestGetMemberByMail();
        request.setDeviceId(Utils.getDeviceID());
        request.setAccountId(Utils.getAccountID());
        request.setSessionId(Utils.getSessionID());

        String json = new Gson().toJson(request);
        Log.d(TAG, json);

        JSONObject jsonObject = new JSONObject(json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d(TAG, jsonObject.toString());

                ResponseGetMemberByMail response = new Gson().fromJson(jsonObject.toString(), ResponseGetMemberByMail.class);

                listener.onResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseGetMemberByMail response = new ResponseGetMemberByMail();
                response.setResult(result);

                listener.onResult(response);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "GetMemberByMailCMD");
    }
}
