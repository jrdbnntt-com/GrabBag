package com.jrdbnntt.cop4656.grabbag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_main);
    }

    public void clickCreate(View view)
    {
        Intent intent = new Intent(this, CreateAccountActivity.class);

        startActivity(intent);
    }

    public void clickLogIn(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
