package com.example.notetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notetest.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val adapter = NoteAdapter()
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.addBtnMain.setOnClickListener {
            adapter.addNewNote(
                Note(
                    title = binding.titleEtMain.text.toString(),
                    description = binding.descriptionEtMain.text.toString(),
                    isFavourite = false
                )
            )
        }



    }
}