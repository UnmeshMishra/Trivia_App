package com.my.triviaapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuizDao {

//    @Query("SELECT * FROM products_entry ORDER BY priority")

    @Query("SELECT * FROM quiz_game")
    LiveData<List<QuizGame>> loadAllQuizGames();

    @Insert
    void insertQuizgame(QuizGame quizGame);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateQuiz(QuizGame quizGame);

    @Delete
    void deleteQuiz(QuizGame quizGame);

    @Query("DELETE FROM quiz_game")
    void deleteAll();

    // to avoid live data issues
    @Query("SELECT * FROM quiz_game")
    List<QuizGame> getQuizGameList();

}
