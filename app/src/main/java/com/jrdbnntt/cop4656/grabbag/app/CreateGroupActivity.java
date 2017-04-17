package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.messaging.FirebaseMessaging;
import com.jrdbnntt.cop4656.grabbag.R;

import java.util.Random;
import java.lang.StringBuilder;

public class CreateGroupActivity extends AppCompatActivity {

    EditText etGroupID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        etGroupID = (EditText) findViewById(R.id.etGroupID);
    }

    public void clickCreateGroup(View view)
    {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, GroupScreenActivity.class);
        String genID = etGroupID.toString();

        //TODO: Finalize integration. This should theoretically work.
        //Calling "subscribeToTopic" for a topic that doesn't exist should create it.
        //FirebaseMessaging.getInstance().subscribeToTopic(genID);

        if(true)//genID not in DB) //create the group
        {
            bundle.putString("ID", genID);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else
        {//invalid group ID
            etGroupID.setText("");              //clear group ID
        }
    }
}
