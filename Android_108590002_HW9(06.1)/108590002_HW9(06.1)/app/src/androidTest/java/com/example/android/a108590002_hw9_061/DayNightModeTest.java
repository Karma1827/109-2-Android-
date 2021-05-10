package com.example.android.a108590002_hw9_061;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DayNightModeTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void dayNightModeTest() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Night Mode"),
                        childAtPosition( childAtPosition( withId(R.id.content), 0), 0), isDisplayed()));appCompatTextView.perform(click());openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction textView = onView(
                allOf(withId(R.id.title), withText("Day Mode"),
                        childAtPosition( childAtPosition( withId(R.id.content), 0), 0), isDisplayed()));textView.check(matches(withText("Day Mode")));

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.title), withText("Day Mode"),
                        childAtPosition( childAtPosition( withId(R.id.content), 0), 0), isDisplayed()));appCompatTextView2.perform(click());openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.title), withText("Night Mode"), childAtPosition( childAtPosition( withId(R.id.content), 0), 0), isDisplayed()));textView2.check(matches(withText("Night Mode")));
    }

    private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
}

