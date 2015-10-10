package vn.edu.activestudy.activestudy.task.addmemberonclass;

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
 * Created by dell123 on 30/09/2015.
 */
public class AddMemberOnClassCMD {

    private static final String TAG = AddMemberOnClassCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + Constants.URL_ADD_MEMBER_ON_CLASS;

    public void execute(int classId, final TaskListener listener) throws JSONException {

        RequestAddMemberOnClass request = new RequestAddMemberOnClass();
        request.setDeviceId(Utils.getDeviceID());
        request.setAccountId(Utils.getAccountID());
        request.setSessionId(Utils.getSessionID());
        request.setClassId(classId);

        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                ResponseAddMemberOnClass resp = new Gson().fromJson(response.toString(), ResponseAddMemberOnClass.class);
                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Result result = new Result();
                result.setCode(ResponseCode.ERROR);

                ResponseAddMemberOnClass resp = new ResponseAddMemberOnClass();
                resp.setResult(result);

                listener.onResult(resp);
            }
        });
        ASController.getInstance().addToRequestQueue(jsonObjectRequest, "AddMemberOnClassCMD");
    }
}
