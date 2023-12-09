package com.kemalurekli.findmovie.data.local.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WatchListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWatchList(watchList: WatchList)

    @Delete
    suspend fun deleteArt(watchList: WatchList)

    @Query("SELECT * FROM watchList")
    fun observeArts(): LiveData<List<WatchList>>

}