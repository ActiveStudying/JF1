package vn.edu.activestudy.activestudy.task.activate;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/24/2015.
 */
public class RequestActivate {

    @SerializedName("email")
    private String email;

    @SerializedName("passord")
    private String passord;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}
