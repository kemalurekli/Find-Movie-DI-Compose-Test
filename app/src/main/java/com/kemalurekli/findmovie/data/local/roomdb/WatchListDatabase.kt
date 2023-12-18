package com.kemalurekli.findmovie.data.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WatchList::class],version = 2)
abstract class WatchListDatabase : RoomDatabase() {
    abstract fun watchListDao() : WatchListDao
}