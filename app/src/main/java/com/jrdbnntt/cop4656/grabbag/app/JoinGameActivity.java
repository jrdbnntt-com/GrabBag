package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jrdbnntt.cop4656.grabbag.R;

public class JoinGameActivity extends AppCompatActivity {

    EditText etEnterGroupId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        etEnterGroupId = (EditText) findViewById(R.id.etEnterGroupId);
    }

    public void clickJoinGroup(View view)
    {
        if(true) //etEnterGroupID) //if group ID in DB, add this user to the group
        {
            Intent intent = new Intent(this, GameSummaryActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Group ID does not exist.", Toast.LENGTH_LONG).show();
            etEnterGroupId.setText("");        //reset group ID
        }
    }
}
