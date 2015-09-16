package vn.edu.activestudy.activestudy.manager;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.model.ClassItem;
import vn.edu.activestudy.activestudy.model.StudentItem;

/**
 * Created by dell123 on 9/14/2015.
 */
public class StudentOfClassManager {

    private static StudentOfClassManager mInstance;
    private ArrayList<StudentItem> mListStudent;

    public StudentOfClassManager() {
        mListStudent = new ArrayList<>();
    }

    public static StudentOfClassManager getInstance() {
        if (mInstance == null)
            mInstance = new StudentOfClassManager();
        return mInstance;
    }

    public ArrayList<StudentItem> getListStudentOfClass() {
        if (mListStudent.size() == 0) {
            //TODO get from DB
        }
        initTemplateData();
        return mListStudent;
    }

    private void initTemplateData() {
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 1"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 2"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 3"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 4"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 5"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 6"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 7"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 8"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 9"));
        mListStudent.add(new StudentItem(R.drawable.img_java, "Student 10"));
    }


}
