package com.kemalurekli.findmovie.data.local.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watchList")
data class WatchList(
    var movieName : String,
    var imdbRating : String,
    var year : String,
    var imageUrl : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null
)