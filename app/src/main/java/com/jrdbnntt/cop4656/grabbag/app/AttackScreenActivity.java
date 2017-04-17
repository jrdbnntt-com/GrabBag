package com.jrdbnntt.cop4656.grabbag.app;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jrdbnntt.cop4656.grabbag.R;


public class AttackScreenActivity extends AppCompatActivity {

    Button bSteal;
    ImageView ivStealing;
    CountDownTimer countDownTimer;
    TextView tvTitle;
    TextView tvCounter;
    TextView tvCoins;
    MediaPlayer mp;


   // Notification notification;

    int taps=0;     //amount of taps, starts at zero
    int timer=30;   //This is the timer amount, you can change it here
    double stealPercentage=0.1; //This is the percentage that is stolen from the user, change it here
    int coinsStolen = 0;
    boolean isStealing =true; //If isStealing is false then it must be defending, change it here
    boolean played=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack_screen);


       // Notification noti = new Notification.Builder(this)
       //         .setSound(Uri.parse("android.resource://" + v.getContext().getPackageName() + "/" + R.raw.yourmp3file))


        bSteal = (Button)findViewById(R.id.bSteal);
        ivStealing= (ImageView)findViewById(R.id.ivStealing);
        tvCounter= (TextView) findViewById(R.id.tvTimer);
        tvCoins= (TextView) findViewById(R.id.tvCoins);
        tvTitle = (TextView) findViewById(R.id.tvStealingTitle);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.smw_coin);
       // notification = builder.build();             //testing notification
       // notification.sound = Uri.parse("android.resource://"
        //        + getApplicationContext().getPackageName() + "/" + R.raw.mama_mia);     //testing notification
        //NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); //test
        //manager.notify(1, builder.build());             //test



        if(isStealing) {
            tvTitle.setText("Tap to steal!");
        }
        else {
            tvTitle.setText("Tap to defend!");
        }

        countDownTimer = new CountDownTimer((timer+1)*1000,1000 ){

            @Override
            public void onTick(long l) {
                tvCounter.setText(""+l/1000);
            }

            @Override
            //This is the method that runs when the timer is finished
            public void onFinish() {
                if (isStealing) {
                    bSteal.setEnabled(false);
                    tvCounter.setText("Taps: " + taps); //Outputting the amount of taps
                    coinsStolen = (int) (taps * stealPercentage);       //This is the coin amount, store to database
                    tvCoins.setText("Coins stolen: " + coinsStolen); //setting the amount of coins stolen
                }
                else {
                    //Code for defending
                }

            }
        }.start();



        bSteal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ivStealing.setImageResource(R.drawable.grabbing);
                    if(played) {
                        mp.pause();
                        mp.seekTo(0);
                        mp.start();
                    }
                    else {
                        mp.start();
                        played=true;
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ivStealing.setImageResource(R.drawable.grabbing2);
                    taps++;
                    tvCoins.setText("Coins stolen: "+(int)(taps*.1));
                }
                return true;
            }

        });



    }


}
