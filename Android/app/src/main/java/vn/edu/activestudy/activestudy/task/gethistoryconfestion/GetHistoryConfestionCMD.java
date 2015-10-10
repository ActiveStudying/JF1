package vn.edu.activestudy.activestudy.task.gethistoryconfestion;

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
import vn.edu.activestudy.activestudy.model.entity.MessageEntity;
import vn.edu.activestudy.activestudy.task.gethistorymessage.RequestGetHistoryMessage;
import vn.edu.activestudy.activestudy.task.gethistorymessage.ResponseGetHistoryMessage;
import vn.edu.activestudy.activestudy.util.Utils;

/**
 * Created by dell123 on 02/10/2015.
 */
public class GetHistoryConfestionCMD {
    private static final String TAG = GetHistoryConfestionCMD.class.getSimpleName();
    private static final String url = Constants.URL_SERVER + Constants.URL_GET_HISTORY_CONFESTION;

    public void execute(int confestionVer, final TaskListener listener) throws JSONException {

        RequestGetHistoryConfestion request = new RequestGetHistoryConfestion();
        request.setAccountId(Utils.getAccountID());
        request.setDeviceId(Utils.getDeviceID());
        request.setSessionId(Utils.getSessionID());

        request.setConfestionVer(confestionVer);

        String json = new Gson().toJson(request);
        Log.d(TAG, json);

        JSONObject jsonObject = new JSONObject(json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Log.d(TAG, jsonObject.toString());

                ResponseGetHistoryConfestion response = new Gson().fromJson(jsonObject.toString(), ResponseGetHistoryConfestion.class);

                listener.onResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseGetHistoryConfestion response = new ResponseGetHistoryConfestion();
                response.setResult(result);

                listener.onResult(response);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "GetHistoryConfestionCMD");
    }
}
