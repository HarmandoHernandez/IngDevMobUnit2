package com.utng.intrumentounit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_topic.*

class TopicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val topic = intent.getSerializableExtra("topic") as Topic

        imageTopic.setImageResource(topic.image)
        textTopic.text = topic.title
        textContent.text = topic.content
    }
}