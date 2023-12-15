package com.kemalurekli.findmovie.data.local.roomdb

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
    suspend fun deleteWatchList(watchList: WatchList)

    @Query("SELECT * FROM watchList")
    suspend fun getWatchList(): List<WatchList>

}