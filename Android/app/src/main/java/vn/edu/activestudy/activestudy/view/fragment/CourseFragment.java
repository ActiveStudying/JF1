package vn.edu.activestudy.activestudy.view.fragment;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.adapter.CourseAdapter;
import vn.edu.activestudy.activestudy.model.Course;
import vn.edu.activestudy.activestudy.util.ToastUtil;
import vn.edu.activestudy.activestudy.view.activity.CreateCourseActivity;
import vn.edu.activestudy.activestudy.view.activity.DetailCourseActivity;
import vn.edu.activestudy.activestudy.view.activity.EditCourseActivity;
import vn.edu.activestudy.activestudy.view.activity.HomeActivity;


/**
 * Created by Administrator on 31/08/2015.
 */
public class CourseFragment extends Fragment implements OnClickListener {
    // Inflate the fragment layout we defined above for this fragment

    // Set the associated text for the title`
    ListView lvCourse;
    ArrayList<Course> arrayListCourse;
    CourseAdapter courseAdapter;
    FloatingActionButton fab;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_course, container, false);
        HomeActivity.checkIsTeacher = true;
        // init view
        initUI(view);
        //set datasource
        setDatasource();

        //set adapter
        setAdapter();


        // set event
        return view;
    }

    private void initUI(View view) {
        lvCourse = (ListView) view.findViewById(R.id.lvCourse);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToListView(lvCourse);
        fab.setType(FloatingActionButton.TYPE_NORMAL);
        fab.setColorNormal(getResources().getColor(R.color.material_blue_500));
        fab.setColorPressed(getResources().getColor(R.color.abc_primary_text_material_dark));
        fab.show(true);
        fab.setOnClickListener(this);
        lvCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), DetailCourseActivity.class));
            }
        });
    }

    private void setDatasource() {
        arrayListCourse = new ArrayList<Course>();
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "3", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "5", "Noi Dung of Java"));
        arrayListCourse.add(new Course(R.drawable.img_java, "Java", "9", "Noi Dung of Java"));
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
        courseAdapter.setKeyword("hehe");
        lvCourse.setAdapter(courseAdapter);

        lvCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                if (!HomeActivity.checkIsTeacher) {
                    intent = new Intent(getActivity(), DetailCourseActivity.class);
                } else {
                    intent = new Intent(getActivity(), EditCourseActivity.class);
                }
                Bundle bundle = new Bundle();

                Course course = arrayListCourse.get(position);
                bundle.putString("des", course.getDescription());
                bundle.putString("name", course.getNameCourse());
                bundle.putString("number", course.getNumberLessons());
//                bundle.putInt("KEY", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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
        if (HomeActivity.checkIsTeacher == true) {
            startActivity(new Intent(getActivity(), CreateCourseActivity.class));
        } else {
            onRequestCreateCourse();
        }

    }

    private void onRequestCreateCourse() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_request_create_course);
        dialog.setTitle("Yêu cầu mở khóa học");

        // set the custom dialog components - text, image and button
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancelRequestCreateCourse);
        Button btnOk = (Button) dialog.findViewById(R.id.btnOkRequestCreateCourse);
        btnOk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.makeToast("OK");
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}

