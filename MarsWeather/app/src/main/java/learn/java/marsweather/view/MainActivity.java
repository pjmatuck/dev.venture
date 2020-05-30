package learn.java.marsweather.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import learn.java.marsweather.R;
import learn.java.marsweather.model.WheaterStatus;
import learn.java.marsweather.retrofit.RetrofitConfig;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    RetrofitConfig retrofit;

    TextView season, temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        season = findViewById(R.id.textView_season);
        temperature = findViewById(R.id.textView_temp_average);

        String nome = "Pedro";
        retrofit = new RetrofitConfig();

        //retrofit.getMarsWheaterAPI().getLatestWheater();

        retrofit.getMarsWeatherAPI().getLatestWeather()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WheaterStatus>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WheaterStatus wheaterStatus) {
                        Log.d(TAG, wheaterStatus.getSeason());
                        season.setText(wheaterStatus.getSeason());
                        temperature.setText(String.valueOf(wheaterStatus.getAir().getTemperature().getAverage()));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
