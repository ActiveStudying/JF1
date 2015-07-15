package Message.request;

import Message.Message;

public class Request extends Message {

    private long tranID;
    private static long seqRequestID;

    public Request(int iD, String name) {
        super(iD, name);
        tranID=GenRequestID();
    }

    public long getRequestID() {
        return tranID;
    }

    
    private synchronized long GenRequestID(){//synchronized:không cho nhiều tiến trình cùng truy cập cùng 1 lúc.
        seqRequestID++;
        return seqRequestID;
    }

   
    



}
