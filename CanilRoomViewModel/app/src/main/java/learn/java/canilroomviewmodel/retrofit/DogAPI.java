package learn.java.canilroomviewmodel.retrofit;

import java.util.List;

import learn.java.canilroomviewmodel.model.Dog;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DogAPI {

    @GET("breeds")
    Call<List<Dog>> getAllDogs();
}
