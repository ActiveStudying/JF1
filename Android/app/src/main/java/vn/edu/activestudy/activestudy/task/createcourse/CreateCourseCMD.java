package vn.edu.activestudy.activestudy.task.createcourse;

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
import vn.edu.activestudy.activestudy.model.entity.CourseEntity;
import vn.edu.activestudy.activestudy.util.Utils;

/**
 * Created by dell123 on 02/10/2015.
 */
public class CreateCourseCMD {

    private static final String TAG = CreateCourseCMD.class.getSimpleName();
    private static final String url = Constants.URL_SERVER + Constants.URL_CREATE_COURSE;

    public void execute(CourseEntity courseData, final TaskListener listener) throws JSONException {

        RequestCreateCourse request = new RequestCreateCourse();
        request.setSessionId(Utils.getSessionID());
        request.setDeviceId(Utils.getDeviceID());
        request.setAccountId(Utils.getAccountID());

        request.setCourseData(courseData);

        final String json = new Gson().toJson(request);
        Log.d(TAG, json);

        JSONObject jsonObject = new JSONObject(json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Log.d(TAG, jsonObject.toString());
                ResponseCreateCourse responseCreateCourse = new Gson().fromJson(jsonObject.toString(), ResponseCreateCourse.class);

                listener.onResult(responseCreateCourse);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseCreateCourse responseCreateCourse = new ResponseCreateCourse();
                responseCreateCourse.setResult(result);

                listener.onResult(responseCreateCourse);
            }
        });
        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "CreateCourseCMD");
    }
}
