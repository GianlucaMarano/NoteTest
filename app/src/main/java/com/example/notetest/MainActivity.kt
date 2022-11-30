package com.example.notetest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notetest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv : RecyclerView = findViewById(R.id.rv_main)
        val addBtnMain : Button = findViewById(R.id.add_btn_main)
        val titleEtMain : EditText = findViewById(R.id.title_et_main)
        val descriptionEtMain: EditText = findViewById(R.id.description_et_main)

        val adapter = NoteAdapter()
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        addBtnMain.setOnClickListener {
            adapter.addNewNote(
                Note(
                    title = titleEtMain.text.toString(),
                    description = descriptionEtMain.text.toString(),
                    isFavourite = false
                )
            )
        }



    }
}