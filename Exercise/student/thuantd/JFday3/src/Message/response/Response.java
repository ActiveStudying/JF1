package Message.response;

import Message.Message;
import result.Result;

public class Response extends Message {

    protected Result result;
    private long tranID;

    public Response(int iD, String name) {
        super(iD, name);
    }

    public long getTranID() {
        return tranID;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    

    

    
}
