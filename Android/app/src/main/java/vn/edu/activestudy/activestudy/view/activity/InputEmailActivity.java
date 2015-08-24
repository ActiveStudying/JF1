package vn.edu.activestudy.activestudy.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.activestudy.activestudy.ASController;
import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.util.DeviceUtil;
import vn.edu.activestudy.activestudy.util.Utils;

public class InputEmailActivity extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_email);

        initUI();
        initData();
        initControl();
    }

    private void initUI() {
        edtEmail = (EditText) findViewById(R.id.edtInputEmail);
        btnContinue = (Button) findViewById(R.id.btnInputEmailContinue);
    }

    private void initData() {
        btnContinue.setEnabled(false);
        ASController.getInstance().getRegistrationID(this);
    }

    private void initControl() {
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    btnContinue.setEnabled(false);
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
//        btnContinue.setOnClickListener(this);
//        btnContinue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void btnContinue_click(View view) {
        String email = edtEmail.getText().toString();

        if (email.length() == 0) {
            Toast.makeText(this, getResources().getString(R.string.toast_input_email), Toast.LENGTH_SHORT).show();
        } else {
            if (!Utils.checkEmailValidator(email)) {
                Toast.makeText(this, getResources().getString(R.string.toast_wrong_email), Toast.LENGTH_SHORT).show();
            } else {
                active();
//                startActivity(new Intent(this, InputCodeActivity.class));
            }
        }
    }

    private void active() {
        DeviceUtil.getDeviceInfo(this);
    }

}
