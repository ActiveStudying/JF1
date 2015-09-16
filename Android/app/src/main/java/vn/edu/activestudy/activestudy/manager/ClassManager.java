package vn.edu.activestudy.activestudy.manager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.model.*;

/**
 * Created by dell123 on 9/14/2015.
 */
public class ClassManager {

    private static ClassManager mInstance;
    private ArrayList<ClassItem> mListClass;

    public ClassManager() {
        mListClass = new ArrayList<>();
    }
    
    public static ClassManager getInstance() {
        if (mInstance == null)
            mInstance = new ClassManager();
        return mInstance;
    }

    public ArrayList<ClassItem> getListClass() {
        if (mListClass.size() == 0) {
            //TODO get from DB
        }
        initTemplateData();
        return mListClass;
    }

    private void initTemplateData() {
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 1", "Tên khóa học + Lịch học 1"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 2", "Tên khóa học + Lịch học 2"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 3", "Tên khóa học + Lịch học 3"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 4", "Tên khóa học + Lịch học 4"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 5", "Tên khóa học + Lịch học 5"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 6", "Tên khóa học + Lịch học 6"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 7", "Tên khóa học + Lịch học 7"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 8", "Tên khóa học + Lịch học 8"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 9", "Tên khóa học + Lịch học 9"));
        mListClass.add(new ClassItem(R.drawable.img_java, "ClassItem 10", "Tên khóa học + Lịch học 10"));
    }


}
