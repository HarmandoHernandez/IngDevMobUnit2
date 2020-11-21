package com.utng.intrumentounit2;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.List;
import androidx.room.Room;

/** Valida **/
public class NoteLab {
    @SuppressLint("StaticFieldLeak")
    private static NoteLab noteLab;

    private NoteDao noteDao;
    private static final String DATABASE_NAME = "notes_database";

    private NoteLab(Context context) {
        Context appContext = context.getApplicationContext();
        NoteDataBase database = Room.databaseBuilder(appContext, NoteDataBase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        noteDao = database.getNoteDao();
    }

    public static NoteLab get(Context context) {
        if (noteLab == null) {
            noteLab = new NoteLab(context);
        }
        return noteLab;
    }

    public List<Note> getNotes() {
        return noteDao.getNotes();
    }

    public Note getNote(String id) {
        return noteDao.getNote(id);
    }

    public void addNote(Note note) {
        noteDao.addNote(note);
    }

    public void updateNote(Note note) {
        noteDao.updateNote(note);
    }

    public void deleteNote(Note note) {
        noteDao.deleteNote(note);
    }
}
