package cc.somkiat.basicunittesting;

import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


import static org.hamcrest.core.IsNot.not;

/**
 * Created by Chiib_000 on 15/11/2560.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    final int DELAY_TIME = 2800;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void saveWithInvalidName() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("ภาษาไทยis a number 1-9*0)("));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("Chiibi@hotmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Name is invalid")).inRoot(withDecorView(not(mActivityTestRule
                .getActivity()
                .getWindow()
                .getDecorView()))).check(matches(isDisplayed()));
        SystemClock.sleep(DELAY_TIME);
    }

    @Test
    public void saveWithInvalidEmail() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Chiibi"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("Chiibi-*/*-...hotm41313ailcom"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Email is invalid")).inRoot(withDecorView(not(mActivityTestRule
                .getActivity()
                .getWindow()
                .getDecorView()))).check(matches(isDisplayed()));
        SystemClock.sleep(DELAY_TIME);
    }

    @Test
    public void saveWithInvalidNameAndEmail() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Chi6515-*-*ibi"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("Chiibi-*/*-...hotm41313ailcom"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Name is invalid")).inRoot(withDecorView(not(mActivityTestRule
                .getActivity()
                .getWindow()
                .getDecorView()))).check(matches(isDisplayed()));
        SystemClock.sleep(DELAY_TIME);
    }

    @Test
    public void saveWithEmptyName() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("Chiibi@hotmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Name is invalid")).inRoot(withDecorView(not(mActivityTestRule
                .getActivity()
                .getWindow()
                .getDecorView()))).check(matches(isDisplayed()));
        SystemClock.sleep(DELAY_TIME);
    }

    @Test
    public void saveWithEmptyEmail() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Chiibi"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Email is invalid")).inRoot(withDecorView(not(mActivityTestRule
                .getActivity()
                .getWindow()
                .getDecorView()))).check(matches(isDisplayed()));
        SystemClock.sleep(DELAY_TIME);
    }

    @Test
    public void saveWithEmptyNameAndEmail() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Name is invalid")).inRoot(withDecorView(not(mActivityTestRule
                .getActivity()
                .getWindow()
                .getDecorView()))).check(matches(isDisplayed()));
        SystemClock.sleep(DELAY_TIME);
    }

    @Test
    public void saveValidData() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Chiibi"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("Chiibi@hotmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void revertTest() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Chiibi"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("Chiibi@hotmail.com"));
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }
}
