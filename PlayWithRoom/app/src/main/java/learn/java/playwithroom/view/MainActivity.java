package learn.java.playwithroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import learn.java.playwithroom.R;
import learn.java.playwithroom.adapters.PlayGamesAdapter;
import learn.java.playwithroom.database.DatabaseConnection;
import learn.java.playwithroom.database.PlayGameOperations;
import learn.java.playwithroom.databinding.ActivityMainBinding;
import learn.java.playwithroom.model.PlayGame;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<PlayGame> gamesList;
    //DatabaseConnection connection;
    PlayGamesAdapter adapter;
    PlayGameOperations operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        gamesList = new ArrayList<>();
        //connection = DatabaseConnection.getInstance(this);
        operations = new PlayGameOperations(this);


        adapter = new PlayGamesAdapter(gamesList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        binding.buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGame playGame = new PlayGame("Amarelinha", 10, "Pular amarelinha.");
                operations.insertPLayGame(playGame);
            }
        });

        binding.buttonGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamesList.clear();
                gamesList.addAll(operations.getAllGames());
                binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
                adapter.notifyDataSetChanged();
            }
        });

        binding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!gamesList.isEmpty()) {
                    operations.deleteLastItem(gamesList.get(gamesList.size() - 1));
                    gamesList.remove(gamesList.size() - 1);
                } else {
                    Toast.makeText(getApplicationContext(), "Lista vazia", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
