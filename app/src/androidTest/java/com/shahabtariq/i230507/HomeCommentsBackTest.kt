package com.shahabtariq.i230507

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Week-02: Debugging (Espresso tests).
 *
 * Test 2 (multi-step): Log in -> Home feed -> tap first post's comment row -> Comments
 * Activity -> press Back -> returns to Home feed (the Home tab should still be checked).
 *
 * Per assignment: "Home -> Comments -> back to Home" is one of the suggested multi-step
 * Espresso workflows.
 */
@RunWith(AndroidJUnit4::class)
class HomeCommentsBackTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun home_comments_back_returnsToHome() {
        // 1) Login -> Home.
        onView(withId(R.id.login_button)).perform(click())

        // 2) On Home: tap the first post's comment action button -> Comments.
        onView(withId(R.id.btn_comment)).perform(click())

        // 3) Verify the Comments screen is shown by checking its back button.
        onView(withId(R.id.comments_back)).check(matches(isDisplayed()))

        // 4) Press Back -> returns to Home.
        pressBack()

        // 5) Verify we are back on Home (bottom nav is displayed).
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
    }
}
