package vn.edu.activestudy.activestudy.task.activate;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/24/2015.
 */
public class Info {

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
