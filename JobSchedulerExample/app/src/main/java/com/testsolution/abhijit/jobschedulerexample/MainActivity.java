package com.testsolution.abhijit.jobschedulerexample;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Intent intent;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.scheduleJob(this);
        //setIntents();
        intent = new Intent(this,MainActivity.class);
        //intent.putExtra("com.example.abc.send_messege.broadcast.Message",text.getText().toString());
        intent.setAction("com.testsolution.abhijit.jobschedulerexample.send_messege.custom_action");
        sendBroadcast(intent);
    }

//   private void setIntents()
//    {
//        Button btn = (Button) findViewById(R.id.buttonScheduleJob);
//
//        btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v)
//            {
//                JobInfo.Builder builder = new JobInfo.Builder(0, myServiceComponent);
//                builder.setRequiresCharging(true);
//                //builder.setMinimumLatency(1 * 1000); // wait at least
//                builder.setPeriodic(2000);
//                //builder.setOverrideDeadline(3 * 1000); // maximum delay
//                //builder.setRequiresDeviceIdle(true);
//                //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
//
//                myService.scheduleJob(builder.build());
//                JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);
//                jobScheduler.schedule(builder.build());
//            }
//
//
//        });
//    }
}
