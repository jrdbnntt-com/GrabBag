package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.jrdbnntt.cop4656.grabbag.R;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
       // getActionBar().hide();
        new Handler ().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreenActivity.this, MainScreen.class);
                startActivity(homeIntent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
