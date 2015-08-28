package vn.edu.activestudy.activestudy.task.validateuser;

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
import vn.edu.activestudy.activestudy.model.ResponseData;
import vn.edu.activestudy.activestudy.task.updateaccountinfo.RequestUpdateAccInfo;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ValidateUserCMD {
    private static final String TAG = ValidateUserCMD.class.getSimpleName();
    private static String url = Constants.URL_SERVER + "/validateUser";

    public static void execute(RequestValidateUser request, final TaskListener listener) throws JSONException {

        String json = new Gson().toJson(request);
        Log.d(TAG, json);
        JSONObject obj = new JSONObject(json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseData resp = new Gson().fromJson(response.toString(), ResponseData.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                ResponseData resp = new ResponseData();
                listener.onResult(resp);
            }
        });

        ASController.getInstance().addToRequestQueue(jsonObjReq, "validateUser");
    }
}
