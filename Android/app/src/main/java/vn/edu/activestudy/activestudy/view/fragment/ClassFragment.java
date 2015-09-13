package vn.edu.activestudy.activestudy.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.adapter.ClassAdapter;
import vn.edu.activestudy.activestudy.model.Class;
import vn.edu.activestudy.activestudy.util.ToastUtil;

/**
 * Created by Administrator on 30/08/2015.
 */
public class ClassFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ListView lvClass;
    ArrayList<Class> arrayListClass;
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
        arrayListClass = new ArrayList<>();
        arrayListClass.add(new Class(R.drawable.img_java, "Class 1", "Noi Dung of Class 1"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 2", "Noi Dung of Class 2"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 3", "Noi Dung of Class 3"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 4", "Noi Dung of Class 4"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 5", "Noi Dung of Class 5"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 6", "Noi Dung of Class 6"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 7", "Noi Dung of Class 7"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 8", "Noi Dung of Class 8"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 9", "Noi Dung of Class 9"));
        arrayListClass.add(new Class(R.drawable.img_java, "Class 10", "Noi Dung of Class 10"));
    }

    private void initControl() {
        classAdapter = new ClassAdapter(getActivity(), R.layout.item_class, arrayListClass);
        lvClass.setAdapter(classAdapter);
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
