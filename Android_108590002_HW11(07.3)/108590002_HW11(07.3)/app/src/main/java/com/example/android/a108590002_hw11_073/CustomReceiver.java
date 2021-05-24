package com.example.android.a108590002_hw11_073;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String RANDOM_NUMBER = ".RANDOM_NUMBER";
    private static final String CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String stringNumber = intent.getStringExtra(RANDOM_NUMBER);
        int number = Integer.valueOf(stringNumber);
        if (intentAction != null) {
            String toastMessage = context.getResources().getString(R.string.unknown_intent_action);
            switch (intentAction){
                case CUSTOM_BROADCAST:
                    toastMessage = context.getResources().getString(R.string.custom_broadcast_received);
                    break;
            }
            Toast.makeText(context, toastMessage + " Square of the number is " + number * number, Toast.LENGTH_LONG).show();
        }
    }
}