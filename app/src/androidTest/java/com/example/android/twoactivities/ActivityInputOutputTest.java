/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.twoactivities;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 * To create an instructmented JUnit4 test class, add the @RunWith(AndroidJUnit4.class)
 * annotation at the beginning of your test class definition.
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    // @Rule annotation lets you add or redefine the behavior of each test method in a reusable way, using
    // one of the test rule classes that Android Testing Support Library provides, such as ActivityTestRule
    // or ServiceTestRule. We use ActivityTestRule object, which provides functional testing of a single
    // Activity. During the duration of the test you will be able to manipulate your Activity directly,
    // using ViewMatcher, ViewActions, and ViewAssertions.
    @Rule
    public ActivityTestRule mActitivyRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void activityLaunch() {
        // Use a ViewMatcher to find a View: onView(withId(R.id.my_view))
        // Use a ViewAction to perform an action: .perform(click())
        // Use a ViewAssertion to check if the result of the action matches an assertion: .check(matches(isDisplayed()))
        onView(withId(R.id.button_main)).perform(click());
        onView(withId(R.id.text_header)).check(matches(isDisplayed()));

        onView(withId(R.id.button_second)).perform(click());
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()));
    }

    @Test
    public void textInputOutput() {
        onView(withId(R.id.editText_main)).perform(typeText("This is a typing test"));
        onView(withId(R.id.button_main)).perform(click());
        onView(withId(R.id.text_message)).check(matches(withText("This is a typing test")));
    }
}
