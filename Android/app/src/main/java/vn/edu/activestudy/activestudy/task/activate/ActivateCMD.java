package vn.edu.activestudy.activestudy.task.activate;

import android.content.Context;
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
import vn.edu.activestudy.activestudy.util.PreferenceUtil;

/**
 * Created by dell123 on 8/24/2015.
 */
public class ActivateCMD {

    private static final String TAG = ActivateCMD.class.getSimpleName();

    public static void execute(Context context, final TaskListener listener) throws JSONException {
        String url = "/active";
        RequestActivate request = new RequestActivate();
        request.setEmail(PreferenceUtil.getString(context, Constants.PREFERENCE_EMAIL, ""));
        request.setPassord("Passorkl");

        String json = new Gson().toJson(request);
        JSONObject obj = new JSONObject(json);

        Log.d(TAG, json);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                ResponseActivate resp = new Gson().fromJson(response.toString(), ResponseActivate.class);

                listener.onResult(resp);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                ResponseActivate resp = new ResponseActivate();
                listener.onResult(resp);
            }
        });
        ASController.getInstance().addToRequestQueue(jsonObjReq, "activate_request");
    }

}
