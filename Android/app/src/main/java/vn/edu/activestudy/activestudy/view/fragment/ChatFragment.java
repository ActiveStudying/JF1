package vn.edu.activestudy.activestudy.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.adapter.ChatGroupAdapter;
import vn.edu.activestudy.activestudy.manager.ChatGroupManager;
import vn.edu.activestudy.activestudy.model.ChatGroupItem;
import vn.edu.activestudy.activestudy.util.ToastUtil;
import vn.edu.activestudy.activestudy.view.activity.ChatGroupActivity;

/**
 * Created by Administrator on 30/08/2015.
 */
public class ChatFragment extends Fragment {

    private ArrayList<ChatGroupItem> listChatGroup;
    GridView grvChatGroup;
    ChatGroupAdapter mChatGroupAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_chat, container, false);
        initUI(view);
        initData();
        initControl();

        return view;
    }

    private void initUI(View view) {
        grvChatGroup = (GridView) view.findViewById(R.id.grvChatGroup);
    }

    private void initData() {
        listChatGroup = ChatGroupManager.getInstance().getListChatGroup();
        mChatGroupAdapter = new ChatGroupAdapter(getActivity(), listChatGroup);
        grvChatGroup.setAdapter(mChatGroupAdapter);
    }

    private void initControl() {
        grvChatGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), ChatGroupActivity.class));
                ToastUtil.makeToast(position + "");
            }
        });
    }
}

