package learn.java.playwithretrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit config;
    private String baseUrl = "https://pokeapi.co/api/v2/";

    public RetrofitConfig(){

        config = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public PokemonAPI getPokemonAPI() {
        return config.create(PokemonAPI.class);
    }
}
