package com.justintuchek.testingplayground;


import android.app.Activity;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

public class IntentsTestRule<T extends Activity> extends ActivityTestRule<T> {

    public IntentsTestRule(Class<T> activityClass) {
        super(activityClass);
    }

    public IntentsTestRule(Class<T> activityClass, boolean initialTouchMode) {
        super(activityClass, initialTouchMode);
    }

    public IntentsTestRule(Class<T> activityClass, boolean initialTouchMode, boolean launchActivity) {
        super(activityClass, initialTouchMode, launchActivity);
    }

    public void beginTransaction() {
        Intents.init();
    }

    public void endTransaction() {
        Intents.release();
    }

    public void verify(TransactionVerification verification) {
        beginTransaction();
        verification.execute();
        endTransaction();
    }

    public interface TransactionVerification {
        void execute();
    }

}
