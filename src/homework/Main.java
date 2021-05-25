package homework;

import com.google.gson.Gson;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.*;
import java.util.*;

import static homework.MyRetrofitConfig.createClient;
import static homework.MyRetrofitConfig.execute;


public class Main {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws IOException {
        // создание клиента Retrofit
        MyRetrofitClient client = createClient(BASE_URL,
                GsonConverterFactory.create(), MyRetrofitClient.class);

        // task #1/4 получение информации обо всех пользователях
        System.out.println("\n*************************************");
        System.out.println("Task #1/4. Show all users\n");
        List<User> listUsers = execute(client.GetToModel());
        System.out.println(listUsers);

        // task #1/1 создание нового объекта
        System.out.println("\n*************************************");
        System.out.println("Task #1/1. Add new object 'User'\n");
        User responseAdd = execute(client.addObject(getNewUser()));
        System.out.println(responseAdd);

        // Task #1/2 обновление объекта
        Integer idUpdate = 2;
        System.out.println("\n*************************************");
        System.out.println("Task #1/2. Update object 'User' with id="+idUpdate);
        System.out.println("(changing fields: Name='New Name', Email='newmail@mailservice.in.ua', Phone=215-050505-777)");
        listUsers.get(idUpdate-1).setName("New Name");
        listUsers.get(idUpdate-1).setEmail("newmail@mailservice.in.ua");
        listUsers.get(idUpdate-1).setPhone("215-050505-777");
        User responseUpdate = execute(client.updateUser(listUsers.get(idUpdate-1),idUpdate.toString()));
        System.out.println(responseUpdate);

        // Task #1/3 удаление объекта
        String idDelete = "1";
        System.out.println("\n*************************************");
        System.out.println("Task #1/3. Delete object 'User' with id="+idDelete+"\n");
        User responseDelete = execute(client.deleteUser(idDelete));
        System.out.println("User deleted:");
        System.out.println(responseDelete);

        // Task #1/5 получение информации о пользователе с определенным id
        Integer findID = 4;
        System.out.println("\n*************************************");
        System.out.println("Task #1/5. Find object 'User' by ID = '"+findID+"'\n");
        List<User> responseUserByID = execute(client.getUserByID(findID));
        System.out.println(responseUserByID);

        // Task #1/6 получение информации о пользователе с опредленным username
        String findUserName = "Samantha";
        System.out.println("\n*************************************");
        System.out.println("Task #1/6. Find object 'User' by username = '"+findUserName+"'\n");
        List<User> responseUserByUserName = execute(client.getUserByUserName(findUserName));
        System.out.println(responseUserByUserName);

        // Task #2
        Integer userID = 3;
        System.out.println("\n*************************************");
        System.out.println("Task #2. Get all user's posts for user_ID ["+userID+"]\n");
        List<UserPost> listPosts = execute(client.getUserPosts(userID.toString()));
        // last post:
        UserPost lastPost = Collections.max(listPosts, new Comparator<UserPost>() {
            @Override
            public int compare(UserPost o1, UserPost o2) {
                if (o1.getId() < o2.getId())
                    return -1; // highest value first
                if (o1.getId() == o2.getId())
                    return 0;
                return 1;
            }
        });
        List<Comment> listComments = execute(client.getComments(lastPost.getId().toString()));
        String fileName = "user-"+userID+"-post-"+lastPost.getId()+"-comments.json";
        try (
                FileWriter fileJson = new FileWriter(fileName)){
            fileJson.write(new Gson().toJson(listComments));
            System.out.println("All posts were written to a file '"+fileName+"'");
        }

        // Task #3
        System.out.println("\n*************************************");
        System.out.println("Task #3. List of unfinished todos for user_ID "+userID+" \n");
        List<ToDo> listTodos = execute(client.getTodos(userID.toString(),false));
        System.out.println(listTodos);
    }

    private static User getNewUser() {
        return new User("Oleksii",
                "kav",
                "krutko.av@gmail.com",
                new PostAddress("Tankopiya",
                        "7777",
                        "Kharkiv",
                        "61000",
                        new Geo(50.2345F, 50.23456F)),
                "098-7654321",
                "www.my-favorite-site.com.ua",
                new Company("GARNET",
                        "business process automation",
                        "projects & help desk")
        );
    }

}
