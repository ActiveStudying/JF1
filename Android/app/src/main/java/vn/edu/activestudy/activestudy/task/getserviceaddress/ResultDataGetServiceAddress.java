package vn.edu.activestudy.activestudy.task.getserviceaddress;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResultDataGetServiceAddress {
    @SerializedName("serviceId")
    private String serviceId;

    @SerializedName("serviceType")
    private String serviceType;

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }
}
