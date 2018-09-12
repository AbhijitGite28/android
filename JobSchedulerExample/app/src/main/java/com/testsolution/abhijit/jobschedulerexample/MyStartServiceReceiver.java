package com.testsolution.abhijit.jobschedulerexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.testsolution.abhijit.jobschedulerexample.Util;

public class  MyStartServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        System.out.print("I am setUICallback");
        Util.scheduleJob(context);
    }
}