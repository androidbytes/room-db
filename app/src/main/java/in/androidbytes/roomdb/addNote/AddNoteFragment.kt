package `in`.androidbytes.roomdb.addNote

import `in`.androidbytes.roomdb.App
import `in`.androidbytes.roomdb.R
import `in`.androidbytes.roomdb.data.Note
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_note.*
import java.text.SimpleDateFormat
import java.util.*

class AddNoteFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_add_note, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        saveNote.setOnClickListener {
            val text = newNote.text.toString()
            if (text.isEmpty()) {
                newNote.error = "Please write something"
                return@setOnClickListener
            }

            val date = Calendar.getInstance().time
            val df = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val note = Note(0, text, df.format(date))
            App.database.noteDao().insert(note)
        }
    }
}