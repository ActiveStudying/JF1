package vn.edu.activestudy.activestudy.view.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.common.Constants;
import vn.edu.activestudy.activestudy.manager.ClassManager;
import vn.edu.activestudy.activestudy.model.ClassItem;
import vn.edu.activestudy.activestudy.util.ToastUtil;

public class DetailClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_class);

        initUI();
        initData();
        initControl();
    }

    private void initUI() {
        //ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_app)));
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int position = bundle.getInt(Constants.INTENT_KEY);
            ArrayList<ClassItem> listClass = ClassManager.getInstance().getListClass();
            ClassItem classItem = listClass.get(position);
        }
    }

    private void initControl() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_class, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_show_student) {
            actionShowStudent_click();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void actionShowStudent_click() {
        ToastUtil.makeToast("actionShowStudent_click");

        Intent intent = new Intent(this, ListStudenOfClassActivity.class);
        startActivity(intent);
    }
}
