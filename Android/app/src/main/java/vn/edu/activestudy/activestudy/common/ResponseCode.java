package vn.edu.activestudy.activestudy.common;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseCode {

    public final static int ERROR = -2;
    public final static int SYSTEM_ERROR = -1;
    public final static int SUCCESS = 0;

    public final static int MAUTHEN_SESSIONID_INVALIDFORMAT = 1;
    public final static int MAUTHEN_ACCOUNTID_INVALIDFORMAT = 2;
    public final static int MAUTHEN_ACCOUNTID_UNEXIST = 3;
    public final static int MAUTHEN_OTPCODE_INVALIDFORMAT = 4;
    public final static int MAUTHEN_AUTHENID_INVALIDFORMAT = 5;
    public final static int SERVICEID_INVALIDFORMAT = 6;
    public final static int OVER_NUMBERRETRY_OTPCODE = 7;
    public final static int MAUTHEN_DEVICEID_EMPTY = 8;

}
