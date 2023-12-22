package com.kemalurekli.findmovie.data.local.roomdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@SmallTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
class WatchListDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("testDatabase")
    lateinit var database: WatchListDatabase

    private lateinit var dao : WatchListDao
    // private lateinit var database: WatchListDatabase

    @Before
    fun setup() {

        //due to using DI it's disable
        /*
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),WatchListDatabase::class.java
        ).allowMainThreadQueries().build()
         */
        hiltRule.inject()
        dao = database.watchListDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertWatchList() = runBlocking {
        val watchlist = WatchList("a1b1c1", "Superman", "7.5","1999","www.google.com",1)
        dao.insertWatchList(watchlist)
        val list = dao.getWatchList()
        assertThat(list).contains(watchlist)
    }

    @Test
    fun deleteWatchList() = runBlocking {
        val exampleData = WatchList("a1b1c1", "Superman", "7.5","1999","www.google.com",1)
        dao.insertWatchList(exampleData)
        dao.deleteWatchList(exampleData)

        val list = dao.getWatchList()
        assertThat(list).doesNotContain(exampleData)
    }

}