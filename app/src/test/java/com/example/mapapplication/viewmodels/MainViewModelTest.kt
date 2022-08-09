package com.example.mapapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.mapapplication.pojo.Results
import com.example.mapapplication.repository.Repository
import com.example.mapapplication.service.RetrofitService
import com.google.common.truth.Truth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.Mockito.mock
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MainViewModelTest {

    val dispatcher = TestCoroutineDispatcher()
    private lateinit var mMainViewModel: MainViewModel
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        val service = mock(RetrofitService::class.java)
        repository = Repository(service)
        mMainViewModel = MainViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test_getPoiData(): Unit = runBlocking {
        val list = MutableLiveData<ArrayList<Results>>()
        val arrList :ArrayList<Results> = ArrayList()
        Mockito.`when`(repository.getPOI(5, "km", 52.526, 13.415, "apiKey")).thenReturn(Response.success(arrList))
        mMainViewModel.getPOIData().value?.let { Truth.assertThat(it.size).isEqualTo(0) }
    }
}