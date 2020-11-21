package com.utng.intrumentounit2;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.List;
import androidx.room.Room;

/** Valida **/
public class NoteLab {
    @SuppressLint("StaticFieldLeak")
    private static NoteLab sNoteLab;

    private NoteDao mNoteDao;
    private static final String DATABASE_NAME = "notes_database";

    private NoteLab(Context context) {
        Context appContext = context.getApplicationContext();
        NoteDataBase database = Room.databaseBuilder(appContext, NoteDataBase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        mNoteDao = database.getNoteDao();
    }

    public static NoteLab get(Context context) {
        if (sNoteLab == null) {
            sNoteLab = new NoteLab(context);
        }
        return sNoteLab;
    }

    public List<Note> getNotes() {
        return mNoteDao.getNotes();
    }

    public Note getNote(String id) {
        return mNoteDao.getNote(id);
    }

    public void addNote(Note note) {
        mNoteDao.addNote(note);
    }

    public void updateNote(Note note) {
        mNoteDao.updateNote(note);
    }

    public void deleteNote(Note note) {
        mNoteDao.deleteNote(note);
    }
}
