package com.example.roomwordjavasample.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.roomwordjavasample.utils.Constants;

@Entity(tableName = Constants.TABLE_NAME)
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = Constants.COLUMN_WORD)
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
