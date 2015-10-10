package vn.edu.activestudy.activestudy.task.getcalendarstudy;

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
public class GetCalendarStudyCMD {

    private static final String TAG = GetCalendarStudyCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_GET_ACCOUNT_INFO;

    public static void execute(final TaskListener listener) throws JSONException {

        RequestGetCalendarStudy request = new RequestGetCalendarStudy();
        request.setAccountId(Utils.getAccountID());
        request.setDeviceId(Utils.getDeviceID());
        request.setSessionId(Utils.getSessionID());

        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                ResponseGetCalendarStudy resp = new Gson().fromJson(response.toString(), ResponseGetCalendarStudy.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseGetCalendarStudy resp = new ResponseGetCalendarStudy();
                resp.setResult(result);
                
                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "get_account_info_request");
    }
}
