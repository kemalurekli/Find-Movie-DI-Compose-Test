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

    @Query("SELECT * FROM watchList ORDER BY id DESC")
    suspend fun getWatchList(): List<WatchList>

    @Query("SELECT * FROM watchList WHERE imdb_ID = :imdb_ID")
    suspend fun getWatchListDetail(imdb_ID : String): WatchList
}