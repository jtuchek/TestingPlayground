package com.justintuchek.testingplayground;


import android.support.test.espresso.intent.Intents;

public class IntentsTest {

    public interface IntentVerification {
        void execute();
    }

    public static void verify(IntentVerification verification) {
        Intents.init();
        verification.execute();
        Intents.release();
    }

    private IntentsTest() {
        throw new IllegalStateException("no instance required");
    }

}
