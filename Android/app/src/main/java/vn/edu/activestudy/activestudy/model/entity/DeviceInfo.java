package vn.edu.activestudy.activestudy.model.entity;

/**
 * Created by dell123 on 8/21/2015.
 */
public class DeviceInfo {

    private String deviceID;
    private String deviceName;
    private String osName;
    private int osVersion;
    private String cloudKey;
    private String devOther;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public int getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(int osVersion) {
        this.osVersion = osVersion;
    }

    public String getCloudKey() {
        return cloudKey;
    }

    public void setCloudKey(String cloudKey) {
        this.cloudKey = cloudKey;
    }

    public String getDevOther() {
        return devOther;
    }

    public void setDevOther(String devOther) {
        this.devOther = devOther;
    }
}
