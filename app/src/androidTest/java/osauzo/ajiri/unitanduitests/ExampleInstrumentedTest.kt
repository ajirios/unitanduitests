package osauzo.ajiri.unitanduitests

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java);

    @Test
    fun typingTextAndClickingButton_updatesTextView() {
        val testInput = "Espresso Test Input"

        // Type text into the EditText
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(testInput), closeSoftKeyboard())

        // Click the first button (changeTextBt)
        onView(withId(R.id.changeTextBt))
            .perform(click())

        // Check if the TextView displays the correct text
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(testInput)))
    }

    @Test
    fun typingTextAndOpeningActivity_displaysCorrectTextInSecondActivity() {
        val inputText = "Hello from MainActivity"

        // Type text into the EditText
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(inputText), closeSoftKeyboard())

        // Click the second button to open ShowTextActivity
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())

        // Verify that ShowTextActivity is launched and TextView has the correct text
        onView(withId(R.id.show_text_view))
            .check(matches(withText(inputText)))
    }

    @Test
    fun launchWithoutInput_displaysEmptyTextView() {
        // Launch ShowTextActivity with no intent extras
        val scenario = ActivityScenario.launch(ShowTextActivity::class.java)

        // Check that the TextView is empty (because nullToEmpty should convert null to "")
        onView(withId(R.id.show_text_view))
            .check(matches(withText("")))
    }

    @Test
    fun enter123_thenChangeText_updatesMainTextView() {
        val input = "123"
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt))
            .perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(input)))
    }

    @Test
    fun enter123_thenOpenActivity_displaysTextInShowTextActivity() {
        val input = "123"
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())
        onView(withId(R.id.show_text_view))
            .check(matches(withText(input)))
    }

    @Test
    fun noInput_thenChangeText_updatesMainTextViewToEmpty() {
        onView(withId(R.id.editTextUserInput))
            .perform(clearText(), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt))
            .perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("")))
    }

    @Test
    fun noInput_thenOpenActivity_displaysEmptyTextInShowTextActivity() {
        onView(withId(R.id.editTextUserInput))
            .perform(clearText(), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())
        onView(withId(R.id.show_text_view))
            .check(matches(withText("")))
    }

    @Test
    fun enterABCDEF_thenChangeText_updatesMainTextView() {
        val input = "abcdef"
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt))
            .perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(input)))
    }

    @Test
    fun enterABCDEF_thenOpenActivity_displaysTextInShowTextActivity() {
        val input = "abcdef"
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())
        onView(withId(R.id.show_text_view))
            .check(matches(withText(input)))
    }
}