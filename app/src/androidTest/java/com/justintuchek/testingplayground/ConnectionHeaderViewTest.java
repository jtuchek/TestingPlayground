package com.justintuchek.testingplayground;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(AndroidJUnit4.class)
public class ConnectionHeaderViewTest {

    @Rule
    public final ViewTestRule rule = new ViewTestRule(false, true, R.layout.test_view_connection_header);

    @Test
    public void whatever() {
        Espresso.onView(ViewMatchers.withId(R.id.tv_connection_state_label))
                .check(ViewAssertions.matches(ViewMatchers.withText("disconnected")));

        Espresso.onView(ViewMatchers.withId(R.id.btn_connection_action))
                .check(ViewAssertions.matches(ViewMatchers.withText("connect")));

        Espresso.onView(ViewMatchers.withId(R.id.btn_connection_action))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.tv_connection_state_label))
                .check(ViewAssertions.matches(ViewMatchers.withText("connected")));

        Espresso.onView(ViewMatchers.withId(R.id.btn_connection_action))
                .check(ViewAssertions.matches(ViewMatchers.withText("disconnect")));
    }
}
