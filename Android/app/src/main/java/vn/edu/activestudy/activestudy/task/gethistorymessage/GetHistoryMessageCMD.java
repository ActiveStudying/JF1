package vn.edu.activestudy.activestudy.task.gethistorymessage;

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
import vn.edu.activestudy.activestudy.util.Utils;

/**
 * Created by dell123 on 02/10/2015.
 */
public class GetHistoryMessageCMD {
    private static final String TAG = GetHistoryMessageCMD.class.getSimpleName();
    private static final String url = Constants.URL_SERVER + Constants.URL_GET_HISTORY_MESSAGE;

    public void execute(String groupID, MessageEntity messageId, final TaskListener listener) throws JSONException {

        RequestGetHistoryMessage request = new RequestGetHistoryMessage();
        request.setAccountId(Utils.getAccountID());
        request.setDeviceId(Utils.getDeviceID());
        request.setSessionId(Utils.getSessionID());

        request.setGroupID(groupID);
        request.setMessageId(messageId);

        String json = new Gson().toJson(request);
        Log.d(TAG, json);

        JSONObject jsonObject = new JSONObject(json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Log.d(TAG, jsonObject.toString());

                ResponseGetHistoryMessage response = new Gson().fromJson(jsonObject.toString(), ResponseGetHistoryMessage.class);

                listener.onResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseGetHistoryMessage response = new ResponseGetHistoryMessage();
                response.setResult(result);

                listener.onResult(response);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "GetHistoryMessageCMD");
    }
}
