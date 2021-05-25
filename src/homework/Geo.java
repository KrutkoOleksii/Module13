package homework;

import com.google.gson.annotations.SerializedName;

public class Geo{
    @SerializedName("lat")
    private Float lat;
    @SerializedName("lng")
    private Float lng;

    public Geo(Float lat, Float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "\n\t\tlat=" + lat.toString() +
                ", \n\t\tlng=" + lng.toString() +
                "\n\t}";
    }
}
