package vn.edu.activestudy.activestudy.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.activestudy.activestudy.ASController;
import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.common.Constants;
import vn.edu.activestudy.activestudy.common.ResponseCode;
import vn.edu.activestudy.activestudy.util.NetworkUtil;
import vn.edu.activestudy.activestudy.util.PreferenceUtil;
import vn.edu.activestudy.activestudy.util.ToastUtil;

public class InputCodeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtInputCodeEmail;
    private EditText edtInputCodeOTP;

    private Button btnInputOTPResend;
    private Button btnInputOTPContinue;

    private BroadcastReceiver mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_code);

        initUI();
        initControl();
        initData();
        initReceiver();
    }

    private void initUI() {
        edtInputCodeEmail = (EditText) findViewById(R.id.edtInputCodeEmail);
        edtInputCodeOTP = (EditText) findViewById(R.id.edtInputCodeOTP);

        btnInputOTPResend = (Button) findViewById(R.id.btnInputOTPResend);
        btnInputOTPContinue = (Button) findViewById(R.id.btnInputOTPContinue);
    }

    private void initControl() {
        btnInputOTPResend.setOnClickListener(this);
        btnInputOTPContinue.setOnClickListener(this);
    }

    private void initData() {
        edtInputCodeEmail.setText(PreferenceUtil.getString(this, Constants.PREFERENCE_ACCOUNT_ID, ""));
    }


    private void initReceiver() {
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Constants.INTENT_ACTIVATE_WITH_OTP_COMPLETE)) { // active thành công -> đăng nhập
                    int code = intent.getExtras().getInt(Constants.INTENT_KEY);
                    processActiveOtpComplete(code);

                } else if (intent.getAction().equals(Constants.INTENT_ACTIVATE_COMPLETE)) { // gửi lại mã
                    int code = intent.getExtras().getInt(Constants.INTENT_KEY);
                    processActiveComplete(code);

                } else if (intent.getAction().equals(Constants.INTENT_LOGIN_COMPLETE)) {
                    int code = intent.getExtras().getInt(Constants.INTENT_KEY);
                    processLoginComplete(code);
                }

            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.INTENT_ACTIVATE_WITH_OTP_COMPLETE);
        intentFilter.addAction(Constants.INTENT_ACTIVATE_COMPLETE);
        intentFilter.addAction(Constants.INTENT_LOGIN_COMPLETE);

        registerReceiver(mReceiver, intentFilter);

    }

    private void processLoginComplete(int code) {
        switch (code) {
            case ResponseCode.ERROR: //-2
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_error));
                break;
            case ResponseCode.SYSTEM_ERROR:  //-1
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_system_error));

                break;
            case ResponseCode.SUCCESS: //0
                openHomeScreen();

                break;
            case ResponseCode.MAUTHEN_ACCOUNTID_INVALIDFORMAT: //2
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_accountid_invalidformat));

                break;
            case ResponseCode.MAUTHEN_ACCOUNTID_UNEXIST: //3
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_accountid_unexist));

                break;
            case ResponseCode.MAUTHEN_OTPCODE_INVALIDFORMAT: //4
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_otpcode_invalidformat));

                break;
            case ResponseCode.MAUTHEN_AUTHENID_INVALIDFORMAT: //5
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_authenid_invalidformat));

                break;
            case ResponseCode.MAUTHEN_DEVICEID_EMPTY: //8
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_deviceid_empty));

                break;
        }
    }

    private void processActiveComplete(int code) {
        switch (code) {
            case ResponseCode.ERROR:
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_error));
                break;
            case ResponseCode.SYSTEM_ERROR:
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_system_error));
                break;
            case ResponseCode.SUCCESS:
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_resend_otp));
                break;
            case ResponseCode.MAUTHEN_ACCOUNTID_INVALIDFORMAT:
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_accountid_invalidformat));
                break;
            case ResponseCode.MAUTHEN_ACCOUNTID_UNEXIST:
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_accountid_unexist));
                break;
            case ResponseCode.MAUTHEN_DEVICEID_EMPTY:
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_deviceid_empty));
                break;
        }
    }

    private void processActiveOtpComplete(int code) {
        switch (code) {
            case ResponseCode.ERROR://-2
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_error));
                break;
            case ResponseCode.SYSTEM_ERROR://-1
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_system_error));
                break;
            case ResponseCode.SUCCESS://0
                //Login
                login();

                break;
            case ResponseCode.MAUTHEN_ACCOUNTID_INVALIDFORMAT://2
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_accountid_invalidformat));
                break;
            case ResponseCode.MAUTHEN_ACCOUNTID_UNEXIST://3
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_accountid_unexist));
                break;
            case ResponseCode.MAUTHEN_OTPCODE_INVALIDFORMAT://4
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_mauthen_otpcode_invalidformat));
                break;
            case ResponseCode.OVER_NUMBERRETRY_OTPCODE://7
                ToastUtil.makeToast(code + " : " + getResources().getString(R.string.toast_over_numberretry_otpcode));
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInputOTPResend:
                btnInputOTPResend_click(v);
                break;
            case R.id.btnInputOTPContinue:
                btnInputOTPContinue_click(v);
                break;
        }
    }

    public void btnInputOTPResend_click(View view) {
        if (NetworkUtil.isNetworkAvailable(this)) {
            ASController.getInstance().activate(PreferenceUtil.getString(this, Constants.PREFERENCE_ACCOUNT_ID, ""));
        } else {
            ToastUtil.makeToast(getResources().getString(R.string.toast_network_not_available));
        }
    }

    public void btnInputOTPContinue_click(View view) {
        String otp = edtInputCodeOTP.getText().toString();
        if (otp.length() > 0) {
            if (NetworkUtil.isNetworkAvailable(this)) {
                ASController.getInstance().activeWithOTP(edtInputCodeOTP.getText().toString());
            } else {
                ToastUtil.makeToast(getResources().getString(R.string.toast_network_not_available));
            }
        } else {
            ToastUtil.makeToast(getResources().getString(R.string.toast_input_otp));
        }
    }

    private void login() {
        if (NetworkUtil.isNetworkAvailable(this)) {
            ASController.getInstance().login();
        } else {
            ToastUtil.makeToast(getResources().getString(R.string.toast_network_not_available));
        }
    }

    private void openHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
