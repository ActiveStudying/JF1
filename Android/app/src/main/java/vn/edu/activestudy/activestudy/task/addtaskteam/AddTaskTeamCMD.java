package vn.edu.activestudy.activestudy.task.addtaskteam;

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
import vn.edu.activestudy.activestudy.model.entity.TaskEntity;
import vn.edu.activestudy.activestudy.util.Utils;

/**
 * Created by dell123 on 02/10/2015.
 */
public class AddTaskTeamCMD {

    private static final String TAG = AddTaskTeamCMD.class.getSimpleName();
    private static final String url = Constants.URL_SERVER + Constants.URL_ADD_TASK_TEAM;

    public void execute(TaskEntity taskEntity, final TaskListener listener) throws JSONException {

        RequestAddTaskTeam request = new RequestAddTaskTeam();
        request.setSessionId(Utils.getSessionID());
        request.setDeviceId(Utils.getDeviceID());
        request.setAccountId(Utils.getAccountID());

        request.setTask(taskEntity);

        final String json = new Gson().toJson(request);
        Log.d(TAG, json);

        JSONObject jsonObject = new JSONObject(json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d(TAG, jsonObject.toString());

                ResponseAddTaskTeam response = new Gson().fromJson(jsonObject.toString(), ResponseAddTaskTeam.class);

                listener.onResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseAddTaskTeam response = new ResponseAddTaskTeam();
                response.setResult(result);

                listener.onResult(response);
            }
        });
        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "AddTaskTeamCMD");
    }
}
