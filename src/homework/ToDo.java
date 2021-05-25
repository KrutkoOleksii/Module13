package homework;

import com.google.gson.annotations.SerializedName;

public class ToDo {
    @SerializedName("userId")
    private Integer userId;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("completed")
    private Boolean completed;

    @Override
    public String toString() {
        return "\nToDo{" +
                "\n\tuserId=" + userId +
                ", \n\tid=" + id +
                ", \n\ttitle='" + title + '\'' +
                ", \n\tcompleted=" + completed +
                "\n}";
    }
}
/*{
    "userId": 1,
    "id": 1,
    "title": "delectus aut autem",
    "completed": false
  }*/