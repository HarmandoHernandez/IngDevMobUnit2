package com.utng.intrumentounit2

import java.io.Serializable

class NoteModel(
    val title: String,
    val content: String,
    val date: String
) : Serializable