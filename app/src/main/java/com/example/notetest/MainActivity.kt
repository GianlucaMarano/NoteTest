package com.example.notetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notetest.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding //Creata automaticamente dal sistema

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root //elemento che contiene il layout
        setContentView(view)
        val adapter = NoteAdapter()
        binding.rvMain.adapter = adapter
        //eliminazione con swipe
        ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(//verifico che lo swipe sia a sinistra
                0,//direzione drag
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)//direzione swipe
            {
            override fun onMove(v: RecyclerView, h: RecyclerView.ViewHolder, t: RecyclerView.ViewHolder) = false
            //Ogni volta che viene rilevato uno swipe
            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
                if(dir == ItemTouchHelper.LEFT)
                    adapter.deleteNote(h.adapterPosition)
            }
        }).attachToRecyclerView(binding.rvMain) //collego questo oggetto alla recyclerview
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