package com.tringapps.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void createNotification(View view)
    {
        Intent intent = new Intent(this,NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,0);
        Notification noti = new Notification.Builder(this).setContentTitle("New mail from" + "geethu")
                .setContentText("I'm notification text").setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pIntent).addAction(R.mipmap.ic_launcher,"Call",pIntent)
                .addAction(R.mipmap.ic_launcher,"More",pIntent).addAction(R.mipmap.ic_launcher,"And more",pIntent).setPriority(Notification.PRIORITY_MAX).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0,noti);


    }
}
