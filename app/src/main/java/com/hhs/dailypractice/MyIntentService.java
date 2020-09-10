package com.hhs.dailypractice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("Song", "Thread id is" + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        Log.d("Song", "IntentService destroy");
        super.onDestroy();
    }
}
