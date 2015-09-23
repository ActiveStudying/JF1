package vn.edu.activestudy.activestudy.util;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import vn.edu.activestudy.activestudy.ASController;
import vn.edu.activestudy.activestudy.model.entity.DeviceInfo;

/**
 * Created by dell123 on 8/21/2015.
 */
public class DeviceUtil {
    public static DeviceInfo getDeviceInfo(Context context) {
        // DeviceInfo deviceInfo = new DeviceInfo();
//        deviceInfo.setDeviceID("123456789");
//        deviceInfo.setDeviceName("test");
//        deviceInfo.setOsName("android");
//        deviceInfo.setOsVersion("2.4");
//        deviceInfo.setCloudKey("999999999999");
//        deviceInfo.setDevOther("");

        DeviceInfo deviceInfo = new DeviceInfo();

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        deviceInfo.setOsName("Android");
        deviceInfo.setDeviceID(tm.getDeviceId());
        deviceInfo.setCloudKey(ASController.getInstance().getRegistrationID(context));
        deviceInfo.setDeviceName(Build.MODEL);
        deviceInfo.setOsVersion(String.valueOf(Build.VERSION.SDK_INT));
        deviceInfo.setDevOther(Build.PRODUCT);

        return deviceInfo;
    }
}
