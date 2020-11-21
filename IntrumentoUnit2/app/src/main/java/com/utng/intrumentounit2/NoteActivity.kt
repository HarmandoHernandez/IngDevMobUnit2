package com.utng.intrumentounit2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_note.*


/** Valida **/
class NoteActivity : AppCompatActivity() {
    private var noteLab: NoteLab ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        noteLab = NoteLab.get(this)
        setup()
    }

    private fun setup(){
        var topic = intent.getSerializableExtra("note") as NoteModel
        image.text = topic.title.substring(0, 1)
        titleNote.text = topic.title
        date.text = topic.date
        contentView.text = topic.content
        contentEdit.setText(topic.content)

        btnDelete.setOnClickListener {
            /** Eliminar */
        }
        btnSave.setOnClickListener {
            /** Guardar */
            val newContent = contentEdit.text
            contentView.text = newContent
            topic.content = newContent.toString()

            contentEdit.isVisible = false
            contentView.isVisible = true
            btnSave.isVisible = false
            btnDelete.isVisible = true
            btnEdit.isVisible = true
        }
        btnEdit.setOnClickListener {
            /** Eliminar */
            contentView.isVisible = false
            contentEdit.isVisible = true
            btnSave.isVisible = true
            btnDelete.isVisible = false
            btnEdit.isVisible = false
        }
    }

    private fun save(topic: NoteModel, newContent: String) {
        noteLab?.updateNote(Note(topic.title, newContent, topic.date)) /** no lleva Id ERROR*/
        Toast.makeText(this, "Actualizada", Toast.LENGTH_SHORT).show()
    }

    private fun delete(topic: NoteModel){
        noteLab?.deleteNote(Note(topic.title, topic.content, topic.date))
        Toast.makeText(this, "Actualizada", Toast.LENGTH_SHORT).show()

    }
}