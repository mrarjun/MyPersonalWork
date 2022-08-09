package com.example.mapapplication.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.mapapplication.R
import com.example.mapapplication.service.RetrofitModule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(RetrofitModule::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_MainActivityShowStatus() {
        onView(withId(R.id.main_activity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_MainActivityFragmentLoadStatus() {
        onView(withId(R.id.map_fragment_container))
            .check(matches(isDisplayed()))
    }
}