package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jrdbnntt.cop4656.grabbag.R;

public class CreateAccountActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }

    public void submitAcct(View view)
    {
        String username, password;
        username = etUsername.toString();
        password = etPassword.toString();
        /*
            Check to see if username is not in the DB
            If true, pass intent to next activity, if false alert user with toast
                and have them re-enter their username and password

           Toast.makeText(this, "Invalid username or password.", Toast.LENGTH_LONG).show();
           etUsername.setText("");  //resetting username
           etPassword.setText("");  //resetting password
        */
        Intent intent = new Intent(this, GroupChoiceActivity.class);
        startActivity(intent);
    }
}
