package vn.edu.activestudy.activestudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.manager.TeacherManager;
import vn.edu.activestudy.activestudy.model.TeacherItem;
import vn.edu.activestudy.activestudy.util.ToastUtil;

/**
 * Created by Administrator on 17/09/2015.
 */
public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private List<TeacherItem> teacherList;

    public TeacherAdapter(List<TeacherItem> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_teacher, parent, false);

        return new TeacherViewHolder(itemView, teacherList);
    }

    @Override
    public void onBindViewHolder(TeacherViewHolder holder, int position) {
        TeacherItem ti = teacherList.get(position);
        holder.civPictureProfile.setImageResource(ti.getPictureId());
        holder.tvName.setText(ti.getName());
        holder.tvPhoneNumber.setText(ti.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    public static class TeacherViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        protected CircleImageView civPictureProfile;
        protected TextView tvName;
        protected TextView tvPhoneNumber;
        List<TeacherItem> teacherList;

        public TeacherViewHolder(View v, List<TeacherItem> teacherList) {
            super(v);
            this.teacherList = teacherList;
            v.setOnClickListener(this);
            tvName = (TextView) v.findViewById(R.id.tvNameTeacher);
            tvPhoneNumber = (TextView) v.findViewById(R.id.tvPhoneNumberTeacher);
            civPictureProfile = (CircleImageView) v.findViewById(R.id.civPictureProfile);

        }

        @Override
        public void onClick(View v) {
            TeacherItem ti = teacherList.get(getPosition());
            ToastUtil.makeToast(ti.getName() + "  " + ti.getPhoneNumber());
        }
    }
}
