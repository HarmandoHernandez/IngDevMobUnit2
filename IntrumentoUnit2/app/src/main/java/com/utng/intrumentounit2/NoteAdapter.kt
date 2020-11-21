package com.utng.intrumentounit2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_note.view.*

/** Valida **/
class NoteAdapter (
    private val mContext: Context,
    private val listNotes: List<NoteModel>
) : ArrayAdapter<NoteModel>(mContext, 0, listNotes) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_note, parent, false)

        val note = listNotes[position]

        layout.image.text = note.title.substring(0, 1)
        layout.title.text = note.title
        if (note.content.length < 50) {
            layout.contentReview.text = note.content + "..."
        } else {
            layout.contentReview.text = note.content.substring(0, 49) + "..."
        }
        return layout
    }
}
