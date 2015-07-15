
package Message.request;

import Message.request.Request;

public class Logout extends Request{

    public Logout(int iD, String name) {
        super(iD, name);
    }

    public Logout() {
        super(ID_LOGOUT,NAME_LOGOUT);
    }
    
}

    