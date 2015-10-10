package vn.edu.activestudy.activestudy.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.model.MessageItem;

/**
 * Created by Administrator on 27/09/2015.
 */
public class ChatGroupListAdapter extends ArrayAdapter<MessageItem> {
    private Activity context;
    private int resource;
    private ArrayList<MessageItem> objects;

    public ChatGroupListAdapter(Activity context, int resource, ArrayList<MessageItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    public static boolean isMe;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        convertView = layoutInflater.inflate(resource, null);
        MessageItem m = objects.get(position);
        final ViewHolder holder = new ViewHolder();
        holder.tvBody = (TextView) convertView.findViewById(R.id.tvBodyItemChat);
        holder.imageLeft = (CircleImageView) convertView.findViewById(R.id.ivProfileLeft);
        holder.imageRight = (CircleImageView) convertView.findViewById(R.id.ivProfileRight);
        holder.tvBody.setText(m.getMessageData());

        if (m.getAccountId().equals("true")) {
            holder.imageRight.setVisibility(View.VISIBLE);
            holder.imageLeft.setVisibility(View.GONE);
            holder.tvBody.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        } else {
            holder.imageLeft.setVisibility(View.VISIBLE);
            holder.imageRight.setVisibility(View.GONE);
            holder.tvBody.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        }


        return convertView;
    }

    final class ViewHolder {
        public CircleImageView imageLeft;
        public CircleImageView imageRight;
        public TextView tvBody;
    }
}
