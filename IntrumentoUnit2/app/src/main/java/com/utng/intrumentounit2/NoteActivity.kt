package com.utng.intrumentounit2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_note.*


/** Valida **/
class NoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val topic = intent.getSerializableExtra("note") as NoteModel

        //imageTopic.setImageResource(topic.image)
        textTopic.text = topic.title
        textContent.text = topic.content

    }

    /**
     * Guarda la nota si no existe (mNota es null), o la actualiza si existe.
    private fun guardar() {
        val textoNota: String = mTextoNota.getText().toString()
        if (textoNota != "") {
            if (mNota == null) {
                mNota = Nota()
                mNota.setMensaje(textoNota)
                mNotaLab.addNota(mNota)
                Toast.makeText(
                    this, getString(R.string.nota_creada),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                mNota.setMensaje(textoNota)
                mNotaLab.updateNota(mNota)
                Toast.makeText(
                    this, getString(R.string.nota_actualizada),
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                this, getString(R.string.crea_nota_primero),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
     */

}