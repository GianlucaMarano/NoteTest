package com.example.notetest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.notetest.databinding.NoteItemBinding

class NoteAdapter(private val dataSet: ArrayList<Note> = arrayListOf()) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    fun addNewNote (newNote: Note){
        dataSet.add(newNote)
        notifyItemInserted(dataSet.size - 1)
    }

    fun deleteNote (position: Int){
        dataSet.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, dataSet.size)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = NoteItemBinding.bind(view)//bind singola nota tramite viewholder

        init {
            binding.root.setOnClickListener {
                Toast.makeText(view.context, "Click", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.note_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.titleItem.text = dataSet[position].title
        viewHolder.binding.descriptionItem.text = dataSet[position].description
        setFavourite(dataSet[position].isFavourite, viewHolder.binding.favItem)
        viewHolder.binding.favItem.setOnClickListener {
            dataSet[position].isFavourite = !dataSet[position].isFavourite
            setFavourite(dataSet[position].isFavourite, viewHolder.binding.favItem)
        }
        viewHolder.binding.root.setOnLongClickListener {
            deleteNote(position)
            true
        }
    }

    private fun setFavourite (isFavourite : Boolean, img : ImageView){
        img.setImageResource(
            if (isFavourite) android.R.drawable.star_big_on
            else android.R.drawable.star_big_off
        )
    }

    override fun getItemCount() = dataSet.size

}