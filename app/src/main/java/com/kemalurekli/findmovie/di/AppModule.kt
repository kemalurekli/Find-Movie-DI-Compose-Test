package com.kemalurekli.findmovie.di

import android.content.Context
import androidx.room.Room
import com.kemalurekli.findmovie.data.local.roomdb.WatchListDatabase
import com.kemalurekli.findmovie.data.remote.dto.MovieAPI
import com.kemalurekli.findmovie.data.repository.MovieRepository
import com.kemalurekli.findmovie.domain.repository.MovieRepositoryInterface
import com.kemalurekli.findmovie.domain.usecase.GetMovieUseCase
import com.kemalurekli.findmovie.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRoomDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,WatchListDatabase::class.java,"WatchListDB").build()

    @Singleton
    @Provides
    fun injectDao(
        database: WatchListDatabase
    ) = database.watchListDao()


    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieAPI) = MovieRepository(api) as MovieRepositoryInterface

}