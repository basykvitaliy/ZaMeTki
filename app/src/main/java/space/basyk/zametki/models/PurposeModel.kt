package space.basyk.zametki.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purpose_table")
class PurposeModel (
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,

        @ColumnInfo
        val titlePurpose: String = ""
        )