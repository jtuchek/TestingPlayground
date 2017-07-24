package com.justintuchek.testingplayground;


import android.app.Instrumentation;
import android.support.annotation.LayoutRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

public class ViewTestRule<T extends View> extends ActivityTestRule<ViewTestActivity> {

    @LayoutRes
    private final int layoutResId;
    private final Instrumentation instrumentation;

    public ViewTestRule(boolean initialTouchMode, boolean launchActivity, @LayoutRes int layoutResId) {
        super(ViewTestActivity.class, initialTouchMode, launchActivity);
        this.layoutResId = layoutResId;
        instrumentation = InstrumentationRegistry.getInstrumentation();
    }

    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();
        setContentView();
    }

    private void setContentView() {
        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                getActivity().setContentView(layoutResId);
            }
        });
    }

}
