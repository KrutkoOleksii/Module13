package homework;

import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface MyRetrofitClient {

    @GET("users")
    @Headers({"Content-Type: application/json"})
    Call<List<User>> GetToModel();

    @POST("users")
    @Headers({"Content-Type: application/json"})
    Call<User> addObject(@Body User user);

    @PUT("users/{id}")
    @Headers({"Content-Type: application/json"})
    Call<User> updateUser(@Body User user, @Path("id") String id);

    @DELETE("users/{id}")
    @Headers({"Content-Type: application/json"})
    Call<User> deleteUser(@Path("id") String id);

    @GET("users")
    @Headers({"Content-Type: application/json"})
    Call<List<User>> getUserByID(@Query("id") Integer id);

    @GET("users")
    @Headers({"Content-Type: application/json"})
    Call<List<User>> getUserByUserName(@Query("username") String userName);

    @GET("users/{userID}/posts")
    @Headers({"Content-Type: application/json"})
    Call<List<UserPost>> getUserPosts(@Path("userID") String userID);

    @GET("posts/{postID}/comments")
    Call<List<Comment>> getComments(@Path("postID") String userID);

    @GET("users/{userID}/todos")
    Call<List<ToDo>> getTodos(@Path("userID") String userID, @Query("completed") boolean completed);
}
