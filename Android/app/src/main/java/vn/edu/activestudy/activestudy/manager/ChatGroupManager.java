package vn.edu.activestudy.activestudy.manager;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.model.ChatGroupItem;
import vn.edu.activestudy.activestudy.model.ClassItem;

/**
 * Created by Administrator on 25/09/2015.
 */
public class ChatGroupManager {
    private static ChatGroupManager mInstance;
    private ArrayList<ChatGroupItem> mListChatGroup;

    public ChatGroupManager() {
        mListChatGroup = new ArrayList<ChatGroupItem>();
    }

    public static ChatGroupManager getInstance() {
        if (mInstance == null)
            mInstance = new ChatGroupManager();
        return mInstance;
    }

    public ArrayList<ChatGroupItem> getListChatGroup() {
        if (mListChatGroup.size() != 0) {
            //TODO get from DB
            return mListChatGroup;
        } else {
            initTemplateData();
        }

        return mListChatGroup;
    }

    private void initTemplateData() {
        mListChatGroup.add(new ChatGroupItem("Name Group 1", R.drawable.ronaldo, "Name Member group1"));
        mListChatGroup.add(new ChatGroupItem("Name Group 1", R.drawable.ronaldo, "Name Member group1"));
        mListChatGroup.add(new ChatGroupItem("Name Group 1", R.drawable.ronaldo, "Name Member group1"));
        mListChatGroup.add(new ChatGroupItem("Name Group 1", R.drawable.ronaldo, "Name Member group1"));
        mListChatGroup.add(new ChatGroupItem("Name Group 1", R.drawable.ronaldo, "Name Member group1"));
        mListChatGroup.add(new ChatGroupItem("Name Group 1", R.drawable.ronaldo, "Name Member group1"));
        mListChatGroup.add(new ChatGroupItem("Name Group 1", R.drawable.ronaldo, "Name Member group1"));
        mListChatGroup.add(new ChatGroupItem("Name Group 1", R.drawable.ronaldo, "Name Member group1"));
    }

}
