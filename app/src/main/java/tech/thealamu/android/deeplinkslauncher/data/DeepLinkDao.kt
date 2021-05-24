package tech.thealamu.android.deeplinkslauncher.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DeepLinkDao {
    @Query("SELECT * FROM deeplinks")
    fun getDeeplinks(): LiveData<List<DeepLink>>

    @Insert
    suspend fun insertDeeplink(d: DeepLink)

    @Update
    fun updateDeeplink(d: DeepLink)

    @Delete
    fun deleteDeeplink(d: DeepLink)

    @Query("SELECT * FROM deeplinks WHERE id=:id")
    fun getDeeplinkWithID(id: Int): LiveData<DeepLink>
}