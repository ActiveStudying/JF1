package vn.edu.activestudy.activestudy.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.util.ToastUtil;

public class InputCodeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnInputOTPResend;
    Button btnInputOTPContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_code);

        initUI();
        initControl();
        initData();
    }

    private void initUI() {
        btnInputOTPResend = (Button) findViewById(R.id.btnInputOTPResend);
        btnInputOTPContinue = (Button) findViewById(R.id.btnInputOTPContinue);
    }

    private void initControl() {
        btnInputOTPResend.setOnClickListener(this);
        btnInputOTPContinue.setOnClickListener(this);
    }

    private void initData() {

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
        ToastUtil.makeToast("btnInputOTPResend_click");
    }

    public void btnInputOTPContinue_click(View view) {
        ToastUtil.makeToast("btnInputOTPContinue_click");

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
