package com.jrdbnntt.cop4656.grabbag;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static android.content.ContentValues.TAG;

public class GrabBagInstIDServ extends FirebaseInstanceIdService {
    private static final String TAG = "GrabBagInstIDServ";
    public GrabBagInstIDServ() {
    }

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Updated token: " + refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        /*TODO: Implement code that actually fires the token to our app server.
            We need the app server to take in these tokens so they can send out the
            firebase messages to the groups.
         */
    }

}
