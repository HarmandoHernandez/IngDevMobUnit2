package com.utng.intrumentounit2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_topic.view.*

class TopicsAdapter (
    private val mContext: Context,
    private val listTopics: List<Topic>
) : ArrayAdapter<Topic>(mContext, 0, listTopics) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_topic, parent, false)

        val topic = listTopics[position]

        layout.textTopic.text = topic.title
        layout.imageTopic.setImageResource(topic.image)

        return layout
    }
}
