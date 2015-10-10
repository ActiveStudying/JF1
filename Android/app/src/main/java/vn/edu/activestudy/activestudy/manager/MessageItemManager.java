package vn.edu.activestudy.activestudy.manager;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.model.MessageItem;

/**
 * Created by Administrator on 30/09/2015.
 */
public class MessageItemManager {
    private static MessageItemManager mInstance;
    private ArrayList<MessageItem> mListChatGroupList;

    public MessageItemManager() {
        mListChatGroupList = new ArrayList<MessageItem>();
    }

    public static MessageItemManager getInstance() {
        if (mInstance == null)
            mInstance = new MessageItemManager();
        return mInstance;
    }

    public ArrayList<MessageItem> getListChatGroupList() {
        if (mListChatGroupList.size() != 0) {
            //TODO get from DB
            return mListChatGroupList;
        } else {
            initTemplateData();
        }

        return mListChatGroupList;
    }

    private void initTemplateData() {

    }
}
