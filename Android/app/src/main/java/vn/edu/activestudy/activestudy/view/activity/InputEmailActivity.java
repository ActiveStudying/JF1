package vn.edu.activestudy.activestudy.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.activestudy.activestudy.ASApplication;
import vn.edu.activestudy.activestudy.ASController;
import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.common.Constants;
import vn.edu.activestudy.activestudy.common.ResponseCode;
import vn.edu.activestudy.activestudy.util.NetworkUtil;
import vn.edu.activestudy.activestudy.util.PreferenceUtil;
import vn.edu.activestudy.activestudy.util.ToastUtil;
import vn.edu.activestudy.activestudy.util.Utils;


public class InputEmailActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtEmail;
    private Button btnContinue;
    private Button btnLogout;

    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_email);

        initUI();
        initData();
        initControl();
        initReceiver();
    }


    private void initUI() {
        edtEmail = (EditText) findViewById(R.id.edtInputEmail);
        btnContinue = (Button) findViewById(R.id.btnInputEmailContinue);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        //for test
        edtEmail.setText("vuthanhtrung90@gmail.com");
    }

    private void initData() {
        btnContinue.setEnabled(true);
        ASController.getInstance().getRegistrationID(this);
    }

    private void initControl() {
        //handler text change of EditText
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    btnContinue.setEnabled(true);
                } else
                    btnContinue.setEnabled(true);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        btnContinue.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }


    private void initReceiver() {
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals(Constants.INTENT_ACTIVATE_COMPLETE)) {
                    int code = intent.getExtras().getInt(Constants.INTENT_KEY);
                    switch (code) {
                        case ResponseCode.ERROR: //-2
                            ToastUtil.makeToast(getResources().getString(R.string.toast_error));
                            break;
                        case ResponseCode.SYSTEM_ERROR: //-1
                            ToastUtil.makeToast(getResources().getString(R.string.toast_system_error));
                            break;
                        case ResponseCode.SUCCESS: //0
                            openInputCodeScreen();
                            break;
                        case ResponseCode.MAUTHEN_ACCOUNTID_INVALIDFORMAT: //2
                            ToastUtil.makeToast(getResources().getString(R.string.toast_mauthen_accountid_invalidformat));
                            break;
                        case ResponseCode.MAUTHEN_ACCOUNTID_UNEXIST: //3
                            ToastUtil.makeToast(getResources().getString(R.string.toast_mauthen_accountid_unexist));
                            break;
                        case ResponseCode.MAUTHEN_DEVICEID_EMPTY: //8
                            ToastUtil.makeToast(getResources().getString(R.string.toast_mauthen_deviceid_empty));
                            break;
                    }
                } else if (action.equals(Constants.INTENT_LOGOUT_COMPLETE)) {
                    int code = intent.getExtras().getInt(Constants.INTENT_KEY);
                    switch (code) {
                        case ResponseCode.ERROR: //-2
                            ToastUtil.makeToast(code + " " + getResources().getString(R.string.toast_error));
                            break;
                        case ResponseCode.SYSTEM_ERROR:  //-1
                            ToastUtil.makeToast(code + " " + getResources().getString(R.string.toast_system_error));

                            break;
                        case ResponseCode.SUCCESS: //0

                            break;
                        case ResponseCode.MAUTHEN_SESSIONID_INVALIDFORMAT: //1
                            ToastUtil.makeToast(code + " " + getResources().getString(R.string.toast_mauthen_sessionid_invalidformat));

                            break;
                        case ResponseCode.MAUTHEN_ACCOUNTID_INVALIDFORMAT: //2
                            ToastUtil.makeToast(code + " " + getResources().getString(R.string.toast_mauthen_accountid_invalidformat));

                            break;
                        case ResponseCode.MAUTHEN_ACCOUNTID_UNEXIST: //3
                            ToastUtil.makeToast(code + " " + getResources().getString(R.string.toast_mauthen_accountid_unexist));

                            break;
                    }
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.INTENT_ACTIVATE_COMPLETE);
        filter.addAction(Constants.INTENT_LOGOUT_COMPLETE);
        registerReceiver(mReceiver, filter);
    }

    private void openInputCodeScreen() {
        Intent myIntent = new Intent(this, InputCodeActivity.class);
        startActivity(myIntent);
    }

    private void openHomeScreen() {
        Intent myIntent = new Intent(this, HomeActivity.class);
        startActivity(myIntent);
    }

//    private void executeTask() {
//        AsyncTask<Void, Integer, Integer> task = new AsyncTask<Void, Integer, Integer>() {
//            @Override
//            protected Integer doInBackground(Void... params) {
//                int sum = 0;
//                for (int i = 1; i <= 9; i++) {
//                    sum += i;
//                    publishProgress(i);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                return sum;
//            }
//
//            @Override
//            protected void onProgressUpdate(Integer... i) {
//                super.onProgressUpdate(i);
//                if (i[0] != 9) {
//                    edtEmail.setText(edtEmail.getText().toString() + i[0] + "+");
//                } else {
//                    edtEmail.setText(edtEmail.getText().toString() + i[0] + "=");
//                }
//            }
//
//            @Override
//            protected void onPostExecute(Integer sum) {
//                super.onPostExecute(sum);
//                edtEmail.setText(edtEmail.getText().toString() + sum);
//            }
//        };
//        task.execute();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInputEmailContinue:
                btnInputEmailContinue_click(v);
                break;
            case R.id.btnLogout:
                btnLogout_click(v);
                break;
        }
    }

    private void btnLogout_click(View v) {
        ASController.getInstance().logout();

        PreferenceUtil.resetPref(ASApplication.getContext());
        ToastUtil.makeToast("Logout!");
    }

    private void btnInputEmailContinue_click(View v) {
        if (Utils.checkSessionId()) {
            openHomeScreen();

        } else {
            String email = edtEmail.getText().toString();

            if (email.length() == 0) {
                ToastUtil.makeToast(getResources().getString(R.string.toast_input_email));
            } else if (!Utils.checkEmailValidator(email)) {
                ToastUtil.makeToast(getResources().getString(R.string.toast_wrong_email));
            } else {
                active(email);
            }
        }
    }

    private void active(String email) {

        if (NetworkUtil.isNetworkAvailable(this)) {
            ASController.getInstance().activate(email);
        } else {
            ToastUtil.makeToast(getResources().getString(R.string.toast_network_not_available));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
