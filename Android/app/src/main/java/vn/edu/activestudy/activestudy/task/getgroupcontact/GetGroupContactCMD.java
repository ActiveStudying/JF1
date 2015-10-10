package vn.edu.activestudy.activestudy.task.getgroupcontact;

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
import vn.edu.activestudy.activestudy.task.getaccountinfo.ResponseGetAccountInfo;
import vn.edu.activestudy.activestudy.util.Utils;

/**
 * Created by dell123 on 02/10/2015.
 */
public class GetGroupContactCMD {

    private static final String TAG = GetGroupContactCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_GET_GROUP_CONTACT;

    public static void execute(final TaskListener listener) throws JSONException {

        RequestGetGroupContact request = new RequestGetGroupContact();
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

                ResponseGetGroupContact resp = new Gson().fromJson(response.toString(), ResponseGetGroupContact.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseGetGroupContact resp = new ResponseGetGroupContact();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "GetGroupContactCMD");
    }
}
