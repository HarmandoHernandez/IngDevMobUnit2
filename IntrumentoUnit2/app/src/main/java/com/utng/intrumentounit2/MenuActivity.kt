package com.utng.intrumentounit2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() , Dialog.DialogListener {

    private val defname = "Desconocido"
    private val defage = "18"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val name = prefs.getString("name", defname)
        val age = prefs.getString("age", defage)
        menu(name ?: defname, age ?: defage)
        if ( name == defname) {
            openDialog()
        }
        fab.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {
        val dialog = Dialog()
        dialog.show(supportFragmentManager, "Data Dialog")
    }

    override fun applyTexts(userName: String?, userAge: String?) {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("name", userName)
        prefs.putString("age", userAge)
        prefs.apply()

        menu(userName ?: defname, userAge ?: defage)
    }

    private fun menu(name: String, age: String) {
        val topic1 = Topic("CSharp (C#)", R.drawable.csharp, getCSharp(name, age))
        val topic2 = Topic("Java", R.drawable.java, getJava(name, age))
        val topic3 = Topic("Python", R.drawable.python, getPython(name, age))

        val listTopics = listOf(
            topic1, topic2, topic3
        )

        val adapter = TopicsAdapter(this, listTopics)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, TopicActivity::class.java)
            intent.putExtra("topic", listTopics[position])
            startActivity(intent)
        }
    }

    private fun getCSharp(name: String, age: String): String {
        return "TIPOS DE DATOS\n" +
                    "boolean = true/false\n" +
                    "int = $age\n" +
                    "float = $age.$age\n" +
                    "double = $age.$age$age\n" +
                    "char = \"D\"\n" +
                    "String = \"¡hola $name!\"\n\n" +
                    "OPERADORES NUMÉRICOS\n" +
                    "+ suma\n" +
                    "- resta\n" +
                    "* multiplicación\n" +
                    "/ dividión\n" +
                    "% modulo\n" +
                    "++ incremento en 1\n" +
                    "-- decremento en 1\n" +
                    "OPERADORES COMPARACIÓN\n" +
                    "== igual\n" +
                    "!= distinto\n" +
                    "> mayor\n" +
                    "< menor\n" +
                    ">= mayor o igual\n" +
                    "<= menor o igual\n\n" +
                    "OPERADORES BOOLEANOS\n" +
                    "&& \"y\" lógico\n" +
                    "|| \"o\" lógico\n" +
                    "! negación lígica\n\n" +
                    "VARIABLES\n" +
                    "Declaración: int radio;\n" +
                    "Asignación: radio=$age;\n" +
                    "Uso: radio*$age;\n\n" +
                    "STRINGS\n" +
                    "Concatenar: \"Hola \" + \"$name\"\n" +
                    "Obtener longitud: \"día\".length()\n" +
                    "Carácter en posición 0: \"Música\"[0]\n" +
                    "Comparar: strA.equals(strB)"
    }

    private fun getJava(name: String, age: String): String{
        return "TIPOS DE DATOS\n" +
                "bool = true/false\n" +
                "int = $age\n" +
                "float = $age.$age\n" +
                "str = \"¡hola $name!\"\n" +
                "char = \"D\"\n" +
                "int[] = arreglo[10]\n\n" +
                "OPERADORES NUMÉRICOS\n" +
                "+ suma\n" +
                "- resta\n" +
                "* multiplicación\n" +
                "/ dividión (entera si ambos son int)\n" +
                "** potencia\n" +
                "% modulo\n\n" +
                "OPERADORES COMPARACIÓN\n" +
                "== igual\n" +
                "!= distinto\n" +
                "> mayor\n" +
                "< menor\n" +
                ">= mayor o igual\n" +
                "<= menor o igual\n\n" +
                "OPERADORES BOOLEANOS\n" +
                "&& \"y\" lógico\n" +
                "|| \"o\" lógico\n" +
                "! negación lígica\n\n" +
                "VARIABLES\n" +
                "Declaración: int radio;\n" +
                "Asignación: radio=$age;\n" +
                "Uso: radio**$age;\n\n" +
                "STRINGS\n" +
                "Concatenar: \"Hola \" + \"$name\"\n" +
                "Obtener longitud: \"día\".length()\n" +
                "Carácter en posición 0: \"Música\"[0]"
    }

    private fun getPython(name: String, age: String): String {
        return "TIPOS DE DATOS\n" +
                "bool = True/False\n" +
                "int = $age\n" +
                "float = $age.$age\n" +
                "str = \"¡hola $name!\"\n\n" +
                "OPERADORES NUMÉRICOS\n" +
                "+ suma\n" +
                "- resta\n" +
                "* multiplicación\n" +
                "/ dividión\n" +
                "** potencia\n" +
                "% modulo\n" +
                "//división entera\n\n" +
                "OPERADORES COMPARACIÓN\n" +
                "== igual\n" +
                "!= distinto\n" +
                "> mayor\n" +
                "< menor\n" +
                ">= mayor o igual\n" +
                "<= menor o igual\n\n" +
                "OPERADORES BOOLEANOS\n" +
                "and \"y\" lógico\n" +
                "or \"o\" lógico\n" +
                "not negación lígica\n\n" +
                "VARIABLES\n" +
                "Creación: radio=$age\n" +
                "Uso: radio**$age\n\n" +
                "STRINGS\n" +
                "Concatenar: \"Hola \" + \"$name\"\n" +
                "Obtener longitud: len(\"$name\")\n" +
                "Carácter en posición 0: \"Música\"[0]\n" +
                "Rebanada: \"margarita\"[2:6]"
    }



}