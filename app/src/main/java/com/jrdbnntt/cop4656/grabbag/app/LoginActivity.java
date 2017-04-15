package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.jrdbnntt.cop4656.grabbag.R;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }

    public void clickLogin(View view)
    {
        String username, password;
        username = etUsername.toString();
        password = etPassword.toString();
        /*
            Check to see if username and password are in the DB and are correct
            If true, pass intent to next activity, if false alert user with toast
                and have them re-enter their username and password

           Toast.makeText(this, "Invalid username or password.", Toast.LENGTH_LONG).show();
           etUsername.setText("");  //resetting username
           etPassword.setText("");  //resetting password
        */
        Intent intent = new Intent(this, GroupScreenActivity.class);
        startActivity(intent);
    }
}
