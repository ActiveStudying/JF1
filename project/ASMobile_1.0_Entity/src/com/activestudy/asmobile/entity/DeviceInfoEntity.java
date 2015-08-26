/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.entity;

/**
 *
 * @author tanhai
 */
public class DeviceInfoEntity {

    private final String deviceId;
    private final String deviceName;
    private final String osName;
    private final String osVersion;
    private final String cloudKey;
    private final String devOther;

    public DeviceInfoEntity(String deviceID, String deviceName, String osName,
            String osVersion, String cloudKey, String devOther) {
        this.deviceId = deviceID;

        if (deviceName == null) {
            this.deviceName = "";
        } else {
            this.deviceName = deviceName;
        }

        if (osName == null) {
            this.osName = "";
        } else {
            this.osName = osName;
        }

        if (osVersion == null) {
            this.osVersion = "";
        } else {
            this.osVersion = osVersion;
        }

        if (cloudKey == null) {
            this.cloudKey = "";
        } else {
            this.cloudKey = cloudKey;
        }

        if (devOther == null) {
            this.devOther = "";
        } else {
            this.devOther = devOther;
        }
    }
  

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getOsName() {
        return osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getCloudKey() {
        return cloudKey;
    }

    public String getDevOther() {
        return devOther;
    }
}
