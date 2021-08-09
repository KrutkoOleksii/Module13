package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("postId")
    private Integer postId;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("body")
    private String body;

    @Override
    public String toString() {
        return "Comment{" +
                "\n\tpostId=" + postId +
                ", \n\tid=" + id +
                ", \n\tname='" + name + '\'' +
                ", \n\temail='" + email + '\'' +
                ", \n\tbody='" + body + '\'' +
                "\n}";
    }
}
/*{
    "postId": 10,
    "id": 46,
    "name": "dignissimos et deleniti voluptate et quod",
    "email": "Jeremy.Harann@waino.me",
    "body": "exercitationem et id quae cum omnis\nvoluptatibus accusantium et quidem\nut ipsam sint\ndoloremque illo ex atque necessitatibus sed"
  }*/