package com.justintuchek.testingplayground;


import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * https://google.github.io/android-testing-support-library/docs/espresso/intents/
 */
@RunWith(AndroidJUnit4.class)
public class NextIntentTest {

    @Rule
    public final IntentsTestRule<ViewTestActivity> rule =
            new IntentsTestRule<>(ViewTestActivity.class, false, true);

    @Test
    public void test() {
        rule.verify(new IntentsTestRule.TransactionVerification() {
            @Override
            public void execute() {
                rule.getActivity().startActivity(NextIntent.toOpen(rule.getActivity()));
                Intents.intended(IntentMatchers.toPackage(BuildConfig.APPLICATION_ID));
                Intents.intended(IntentMatchers.hasComponent(NextActivity.class.getName()));
            }
        });
    }

}
