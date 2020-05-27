package learn.java.playwithretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import learn.java.playwithretrofit.databinding.ActivityMainBinding;
import learn.java.playwithretrofit.model.Pokemon;
import learn.java.playwithretrofit.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    RetrofitConfig retrofitConfig;

    Call<Pokemon> request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        retrofitConfig = new RetrofitConfig();

        binding.buttonRequest.setOnClickListener(v -> {
            int id = Integer.parseInt(binding.editTextSearch.getText().toString());
            request = retrofitConfig.getPokemonAPI().getPokemonById(id);
            request.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if(response.isSuccessful()) {
                        Pokemon pokemon = response.body();
                        binding.textViewId.setText(String.valueOf(pokemon.getId()));
                        binding.textViewName.setText(pokemon.getName());
                        binding.textViewHeight.setText(String.valueOf(pokemon.getHeight()));
                        binding.textViewWeight.setText(String.valueOf(pokemon.getWeight()));
                    }
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Fail to get Pokemon",
                            Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
