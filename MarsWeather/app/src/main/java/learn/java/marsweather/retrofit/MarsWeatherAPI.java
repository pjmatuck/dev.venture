package learn.java.marsweather.retrofit;

import io.reactivex.rxjava3.core.Observable;
import learn.java.marsweather.model.WeatherStatus;
import retrofit2.http.GET;

public interface MarsWeatherAPI {

    @GET("weather/latest")
    Observable<WeatherStatus> getLatestWeather();
}
