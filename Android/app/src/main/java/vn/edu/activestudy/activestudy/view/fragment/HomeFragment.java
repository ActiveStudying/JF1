package vn.edu.activestudy.activestudy.view.activity.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.util.ToastUtil;
import vn.edu.activestudy.activestudy.view.activity.HomeActivity;

/**
 * Created by Administrator on 30/08/2015.
 */
public class HomeFragment extends Fragment {
    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    Context context;

    public HomeFragment(Context context) {
        super();
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvTitle.setText("This is home fragment");



        return view;
    }
}
