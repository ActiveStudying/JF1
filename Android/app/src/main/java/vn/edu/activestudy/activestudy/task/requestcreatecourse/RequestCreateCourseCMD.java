package vn.edu.activestudy.activestudy.task.requestcreatecourse;

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
 * Created by dell123 on 05/10/2015.
 */
public class RequestCreateCourseCMD {

    private static final String TAG = RequestCreateCourseCMD.class.getSimpleName();
    private static final String url = Constants.URL_SERVER + Constants.URL_REQUEST_CREATE_COURSE;

    public void execute(String nameCouse, String content, final TaskListener listener) throws JSONException {

        RequestRequestCreateCourse request = new RequestRequestCreateCourse();
        request.setAccountId(Utils.getAccountID());
        request.setDeviceId(Utils.getDeviceID());
        request.setSessionId(Utils.getSessionID());

        request.setContent(content);
        request.setNameCouse(nameCouse);

        String json = new Gson().toJson(request);
        Log.d(TAG, json);

        JSONObject jsonObject = new JSONObject(json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d(TAG, jsonObject.toString());

                ResponseRequestCreateCourse response = new Gson().fromJson(jsonObject.toString(), ResponseRequestCreateCourse.class);

                listener.onResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseRequestCreateCourse response = new ResponseRequestCreateCourse();

                listener.onResult(response);
            }
        });
        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "RequestCreateCourseCMD");
    }

}
