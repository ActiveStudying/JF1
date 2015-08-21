package vn.edu.activestudy.activestudy.view.activity;

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

import vn.edu.activestudy.activestudy.R;

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
            if (!email.contains("@")) {
                Toast.makeText(this, getResources().getString(R.string.toast_wrong_email), Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(this, InputCodeActivity.class));
            }
        }
    }

}
