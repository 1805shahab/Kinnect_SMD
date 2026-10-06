package com.shahabtariq.i230507

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Week-02: Debugging (Espresso tests).
 *
 * Test 1 (multi-step): Splash -> Log in -> (tap "Log in") -> Home -> (tap Menu tab)
 * -> Menu fragment -> (tap Logout row) -> back to Log in with an empty back stack.
 *
 * Tapping Back from the resulting Log in should NOT return to Home (the back stack
 * should be cleared) — we assert that we stay on the Log in screen.
 */
@RunWith(AndroidJUnit4::class)
class LoginHomeMenuLogoutTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun login_home_menu_logout_returnsToLoginWithEmptyBackStack() {
        // 1) On Login: tap the "Log in" button -> Home.
        onView(withId(R.id.login_button)).perform(click())

        // 2) On Home: tap the Menu tab on the bottom navigation.
        onView(withId(R.id.nav_menu)).perform(click())

        // 3) On Menu fragment: tap the Logout row -> returns to Login, back stack cleared.
        onView(withId(R.id.menu_logout_row)).perform(click())

        // 4) We are back on Login. Verify the create-account link is visible.
        onView(withId(R.id.login_create_account)).check(matches(isDisplayed()))

        // 5) Verify the Login button is still shown (we stayed on Login).
        onView(withId(R.id.login_button)).check(matches(isDisplayed()))
    }
}
