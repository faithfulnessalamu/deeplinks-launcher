package tech.thealamu.android.deeplinkslauncher.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deeplinks")
data class DeepLink(
    val title: String,
    val description: String,
    val uri: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
