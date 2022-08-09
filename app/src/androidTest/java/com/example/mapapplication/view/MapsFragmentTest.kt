package com.example.mapapplication.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.mapapplication.R
import com.example.mapapplication.hiltUtil.launchFragmentInHiltContainer
import com.example.mapapplication.service.RetrofitModule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Test

@HiltAndroidTest
@UninstallModules(RetrofitModule::class)
class MapsFragmentTest {

    @Before
    fun init() {
        launchFragmentInHiltContainer<MapsFragment>()
    }

    @Test
    fun test_phoneBaseFragmentDisplayStatus() {
        onView(ViewMatchers.withId(R.id.map))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}