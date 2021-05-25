package homework;

import com.google.gson.annotations.SerializedName;

public class PostAddress{
    @SerializedName("street")
    private String street;
    @SerializedName("suite")
    private String suite;
    @SerializedName("city")
    private String city;
    @SerializedName("zipcode")
    private String zipcode;
    @SerializedName("geo")
    private Geo geo;

    public PostAddress(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "PostAddress{" +
                "\n\tstreet='" + street + '\'' +
                ", \n\tsuite='" + suite + '\'' +
                ", \n\tcity='" + city + '\'' +
                ", \n\tzipcode='" + zipcode + '\'' +
                ", \n\tgeo=" + geo +
                "\n}";
    }
}