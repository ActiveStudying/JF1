package Message;

import Message.IMessage;

public class Message implements IMessage {

    
    protected int iD;
    protected String name;


    public Message(int iD, String name) {
   
        this.iD=iD;
        this.name=name;
       

    }

    @Override
    public int getID() {
        return iD;
    }


    @Override
    public void setID(int iD) {
        this.iD=iD;
    }

    @Override
    public String getName() {
       return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

  
}
