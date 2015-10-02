package vn.edu.activestudy.activestudy.task.createevent;

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
import vn.edu.activestudy.activestudy.model.entity.EventEntity;
import vn.edu.activestudy.activestudy.util.Utils;

/**
 * Created by dell123 on 30/09/2015.
 */
public class CreateEventCMD {

    private static final String TAG = CreateEventCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_CREATE_EVENT;

    public void execute(String eventName, EventEntity eventData, final TaskListener listener) throws JSONException {

        RequestCreateEvent requestCreateEvent = new RequestCreateEvent();

        requestCreateEvent.setSessionId(Utils.getSessionID());
        requestCreateEvent.setAccountId(Utils.getAccountID());
        requestCreateEvent.setDeviceId(Utils.getDeviceID());

        requestCreateEvent.setEventName(eventName);
        requestCreateEvent.setEventData(eventData);

        String json = new Gson().toJson(requestCreateEvent);
        Log.d(TAG, json);
        JSONObject jsonObject = new JSONObject(json);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                ResponseCreateEvent resp = new Gson().fromJson(response.toString(), ResponseCreateEvent.class);
                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseCreateEvent resp = new ResponseCreateEvent();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });
        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "create_event");
    }
}
