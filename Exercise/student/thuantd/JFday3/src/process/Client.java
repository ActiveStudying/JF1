
package process;

import Message.IMessage;
import Message.request.Login;
import Message.request.Logout;
import Message.request.PerInfor;
import Message.response.Response;

public class Client {
    public Login genLogin(){
        Login loginObj= new Login("Thanh","123456" );
        return loginObj;
    
    }
    public Logout genLogout(){
        return (new Logout()); //Logout 
        
    }
    public PerInfor genPerinfor(){
        //PerInfor perObj=new PerInfor();
        return new PerInfor();
    }
    public void receiver(Response response){
        response.getID();
        if(response.getID()==IMessage.ID_LOGIN_RESPONSE){
       
         PerInfor perInfor= genPerinfor();// set perInfor truoc khi gui di
         Socket.getInstance().sent(perInfor);
        }
    
    }
}
