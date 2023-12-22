package com.kemalurekli.findmovie.di

import android.content.Context
import androidx.room.Room
import com.kemalurekli.findmovie.data.local.roomdb.WatchListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("testDatabase")
    fun injectInMemoryRoom(@ApplicationContext context : Context) =
        Room.inMemoryDatabaseBuilder(context,WatchListDatabase::class.java)
            .allowMainThreadQueries()
            .build()

}