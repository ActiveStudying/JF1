package vn.edu.activestudy.activestudy.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.adapter.ClassAdapter;
import vn.edu.activestudy.activestudy.common.Constants;
import vn.edu.activestudy.activestudy.manager.ClassManager;
import vn.edu.activestudy.activestudy.model.ClassItem;
import vn.edu.activestudy.activestudy.util.ToastUtil;
import vn.edu.activestudy.activestudy.view.activity.DetailClassActivity;

/**
 * Created by Administrator on 30/08/2015.
 */
public class ClassFragment extends Fragment implements View.OnClickListener {

    private static final String KEY = "CLASSFRAGMENT";
    private View view;
    private ListView lvClass;
    ArrayList<ClassItem> arrayListClass;
    ClassAdapter classAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_class, container, false);

        initUI();
        initData();
        initControl();

        return view;
    }

    private void initUI() {
        lvClass = (ListView) view.findViewById(R.id.lvClass);

        FloatingActionButton fabClass = (FloatingActionButton) view.findViewById(R.id.fabClass);
        fabClass.attachToListView(lvClass);
        fabClass.setType(FloatingActionButton.TYPE_NORMAL);
        fabClass.setColorNormal(getResources().getColor(R.color.material_blue_500));
        fabClass.setColorPressed(getResources().getColor(R.color.abc_primary_text_material_dark));
        fabClass.show(true);
        fabClass.setOnClickListener(this);
    }

    private void initData() {
        arrayListClass = ClassManager.getInstance().getListClass();
    }

    private void initControl() {
        classAdapter = new ClassAdapter(getActivity(), R.layout.item_class, arrayListClass);
        lvClass.setAdapter(classAdapter);

        lvClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Open detail class
                ToastUtil.makeToast("click Item: " + position);

                Bundle bundle = new Bundle();
                bundle.putInt(Constants.INTENT_KEY, position);

                Intent intent = new Intent(getActivity(), DetailClassActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabClass:
                onFabClass_Click();
        }
    }

    private void onFabClass_Click() {
        ToastUtil.makeToast("onFabClass_Click");
    }
}
