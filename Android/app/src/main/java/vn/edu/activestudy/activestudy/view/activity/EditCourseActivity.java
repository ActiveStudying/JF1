package vn.edu.activestudy.activestudy.view.activity;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.util.ToastUtil;
import vn.edu.activestudy.activestudy.util.Utils;

public class EditCourseActivity extends AppCompatActivity {
    EditText edtNameCourse, edtNumberLessions, edtContentCourse;
    CardView cvEditCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);
        initUI();
        initData();
        initControl();
    }

    private void initUI() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_app)));
        edtNameCourse = (EditText) findViewById(R.id.edtNameCourse);
        edtNumberLessions = (EditText) findViewById(R.id.edtNumberLessions);
        edtContentCourse = (EditText) findViewById(R.id.edtContentCourse);
        cvEditCourse = (CardView) findViewById(R.id.cvEditCourse);

    }

    private void initData() {
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        String numberLessions = b.getString("number");
        String content = b.getString("des");
        edtContentCourse.setText(content);
        edtNumberLessions.setText(numberLessions);
        edtNameCourse.setText(name);
    }

    private void initControl() {
        cvEditCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEditCourse();
            }
        });
    }

    private void onEditCourse() {
        new AlertDialog.Builder(this)
                .setTitle("Chỉnh Sửa Khóa Học")
                .setMessage("Bạn có chắc chắn chỉnh sửa khóa học này không")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.makeToast("Chinh Sua Thanh Cong");
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.makeToast("Huy bo chinh sua");
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
