package vn.edu.activestudy.activestudy.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.view.activity.TeacherActivity;

/**
 * Created by Administrator on 30/08/2015.
 */
public class ContactFragment extends Fragment {
    Button btnTeacher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_contact, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        btnTeacher = (Button) view.findViewById(R.id.btnTeacher);
        btnTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TeacherActivity.class));
            }
        });
    }
}

