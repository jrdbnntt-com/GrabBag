package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.android.volley.Response;
import com.jrdbnntt.cop4656.grabbag.R;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.user.data.RegisterRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.user.data.RegisterResponse;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etFirstName, etLastName, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
    }

    public void onSubmit(View view) {
        RegisterRequest req = new RegisterRequest();
        req.username = etUsername.getText().toString();
        req.password = etPassword.getText().toString();
        req.first_name = etFirstName.getText().toString();
        req.last_name = etLastName.getText().toString();
        req.email = etEmail.getText().toString();

        GrabBagApi api = new GrabBagApi(this);
        api.getUserModule().register(req, new Response.Listener<RegisterResponse>() {
            @Override
            public void onResponse(RegisterResponse response) {
                Intent intent;
                if (response.logged_in) {
                    intent = new Intent(getApplicationContext(), GameChoiceActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                }

                startActivity(intent);

            }
        }, api.dialogErrorListener(this));

    }
}
