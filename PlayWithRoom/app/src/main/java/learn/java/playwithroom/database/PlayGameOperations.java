package learn.java.playwithroom.database;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import learn.java.playwithroom.model.PlayGame;

public class PlayGameOperations {

    Context context;
    DatabaseConnection connection;

    public PlayGameOperations(Context context) {
        this.context = context;
        connection = DatabaseConnection.getInstance(context);
    }

    public void insertPLayGame(PlayGame game){
        new InsertGameTask().execute(game);
    }

    public List<PlayGame> getAllGames(){
        List<PlayGame> playGamesList = new ArrayList<>();

        try {
            playGamesList = new GetAllGamesTask().execute().get();
        } catch (ExecutionException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return playGamesList;
    }

    public void deleteLastItem(PlayGame game){
        new DeleteLastTask().execute(game);
    }



    public class InsertGameTask extends AsyncTask<PlayGame, Void, Void>{
        @Override
        protected Void doInBackground(PlayGame... playGames) {
            connection.playGameDao().insert(playGames[0]);
            return null;
        }
    }

    public class GetAllGamesTask extends AsyncTask<Void, Void, List<PlayGame>>{
        @Override
        protected List<PlayGame> doInBackground(Void... voids) {
            return connection.playGameDao().getAllGames();
        }
    }

    public class DeleteLastTask extends AsyncTask<PlayGame, Void, Void>{

        @Override
        protected Void doInBackground(PlayGame... playGames) {
            connection.playGameDao().deleteLastElement(playGames[0]);
            return null;
        }
    }

}
