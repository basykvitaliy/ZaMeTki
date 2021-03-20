package space.basyk.zametki.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plan_of_day_table")
class PlanOfDayModel (
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,

        @ColumnInfo
        val titleOne: String = "",

        @ColumnInfo
        val titleTwo: String = ""
)