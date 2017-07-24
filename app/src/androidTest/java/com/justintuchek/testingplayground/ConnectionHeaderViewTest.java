package com.justintuchek.testingplayground;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ConnectionHeaderViewTest {

    @Rule
    public final ActivityTestRule<ViewTestActivity> rule =
            new ActivityTestRule<>(ViewTestActivity.class, false, true);

    @Test
    public void whatever() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Assert.assertNotNull("Context must not be null", appContext);
        Assert.assertNotNull("Activity must not be null", rule.getActivity());

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                rule.getActivity().setContentView(R.layout.test_view_connection_header);
            }
        });

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
