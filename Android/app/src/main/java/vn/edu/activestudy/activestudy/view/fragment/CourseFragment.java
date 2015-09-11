package vn.edu.activestudy.activestudy.view.fragment;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.adapter.CourseAdapter;
import vn.edu.activestudy.activestudy.model.Course;
import vn.edu.activestudy.activestudy.view.activity.CreateCourseActivity;


/**
 * Created by Administrator on 31/08/2015.
 */
public class CourseFragment extends Fragment implements OnClickListener {
    // Inflate the fragment layout we defined above for this fragment

    // Set the associated text for the title`
    ListView lvCourse;
    ArrayList<Course> arrayListCourse;
    CourseAdapter courseAdapter;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_course, container, false);
        lvCourse = (ListView) view.findViewById(R.id.lvCourse);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToListView(lvCourse);
        fab.setType(FloatingActionButton.TYPE_NORMAL);
        fab.setColorNormal(getResources().getColor(R.color.material_blue_500));
        fab.setColorPressed(getResources().getColor(R.color.abc_primary_text_material_dark));
        fab.show(true);
        fab.setOnClickListener(this);
        // init view

        //set datasource
        setDatasource();

        //set adapter
        setAdapter();


        // set event
        return view;
    }

    private void setDatasource() {
        arrayListCourse = new ArrayList<Course>();
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "Noi Dung of Java"));
//        courseAdapter.notifyDataSetChanged();
    }

    private void setAdapter() {

        courseAdapter = new CourseAdapter(getActivity(), R.layout.item_course, arrayListCourse);
        lvCourse.setAdapter(courseAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                onFabClick();
        }
    }

    private void onFabClick() {
//        Intent intent = new Intent(getActivity(),CreateCourseActivity.class);
        startActivity(new Intent(getActivity(),CreateCourseActivity.class));
    }
}

