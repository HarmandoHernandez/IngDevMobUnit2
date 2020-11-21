package com.utng.intrumentounit2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity: AppCompatActivity(), Dialog.DialogListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        fab.setOnClickListener {
            openDialog()
        }
        menu()
    }

    private fun menu() {
        val noteLab = NoteLab.get(this)
        val notes: List<Note> = noteLab.notes

        val listNotes = ArrayList<Note>()
        for (note in notes){
            listNotes.add(note)
            println("note : $note")
        }

        val adapter = NoteAdapter(this, listNotes)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, NoteActivity::class.java)
            intent.putExtra("note", NoteModel(
                listNotes[position].title,
                listNotes[position].content,
                listNotes[position].date))
            startActivity(intent)
        }
    }

    private fun openDialog() {
        val dialog = Dialog()
        dialog.show(supportFragmentManager, "Data Dialog")
    }

    override fun applyTexts(title: String?) {
        // TODO Realizar Insert
    }

}