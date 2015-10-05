package vn.edu.activestudy.activestudy.task.sentconfestionmessage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 05/10/2015.
 */
public class ResultDataSentConfestionMessage {
    @SerializedName("messageID")
    private String messageID;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
}
