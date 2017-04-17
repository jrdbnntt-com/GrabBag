package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.jrdbnntt.cop4656.grabbag.R;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.user.data.LoginRequest;
import com.jrdbnntt.cop4656.grabbag.api.util.data.EmptyResponse;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button bLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogIn = (Button) findViewById(R.id.bLogIn);

        bLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInUser();
            }
        });

        // TODO redirect if already logged in
    }

    public void logInUser() {
        LoginRequest req = new LoginRequest();
        req.username = etUsername.getText().toString();
        req.password = etPassword.getText().toString();

        GrabBagApi api = new GrabBagApi(this);
        api.getUserModule().logIn(req, new Response.Listener<EmptyResponse>() {
            @Override
            public void onResponse(EmptyResponse response) {
                Intent intent = new Intent(getApplicationContext(), GameSummaryActivity.class);
                startActivity(intent);
            }
        }, api.dialogErrorListener(this));

    }
}
