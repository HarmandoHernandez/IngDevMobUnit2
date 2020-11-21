package com.utng.intrumentounit2

import java.io.Serializable

class NoteModel(
    val id: String,
    val title: String,
    var content: String,
    val date: String
) : Serializable