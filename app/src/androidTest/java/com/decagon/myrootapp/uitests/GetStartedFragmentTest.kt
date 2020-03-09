package com.decagon.myrootapp.uitests

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.decagon.myrootapp.R
import com.decagon.myrootapp.ui.getstarted.GetStartedFragment
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class GetStartedFragmentTest {

//    @get:Rule
//    val fragmentrule  =
    private lateinit var navController: TestNavHostController
    private lateinit var factory:FragmentFactory

    @Before
    fun setup(){
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.setGraph(R.navigation.welcome_nav)
        factory = FragmentFactory()
    }

    @Test
    fun test_signUpButton_displays(){
        launchFragmentInContainer<GetStartedFragment>()
        onView(withId(R.id.get_started_signup_btn)).check(matches(withText("Signup")))
    }

    @Test
    fun test_navigation_login(){
        val getStartedFragmentScenario = launchFragmentInContainer<GetStartedFragment>()

        getStartedFragmentScenario.onFragment {
            Navigation.setViewNavController(it.requireView(), navController)
        }

        onView(withId(R.id.get_started_login_btn)).perform(ViewActions.click())
        assertThat(navController.currentDestination?.id, `is`(R.id.loginFragment))
    }

    @Test
    fun test_navigation_signup(){
        val getStartedFragmentScenario = launchFragmentInContainer<GetStartedFragment>()

        getStartedFragmentScenario.onFragment {
            Navigation.setViewNavController(it.requireView(), navController)
        }

        onView(withId(R.id.get_started_signup_btn)).perform(ViewActions.click())
        assertThat(navController.currentDestination?.id, `is`(R.id.signUpFragment))
    }
}