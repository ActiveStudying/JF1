package vn.edu.activestudy.activestudy.task.sentmessage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 05/10/2015.
 */
public class ResultDataSentMessage {

    @SerializedName("messageID")
    private String messageID;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
}
