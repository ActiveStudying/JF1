package vn.edu.activestudy.activestudy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.model.ChatGroupItem;
import vn.edu.activestudy.activestudy.util.ToastUtil;
import vn.edu.activestudy.activestudy.view.activity.ChatGroupActivity;

/**
 * Created by Administrator on 25/09/2015.
 */
public class ChatGroupAdapter extends BaseAdapter {

    private ArrayList<ChatGroupItem> listChatGroup;
    private LayoutInflater mInflater;

    public ChatGroupAdapter(Context context, ArrayList<ChatGroupItem> results) {
        listChatGroup = results;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listChatGroup.size();
    }

    @Override
    public Object getItem(int position) {
        return listChatGroup.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView tvNameGroup;
        CircleImageView imgGroup;
        TextView tvNameMember;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = mInflater.inflate(R.layout.item_gridview_chat_group, null);

        holder.tvNameGroup = (TextView) rowView.findViewById(R.id.tvNameGroup);
        holder.tvNameMember = (TextView) rowView.findViewById(R.id.tvNameMember);
        holder.imgGroup = (CircleImageView) rowView.findViewById(R.id.civImageChatGroup);

        holder.imgGroup.setImageResource(listChatGroup.get(position).getPictureId());
        holder.tvNameGroup.setText(listChatGroup.get(position).getNameGroup());
        holder.tvNameMember.setText(listChatGroup.get(position).getNameMember());
        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ToastUtil.makeToast("You Clicked " + position);
                mInflater.getContext().startActivity(new Intent(mInflater.getContext(), ChatGroupActivity.class));

            }
        });

        return rowView;


    }
}
