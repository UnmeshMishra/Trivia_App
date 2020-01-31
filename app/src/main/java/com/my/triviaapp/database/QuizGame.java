package com.my.triviaapp.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "quiz_game")
public class QuizGame {


    @ColumnInfo(name = "contestant_name")
    String contestantName;
    @ColumnInfo(name = "fav_cricketer")
    String favCricketer;
    @ColumnInfo(name = "flag_colors")
    String flagColors;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "entry_no")
    Integer entryNumber;

    @ColumnInfo(name = "updated_at")
    Date updatedAt;

    @Ignore
    public QuizGame(String contestantName, String favCricketer, String flagColors, Date updatedAt) {
        this.contestantName = contestantName;
        this.favCricketer = favCricketer;
        this.flagColors = flagColors;
        this.updatedAt = updatedAt;
    }

    public QuizGame(String contestantName, String favCricketer, String flagColors,
                    @NonNull Integer entryNumber, Date updatedAt) {
        this.contestantName = contestantName;
        this.favCricketer = favCricketer;
        this.flagColors = flagColors;
        this.entryNumber = entryNumber;
        this.updatedAt = updatedAt;
    }




    public String getContestantName() {
        return contestantName;
    }

    public void setContestantName(String contestantName) {
        this.contestantName = contestantName;
    }

    public String getFavCricketer() {
        return favCricketer;
    }

    public void setFavCricketer(String favCricketer) {
        this.favCricketer = favCricketer;
    }

    public String getFlagColors() {
        return flagColors;
    }

    public void setFlagColors(String flagColors) {
        this.flagColors = flagColors;
    }

    public Integer getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(int entryNumber) {
        this.entryNumber = entryNumber;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}