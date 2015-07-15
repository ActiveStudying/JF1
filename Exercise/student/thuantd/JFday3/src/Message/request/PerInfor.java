
package Message.request;
import Message.request.Request;
import java.util.Date;


public class PerInfor extends Request{
    
    private String perName;
    private Date  perBirtday;
    private String perAddress;
    private String perPhone;
    private String perSex;

    public PerInfor() {
        super(ID_PERINFOR, NAME_PERINFOR);
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public Date getPerBirtday() {
        return perBirtday;
    }

    public void setPerBirtday(Date perBirtday) {
        this.perBirtday = perBirtday;
    }

    public String getPerAddress() {
        return perAddress;
    }

    public void setPerAddress(String perAddress) {
        this.perAddress = perAddress;
    }

    public String getPerPhone() {
        return perPhone;
    }

    public void setPerPhone(String perPhone) {
        this.perPhone = perPhone;
    }

    public String getPerSex() {
        return perSex;
    }

    public void setPerSex(String perSex) {
        this.perSex = perSex;
    }
    
    
}
    



        
        
    

