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
import vn.edu.activestudy.activestudy.model.StudentItem;

/**
 * Created by dell123 on 9/13/2015.
 */
public class StudentAdapter extends ArrayAdapter<StudentItem> {

    private Activity context;
    private int resource;
    private ArrayList<StudentItem> objects;

    public StudentAdapter(Activity context, int resource, ArrayList<StudentItem> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        convertView = layoutInflater.inflate(resource, null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgStudent);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvNameStudent);

        StudentItem s = objects.get(position);
        imageView.setImageResource(s.getPicture());
        tvName.setText(s.getNameStudent());

        return convertView;
    }
}
