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
import vn.edu.activestudy.activestudy.model.Class;

/**
 * Created by dell123 on 9/13/2015.
 */
public class ClassAdapter extends ArrayAdapter<Class> {

    private Activity context;
    private int resource;
    private ArrayList<Class> objects;

    public ClassAdapter(Activity context, int resource, ArrayList<Class> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        convertView = layoutInflater.inflate(resource, null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgClass);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvNameClass);
        TextView tvDes = (TextView) convertView.findViewById(R.id.tvDescriptionClass);

        Class c = objects.get(position);
        imageView.setImageResource(c.getPicture());
        tvName.setText(c.getNameCourse());
        tvDes.setText(c.getDescription());

        return convertView;
    }
}
