package vn.edu.activestudy.activestudy.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import vn.edu.activestudy.activestudy.ASController;
import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.common.Constants;
import vn.edu.activestudy.activestudy.model.ClassInfo;
import vn.edu.activestudy.activestudy.util.DeviceUtil;
import vn.edu.activestudy.activestudy.util.PreferenceUtil;
import vn.edu.activestudy.activestudy.util.TimeUtil;
import vn.edu.activestudy.activestudy.util.ToastUtil;
import vn.edu.activestudy.activestudy.util.Utils;


public class InputEmailActivity extends AppCompatActivity implements View.OnClickListener {

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

        //for test
        edtEmail.setText("test@test.test");
    }

    private void initData() {
        btnContinue.setEnabled(false);
        ASController.getInstance().getRegistrationID(this);
    }

    private void initControl() {
        //handler text change of EditText
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

        btnContinue.setOnClickListener(this);
    }


    private void executeTask() {
        AsyncTask<Void, Integer, Integer> task = new AsyncTask<Void, Integer, Integer>() {
            @Override
            protected Integer doInBackground(Void... params) {
                int sum = 0;
                for (int i = 1; i <= 9; i++) {
                    sum += i;
                    publishProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return sum;
            }

            @Override
            protected void onProgressUpdate(Integer... i) {
                super.onProgressUpdate(i);
                if (i[0] != 9) {
                    edtEmail.setText(edtEmail.getText().toString() + i[0] + "+");
                } else {
                    edtEmail.setText(edtEmail.getText().toString() + i[0] + "=");
                }
            }

            @Override
            protected void onPostExecute(Integer sum) {
                super.onPostExecute(sum);
                edtEmail.setText(edtEmail.getText().toString() + sum);
            }
        };
        task.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInputEmailContinue:
                btnInputEmailContinue_click(v);
                break;
        }
    }

    private void btnInputEmailContinue_click(View v) {
        String email = edtEmail.getText().toString();

        if (email.length() == 0) {
            ToastUtil.makeToast(getResources().getString(R.string.toast_input_email));
        } else if (!Utils.checkEmailValidator(email)) {
            ToastUtil.makeToast(getResources().getString(R.string.toast_wrong_email));
        } else {
            active();
        }
    }

    private void active() {
//        PreferenceUtil.setString(this, Constants.PREFERENCE_EMAIL, edtEmail.getText().toString());
//        ASController.getInstance().activate(this);

//        List<ClassInfo> result = ClassInfo.find(ClassInfo.class, "Name=? and teacher=?", new String[]{"C#", "VIET NAM"});
//        if (result == null) {
//            Log.d("TEST", "NULL");
//        } else {
//            Log.d("TEST", "NOT NULL: " + result.size());
//        }
        //executeTask();

        Intent myIntent = new Intent(this, InputCodeActivity.class);
        startActivity(myIntent);
    }
}
