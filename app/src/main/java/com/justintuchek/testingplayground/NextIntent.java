package com.justintuchek.testingplayground;


import android.content.Context;
import android.content.Intent;

public class NextIntent {

    public static Intent toOpen(Context context) {
        return new Intent(context, NextActivity.class);
    }

}
