package vn.edu.activestudy.activestudy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.model.CourseItem;

/**
 * Created by Administrator on 03/09/2015.
 */
public class CourseAdapter extends ArrayAdapter<CourseItem> {

    Activity context;
    ArrayList<CourseItem> arrayList = null;
    String keyword = "";
    int layoutId;

    public CourseAdapter(Activity context, int layoutId, ArrayList<CourseItem> objects) {
        super(context, layoutId, objects);
        this.context = context;
        this.layoutId = layoutId;
        this.arrayList = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);

        ImageView img = (ImageView) convertView.findViewById(R.id.imgCourse);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvNameCourse);
        TextView tvDes = (TextView) convertView.findViewById(R.id.tvDescription);

        CourseItem c = arrayList.get(position);
        String name = c.getNameCourse();
        if (name.contains(keyword)) {
            tvName.setText("");
        }

        img.setImageResource(c.getPicture());

        tvName.setText(c.getNameCourse());
        tvDes.setText(c.getDescription());

        return convertView;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
