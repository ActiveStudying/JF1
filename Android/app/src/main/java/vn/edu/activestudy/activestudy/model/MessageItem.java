package vn.edu.activestudy.activestudy.model;

import java.util.Date;

/**
 * Created by Administrator on 27/09/2015.
 */
public class MessageItem {

    private int messageId;
    private String messageTime;
    private String accountId;
    private String messageData;

    public MessageItem(int messageId, String messageData, String accountId, String messageTime) {
        this.messageId = messageId;
        this.messageData = messageData;
        this.accountId = accountId;
        this.messageTime = messageTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageData() {
        return messageData;
    }

    public void setMessageData(String messageData) {
        this.messageData = messageData;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
