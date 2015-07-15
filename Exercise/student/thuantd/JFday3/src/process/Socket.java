package process;

import Message.Message;
import Message.request.Request;
import Message.response.Response;

public class Socket {
    static Socket instance; 

    private Client clientObj;
    private Server serverObj;

    private Socket() {
     }

    public Client getClientObj() {
        return clientObj;
    }

    public void setClientObj(Client clientObj) {
        this.clientObj = clientObj;
    }

    public Server getServerObj() {
        return serverObj;
    }

    public void setServerObj(Server serverObj) {
        this.serverObj = serverObj;
    }
    

    public int sent(Message message) {

        if (message instanceof Request) {
            serverObj.receiver((Request) message);
            return 1;
        } else if (message instanceof Response) {
            clientObj.receiver((Response) message);
            return 1;
        } else {
            return 0;
        }
       
    }
    public static Socket getInstance(){
        if (instance==null){
        instance = new Socket();
        }
        return instance;
    }
}
