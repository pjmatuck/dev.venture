package learn.java.canilroomviewmodel.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit config;
    private String baseUrl = "https://api.thedogapi.com/v1/";

    public RetrofitConfig() {

        config = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public DogAPI getDogAPI() {
        return config.create(DogAPI.class);
    }
}