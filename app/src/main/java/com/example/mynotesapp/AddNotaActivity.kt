package com.example.mynotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AddNotaActivity : AppCompatActivity() {

    var etTitulo: EditText?=null
    var etContenido: EditText?=null
    var btnGuardar: Button?=null

    val app = applicationContext as NotaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nota)

        etTitulo = findViewById(R.id.etTitulo)
        etContenido = findViewById(R.id.etContenido)
        btnGuardar = findViewById(R.id.btnGuardar)


        btnGuardar!!.setOnClickListener {
            val title = etTitulo!!.text.toString()
            val content = etContenido!!.text.toString()

            val nota = Nota(titulo = title, contenido = content,id = 0)
            val notas = listOf<Nota>(nota)

            lifecycleScope.launch {
                app.room.notaDao().insert(notas)
            }

            etTitulo!!.setText("")
            etContenido!!.setText("")
        }
    }
}