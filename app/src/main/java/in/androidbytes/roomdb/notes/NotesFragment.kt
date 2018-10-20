package `in`.androidbytes.roomdb.notes

import `in`.androidbytes.roomdb.App
import `in`.androidbytes.roomdb.R
import `in`.androidbytes.roomdb.addNote.AddNoteFragment
import `in`.androidbytes.roomdb.data.Note
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_notes, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(notes) {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = NotesAdapter(App.database.noteDao().getAll())
        }

        actionAdd.setOnClickListener {
            val fm = fragmentManager
            if (fm != null) {
                val ft = fm.beginTransaction()
                with(ft) {
                    replace(R.id.root, AddNoteFragment())
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }
}