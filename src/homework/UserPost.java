package homework;

import com.google.gson.annotations.SerializedName;

public class UserPost {
    @SerializedName("userId")
    private Integer userId;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public UserPost(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nUserPost{" +
                "\n\tuserId=" + userId +
                ", \n\tid=" + id +
                ", \n\ttitle='" + title + '\'' +
                ", \n\tbody='" + body + '\'' +
                "\n}";
    }
}
/*{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
  }*/