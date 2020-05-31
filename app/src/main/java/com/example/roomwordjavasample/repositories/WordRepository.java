package com.example.roomwordjavasample.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomwordjavasample.daos.WordDao;
import com.example.roomwordjavasample.database.WordRoomDatabase;
import com.example.roomwordjavasample.models.Word;

import java.util.List;

/// provide data to word viewmodel to help ui to view the data
public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWordsASC();

    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}
