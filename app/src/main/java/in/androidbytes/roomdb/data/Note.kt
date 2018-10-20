package `in`.androidbytes.roomdb.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val text: String,
        val date: String
)