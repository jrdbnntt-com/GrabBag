package com.jrdbnntt.cop4656.grabbag.app;


import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    TextView tvCounter;
    TextView tvCoins;
    int taps=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack_screen);
        bSteal = (Button)findViewById(R.id.bSteal);
        ivStealing= (ImageView)findViewById(R.id.ivStealing);
        tvCounter= (TextView) findViewById(R.id.tvTimer);
        tvCoins= (TextView) findViewById(R.id.tvCoins);


        countDownTimer = new CountDownTimer(31*1000,1000 ){

            @Override
            public void onTick(long l) {
                tvCounter.setText(""+l/1000);
            }

            @Override
            public void onFinish() {
                bSteal.setEnabled(false);
                tvCounter.setText("Taps: "+taps);
                tvCoins.setText("Coins stolen: "+(int)(taps*.1));

            }
        }.start();



        bSteal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ivStealing.setImageResource(R.drawable.stealing2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ivStealing.setImageResource(R.drawable.stealing1);
                    taps++;
                    tvCoins.setText("Coins stolen: "+(int)(taps*.1));
                }
                return true;
            }

        });



    }


}
