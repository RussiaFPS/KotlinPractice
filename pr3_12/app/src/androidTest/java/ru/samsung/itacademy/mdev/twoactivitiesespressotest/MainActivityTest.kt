package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    private val inputText = "testMain"

    @Test
    @Throws(Exception::class)
    fun mainActivity() {
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))
        onView(withId(R.id.text_message_reply)).check(matches(isDisplayed()))
        onView(withId(R.id.button_main)).check(matches(isDisplayed()))
        onView(withId(R.id.editText_main)).check(matches(isDisplayed()))


        onView(withId(R.id.editText_main)).perform(ViewActions.typeText(inputText))
        onView(withId(R.id.button_main)).perform(click())
        onView(withId(R.id.button_second)).check(matches(isDisplayed()))
        onView(withId(R.id.text_message))
            .check(matches(withText(inputText)))
    }
}