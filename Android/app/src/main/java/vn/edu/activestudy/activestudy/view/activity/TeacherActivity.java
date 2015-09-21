package vn.edu.activestudy.activestudy.view.activity;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.adapter.TeacherAdapter;
import vn.edu.activestudy.activestudy.manager.TeacherManager;
import vn.edu.activestudy.activestudy.model.TeacherItem;

public class TeacherActivity extends AppCompatActivity {

    RecyclerView rcvTeacher;
    TeacherAdapter teacherAdapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        initUI();
        initData();
        initControl();
    }

    private void initUI() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_app)));
        //
        rcvTeacher = (RecyclerView) findViewById(R.id.rcvTeacherList);

    }

    private void initData() {
        rcvTeacher.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rcvTeacher.setLayoutManager(mLayoutManager);
        teacherAdapter = new TeacherAdapter(TeacherManager.getInstance().getListTeacher());
        rcvTeacher.setAdapter(teacherAdapter);
    }

    private void initControl() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_teacher, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchItem.setActionView(searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                              @Override
                                              public boolean onQueryTextSubmit(String query) {
                                                  return false;
                                              }

                                              @Override
                                              public boolean onQueryTextChange(String newText) {
                                                  ArrayList<TeacherItem> list = TeacherManager.getInstance().getListTeacher();
                                                  rcvTeacher.setAdapter(new TeacherAdapter(filter(list, newText)));

                                                  return false;
                                              }


                                          }

        );
        return true;
    }

    private ArrayList<TeacherItem> filter(ArrayList<TeacherItem> models, String query) {
        query = query.toLowerCase();

        final ArrayList<TeacherItem> filteredModelList = new ArrayList<>();
        for (TeacherItem tc : TeacherManager.getInstance().getListTeacher()) {
            final String text = tc.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(tc);
            }
        }
        return filteredModelList;
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
