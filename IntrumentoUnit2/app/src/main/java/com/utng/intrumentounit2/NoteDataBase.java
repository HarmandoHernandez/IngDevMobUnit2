package com.utng.intrumentounit2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/** Valida **/
@Database(entities = {Note.class}, version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    public abstract NoteDao getNoteDao();
}
