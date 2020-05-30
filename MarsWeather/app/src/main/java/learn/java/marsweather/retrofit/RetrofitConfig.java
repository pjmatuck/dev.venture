package learn.java.marsweather.retrofit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;
    private String weatherBaseURL = "https://api.mars.spacexcompanion.app/v1/";
    private String photoBaseURL = "http://mars-photos.herokuapp.com/api/v1/";

    public RetrofitConfig(boolean isPhoto){
        retrofit = new Retrofit.Builder()
                .baseUrl(isPhoto ? photoBaseURL : weatherBaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public MarsWeatherAPI getMarsWeatherAPI(){
        return retrofit.create(MarsWeatherAPI.class);
    }

    public MarsPhotoAPI getMarsPhotoAPI(){
        return retrofit.create(MarsPhotoAPI.class);
    }
}
