package com.utng.intrumentounit2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList


class MenuActivity: AppCompatActivity(), Dialog.DialogListener {
    private var noteLab: NoteLab ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        noteLab = NoteLab.get(this)
        fab.setOnClickListener {
            openDialog()
        }
        menu()
    }

    override fun onStart() {
        super.onStart()
        menu()
    }

    private fun menu() {
        val notes: List<Note> = noteLab?.notes ?: emptyList()

        val listNotes = ArrayList<NoteModel>()
        for (note in notes){
            listNotes.add(NoteModel(note.id, note.title, note.content, note.date))
        }

        val adapter = NoteAdapter(this, listNotes)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, NoteActivity::class.java)
            intent.putExtra("note", listNotes[position])
            startActivity(intent)
        }
    }

    private fun openDialog() {
        val dialog = Dialog()
        dialog.show(supportFragmentManager, "Data Dialog")
    }

    override fun applyTexts(title: String?) {
        if (title != null) {
            val newNote = Note("", title, "", DateFormat.getDateTimeInstance().format(Date()))
            noteLab?.addNote(newNote)
            Toast.makeText(this, "Nota agregada", Toast.LENGTH_SHORT).show()
            menu()
        }
    }
}