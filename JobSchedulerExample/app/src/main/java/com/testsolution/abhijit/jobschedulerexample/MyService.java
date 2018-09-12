package com.testsolution.abhijit.jobschedulerexample;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.RequiresApi;
import android.util.Log;


public class MyService extends JobService
{
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyService", "myService created");
    }

    // This method is called when the service instance
    // is destroyed
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MyService", "myService destroyed");
        System.out.print("I am setUICallback");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onStartJob(JobParameters params)
    {
        Intent service = new Intent(getApplicationContext(), MainActivity.class);
        getApplicationContext().startService(service);
        Util.scheduleJob(getApplicationContext()); // reschedule the job
        return true;

    }

    @Override
    public boolean onStopJob(JobParameters params){
        System.out.print("I am setUICallback");
        return false;
    }

    MainActivity myMainActivity;

    public void setUICallback(MainActivity activity)
    {
        System.out.print("I am setUICallback");
        myMainActivity = activity;
    }

    // This method is called when the start command
    // is fired
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        System.out.print("I am onStartCommand");

        Messenger callback = intent.getParcelableExtra("messenger");
        Message m = Message.obtain();
        m.what = 2;
        m.obj = this;
        try {
            callback.send(m);
        } catch (RemoteException e) {
            Log.e("MyService", "Error passing service object back to activity.");
        }
        return START_NOT_STICKY;
    }
}
