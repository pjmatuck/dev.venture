package learn.java.marsweather.retrofit;

import io.reactivex.rxjava3.core.Observable;
import learn.java.marsweather.model.MarsPhoto;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarsPhotoAPI {

    @GET("rovers/curiosity/photos")
    Observable<MarsPhoto> getMarsPhoto(@Query("earth_date") String date/*, @Query("camera") String camera*/);

}
