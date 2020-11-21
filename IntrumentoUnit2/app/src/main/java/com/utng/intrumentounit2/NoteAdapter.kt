package com.utng.intrumentounit2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_note.view.*
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.item_note.view.textTopic

/** Valida **/
class NoteAdapter (
    private val mContext: Context,
    private val listNotes: List<Note>
) : ArrayAdapter<Note>(mContext, 0, listNotes) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_note, parent, false)

        val note = listNotes[position]

        layout.textTopic.text = note.title
        layout.textContent.text = note.content
        //layout.imageTopic.setImageResource(topic.image)

        return layout
    }
}
