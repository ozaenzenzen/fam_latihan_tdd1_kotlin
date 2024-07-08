package com.dicoding.newsapp.ui.list

import androidx.lifecycle.MutableLiveData
import com.dicoding.newsapp.data.NewsRepository
import org.junit.Assert.*
import org.junit.Assert
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import com.dicoding.newsapp.data.Result
import com.dicoding.newsapp.data.local.entity.NewsEntity
import com.dicoding.newsapp.utils.DataDummy
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock

@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest {
    @Mock
    private lateinit var newsRepository: NewsRepository
    private lateinit var newsViewModel: NewsViewModel
    private val dummyNews = DataDummy.generateDummyNewsEntity()

    @Before
    fun setUp() {
        newsViewModel = NewsViewModel(newsRepository)
    }

    @Test
    fun `when Get HeadlineNews Should Not Null and Return Success`() {
        val expectedNews = MutableLiveData<Result<List<NewsEntity>>>() //Result diambil dari package data yang sudah disiapkan pada starter project
        expectedNews.value = Result.Success(dummyNews)
        `when`(newsRepository.getHeadlineNews()).thenReturn(expectedNews)
        val actualNews = newsViewModel.getHeadlineNews()
        Assert.assertNotNull(actualNews)
    }
}