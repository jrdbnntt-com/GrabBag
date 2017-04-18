package com.jrdbnntt.cop4656.grabbag;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.jrdbnntt.cop4656.grabbag.app.SplashLoginActivity;

public class GrabBagFirebaseMsgServ extends FirebaseMessagingService {
    public static final String TAG = "GrabBagFirebaseMsgServ";
    private static final String notificationTitle = "Grab Bag";

    public GrabBagFirebaseMsgServ() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        NotificationManager mNotificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder myNotBuilder = new NotificationCompat.Builder(this);
        myNotBuilder.setSmallIcon(R.drawable.small_money_icon);
        myNotBuilder.setContentTitle(notificationTitle);

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            myNotBuilder.setContentText(remoteMessage.getNotification().getBody());

            /*TODO: Replace with some sort of decision-making system.
                Right now it just loads the main screen. Modify Intent as necessary.
             */
            Intent resultIntent = new Intent(this, SplashLoginActivity.class);
            PendingIntent testPendingIntent = PendingIntent.getActivity(this,0,resultIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            myNotBuilder.setContentIntent(testPendingIntent);

            int mNotificationID = 1;
            mNotificationManager.notify(mNotificationID, myNotBuilder.build());
        }
    }

}
