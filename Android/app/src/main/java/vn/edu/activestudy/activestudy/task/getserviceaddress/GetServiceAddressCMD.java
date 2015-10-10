package vn.edu.activestudy.activestudy.task.getserviceaddress;

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
public class GetServiceAddressCMD {
    private static final String TAG = GetServiceAddressCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_GET_SERVICE_ADDRESS;

    public static void execute(final TaskListener listener) throws JSONException {

        RequestGetServiceAddress request = new RequestGetServiceAddress();
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
                ResponseGetServiceAddress resp = new Gson().fromJson(response.toString(), ResponseGetServiceAddress.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                ResponseGetServiceAddress resp = new ResponseGetServiceAddress();
                Result result = new Result();
                result.setCode(ResponseCode.ERROR);
                resp.setResult(result);
                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "getServiceAddress");
    }
}
