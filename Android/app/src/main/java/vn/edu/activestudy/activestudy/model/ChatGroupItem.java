package vn.edu.activestudy.activestudy.model;

/**
 * Created by Administrator on 25/09/2015.
 */
public class ChatGroupItem {

    private String nameGroup;
    private int pictureId;
    private String nameMember;

    public ChatGroupItem(String nameGroup, int pictureId, String nameMember) {
        this.nameGroup = nameGroup;
        this.pictureId = pictureId;
        this.nameMember = nameMember;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getNameMember() {
        return nameMember;
    }

    public void setNameMember(String nameMember) {
        this.nameMember = nameMember;
    }
}
