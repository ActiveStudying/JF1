package vn.edu.activestudy.activestudy.manager;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.model.TeacherItem;

/**
 * Created by Administrator on 16/09/2015.
 */
public class TeacherManager {
    private static TeacherManager mInstance;
    private ArrayList<TeacherItem> mListTeacher;

    public TeacherManager() {
        mListTeacher = new ArrayList<>();
    }

    public static TeacherManager getInstance() {
        if (mInstance == null)
            mInstance = new TeacherManager();
        return mInstance;
    }

    public ArrayList<TeacherItem> getListTeacher() {
        if (mListTeacher.size() != 0) {
            //TODO get from DB
            return mListTeacher;
        } else {
            initTemplateData();
        }

        return mListTeacher;
    }

    private void initTemplateData() {
        mListTeacher.add(new TeacherItem(R.drawable.ronaldo, "he", "0981238321", "abc@yahoo.com", "Ha Noi", "facebook", "skype"));
        mListTeacher.add(new TeacherItem(R.drawable.ronaldo, "bfb", "0981238321", "abc@yahoo.com", "Ha Noi", "facebook", "skype"));
        mListTeacher.add(new TeacherItem(R.drawable.ronaldo, "Ronzxczxaldo", "0981238321", "abc@yahoo.com", "Ha Noi", "facebook", "skype"));
        mListTeacher.add(new TeacherItem(R.drawable.ronaldo, "zzzzc", "0981238321", "abc@yahoo.com", "Ha Noi", "facebook", "skype"));
        mListTeacher.add(new TeacherItem(R.drawable.ronaldo, "Ronaldo", "0981238321", "abc@yahoo.com", "Ha Noi", "facebook", "skype"));
    }
}
