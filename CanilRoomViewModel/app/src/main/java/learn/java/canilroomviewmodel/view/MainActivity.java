package learn.java.canilroomviewmodel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import learn.java.canilroomviewmodel.R;
import learn.java.canilroomviewmodel.model.Dog;
import learn.java.canilroomviewmodel.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Call<List<Dog>> requestDogsList;
    RetrofitConfig retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new RetrofitConfig();

        requestDogsList = retrofit.getDogAPI().getAllDogs();
        requestDogsList.enqueue(new Callback<List<Dog>>() {
            @Override
            public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {
                if(response.isSuccessful()){
                    List<Dog> dogs = response.body();
                    for (Dog dog: dogs) {
                        Log.d("MainActivity", dog.getName() + "\n");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                Log.d("MainActivity", t.getMessage());
            }
        });
    }
}
