package vn.edu.activestudy.activestudy.view.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.adapter.StudentAdapter;
import vn.edu.activestudy.activestudy.manager.StudentOfClassManager;
import vn.edu.activestudy.activestudy.model.StudentItem;

public class ListStudenOfClassActivity extends AppCompatActivity {

    private ListView lvStudent;
    private ArrayList<StudentItem> arrayListStudent;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_studen_of_class);

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

        lvStudent = (ListView) findViewById(R.id.lvStudentOfClass);

    }

    private void initData() {
        arrayListStudent = StudentOfClassManager.getInstance().getListStudentOfClass();
    }

    private void initControl() {
        studentAdapter = new StudentAdapter(this, R.layout.item_student, arrayListStudent);

        lvStudent.setAdapter(studentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_studen_of_class, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
