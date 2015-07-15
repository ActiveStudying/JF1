package Message;

public interface IMessage {

    int ID_LOGIN = 1;
    int ID_LOGOUT = 2;
    int ID_PERINFOR = 3;
    int ID_LOGIN_RESPONSE = 4;
    int ID_LOGOUT_RESPONSE = 5;
    int ID_PERINFOR_RESPONSE = 6;
    String NAME_lOGIN = "Login";
    String NAME_LOGOUT = "Logout";
    String NAME_PERINFOR = "PerInfor";
    String NAME_LOGIN_RESPONSE = "LoginResponse";
    String NAME_LOGOUT_RESPONSE = "LogoutResponse";
    String NAME_PERINFOR_RESPONSE = "PerInforResponse";
    

    public int getID();

    public void setID(int iD);

    public String getName();

    public void setName(String name);

}
