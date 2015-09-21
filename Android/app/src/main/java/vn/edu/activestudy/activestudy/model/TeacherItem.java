package vn.edu.activestudy.activestudy.model;

/**
 * Created by Administrator on 16/09/2015.
 */
public class TeacherItem {
    private int pictureId;

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    private String name;
    private String phoneNumber;
    private String email;
    private String adress;
    private String facebook;
    private String skype;

    public TeacherItem(int pictureId, String name, String phoneNumber, String email, String adress, String facebook, String skype) {
        this.pictureId = pictureId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
        this.facebook = facebook;
        this.skype = skype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }
}
