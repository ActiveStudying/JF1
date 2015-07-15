package Message.request;

//import static jfday3.Message.iDLoginResponse;

import Message.request.Request;

//import static jfday3.Message.nameLoginResponse;
public class Login extends Request {

   
    private String userName;
    private String password;

    public Login(String userName, String password) {
        super(ID_LOGIN,NAME_lOGIN);      
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}



    