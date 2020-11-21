package com.utng.intrumentounit2;

import java.util.UUID;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/** Valida **/
@Entity(tableName = Note.TABLE_NAME)
public class Note {
    static final String TABLE_NAME = "Note";

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "title")
    @NonNull
    String title;

    @ColumnInfo(name = "content")
    String content;

    @ColumnInfo(name = "date")
    @NonNull
    String date;

    public Note(@NonNull String title, String content, @NonNull String date) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }
/*
    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    */
}

