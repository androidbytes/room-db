package `in`.androidbytes.roomdb.notes

import `in`.androidbytes.roomdb.R
import `in`.androidbytes.roomdb.data.Note
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.note.view.*

class NotesAdapter(val data: List<Note>) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.note, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = data[position]
        val view = holder.itemView
        view.note.text = note.text
        view.date.text = note.date
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}