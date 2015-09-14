package vn.edu.activestudy.activestudy.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.view.activity.IntroductionActivity;
import vn.edu.activestudy.activestudy.view.activity.ProfileActivity;

/**
 * Created by Administrator on 30/08/2015.
 */
public class MoreFragment extends Fragment implements View.OnClickListener {
    CardView cvPrifile,cvIntroduction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_more, container, false);
        initUI(view);
        setEvent();
        return view;
    }

    private void initUI(View view) {
        cvPrifile = (CardView) view.findViewById(R.id.cvProfile);
        cvIntroduction = (CardView) view.findViewById(R.id.cvIntroduction);

    }

    private void setEvent() {
        cvPrifile.setOnClickListener(this);
        cvIntroduction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.cvProfile:
                actionProfile();
                break;
            case R.id.cvIntroduction:
                actionIntroduction();
        }

    }

    private void actionIntroduction() {
        startActivity(new Intent(getActivity(), IntroductionActivity.class));
    }

    private void actionProfile() {
        startActivity(new Intent(getActivity(), ProfileActivity.class));
    }
}

