package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("name")
    private String name;
    @SerializedName("catchPhrase")
    private String catchPhrase;
    @SerializedName("bs")
    private String bs;

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "\n\tname='" + name + '\'' +
                ", \n\tcatchPhrase='" + catchPhrase + '\'' +
                ", \n\tbs='" + bs + '\'' +
                "\n}";
    }
}
