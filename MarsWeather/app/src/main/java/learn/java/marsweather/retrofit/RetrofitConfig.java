package learn.java.marsweather.retrofit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;
    private String baseURL = "https://api.mars.spacexcompanion.app/v1/";

    public RetrofitConfig(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public MarsWeatherAPI getMarsWeatherAPI(){
        return retrofit.create(MarsWeatherAPI.class);
    }
}
