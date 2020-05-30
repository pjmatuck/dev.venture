package learn.java.marsweather.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import learn.java.marsweather.model.MarsPhoto;
import learn.java.marsweather.model.WeatherStatus;
import learn.java.marsweather.retrofit.RetrofitConfig;

public class MarsWeatherViewModel extends ViewModel {

    public MutableLiveData<WeatherStatus> weatherStatusMutableLiveData
            = new MutableLiveData<WeatherStatus>();
    public MutableLiveData<String> photoURL = new MutableLiveData<>();

    RetrofitConfig retrofitConfigWeather = new RetrofitConfig(false);
    RetrofitConfig retrofitConfigPhoto = new RetrofitConfig(true);

    public static final String TAG = MarsWeatherViewModel.class.getSimpleName();

    public void getLatestMarsWeather() {
        retrofitConfigWeather.getMarsWeatherAPI().getLatestWeather()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<WeatherStatus, WeatherStatus>() {
                    @Override
                    public WeatherStatus apply(WeatherStatus weatherStatus) throws Throwable {
                        WeatherStatus ws = new WeatherStatus();
                        ws = weatherStatus;
                        ws.setSeason(weatherStatus.getSeason().toUpperCase());
                        return ws;
                    }
                })
                .subscribe(new Consumer<WeatherStatus>() {
                    @Override
                    public void accept(WeatherStatus weatherStatus) throws Throwable {
                        weatherStatusMutableLiveData.setValue(weatherStatus);
                    }
                });
    }

    public void getMarsPhoto(){
        String date, camera;
        date = "2020-5-29";
        camera = "fhaz";

        retrofitConfigPhoto.getMarsPhotoAPI().getMarsPhoto(date)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MarsPhoto>() {
                    @Override
                    public void accept(MarsPhoto marsPhoto) throws Throwable {
                        Random random = new Random();
                        int randomNumber = random.nextInt(marsPhoto.getPhotos().size());
                        String receivedPhotoURL = marsPhoto.getPhotos().get(randomNumber).getImg_src();
                        Log.d(TAG, receivedPhotoURL);
                        photoURL.setValue(receivedPhotoURL);
                    }
                });
    }
}
