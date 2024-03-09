package jsonplaceholder.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPogo {
    int id;
    String name;
    @SerializedName("username")
    String userName;
    String email;
    String street;
    String suite;
    String city;
    String zipcode;
    String lat;
    String lng;
    String phone;
    String website;
    @SerializedName("name")
    String companyName;
    String catchPhrase;
    String bs;
}
