package vn.edu.activestudy.activestudy.task.getlistcourse;

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
import vn.edu.activestudy.activestudy.task.getmemberbymail.RequestGetMemberByMail;
import vn.edu.activestudy.activestudy.util.Utils;

/**
 * Created by dell123 on 02/10/2015.
 */
public class GetListCourseCMD {

    private static final String TAG = GetListCourseCMD.class.getSimpleName();
    private static final String url = Constants.URL_SERVER + Constants.URL_GET_LIST_COURSE;

    public void execute(final TaskListener listener) throws JSONException {

        RequestGetMemberByMail request = new RequestGetMemberByMail();
        request.setAccountId(Utils.getAccountID());
        request.setDeviceId(Utils.getDeviceID());
        request.setSessionId(Utils.getSessionID());

        String json = new Gson().toJson(request);
        Log.d(TAG, json);

        JSONObject jsonObject = new JSONObject(json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Log.d(TAG, jsonObject.toString());

                ResponseGetListCourse response = new Gson().fromJson(jsonObject.toString(), ResponseGetListCourse.class);

                listener.onResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseGetListCourse response = new ResponseGetListCourse();

                response.setResult(result);

                listener.onResult(response);
            }
        });
        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "GetListCourseCMD");
    }
}
