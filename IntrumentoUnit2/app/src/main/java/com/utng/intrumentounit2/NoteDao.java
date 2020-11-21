package com.utng.intrumentounit2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

/** Valida **/
@Dao
public interface NoteDao {
    @Query("SELECT * FROM " + Note.TABLE_NAME + " ORDER BY title")
    List<Note> getNotes();

    @Query("SELECT * FROM " + Note.TABLE_NAME + " WHERE id LIKE :uuid")
    Note getNote(String uuid);

    @Insert
    void addNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Update
    void updateNote(Note note);
}
