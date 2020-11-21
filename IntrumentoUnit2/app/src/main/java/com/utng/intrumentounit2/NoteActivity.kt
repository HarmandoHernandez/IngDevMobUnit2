package com.utng.intrumentounit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_note.*

/** Valida **/
class NoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        // supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val topic = intent.getSerializableExtra("note") as NoteModel

        //imageTopic.setImageResource(topic.image)
        textTopic.text = topic.title
        textContent.text = topic.content

    }
}