package learn.java.playwithroom.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import learn.java.playwithroom.model.PlayGame;

@Dao
public interface PlayGameDao {

    @Insert
    public void insert(PlayGame game);

    @Query("SELECT * FROM PlayGame")
    List<PlayGame> getAllGames();

    @Query("SELECT * FROM PlayGame WHERE id= :id")
    PlayGame getById(int id);

    @Delete
    void deleteLastElement(PlayGame playGame);

}
