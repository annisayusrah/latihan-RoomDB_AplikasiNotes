package id.ac.unhas.notesapp.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.notesapp.R
import id.ac.unhas.notesapp.database.note.Note

class NoteAdapter(private val context: Context?, private val listener: (Note, Int) -> Unit) :
    RecyclerView.Adapter<NoteViewHolder>() {

    private var notes = listOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_note,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        if (context != null) {
            holder.bindItem(context, notes[position], listener)
        }
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(context: Context, note: Note, listener: (Note, Int) -> Unit) {
        itemView.noteTV.text = note.note

        itemView.setOnClickListener {
            listener(note, layoutPosition)
        }
    }

}