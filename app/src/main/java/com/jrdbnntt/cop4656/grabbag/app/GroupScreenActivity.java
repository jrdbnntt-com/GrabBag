package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jrdbnntt.cop4656.grabbag.R;

public class GroupScreenActivity extends AppCompatActivity {

    boolean gameInProgress = false;         //needs to be replaced with a boolean from DB if game is in progress
    Button bStartGame, bPlayGame;
    TextView tvGroup;
    ListView listView;
    TextView tvTimeLeft;
    boolean creator = true;                //needs to be replaced with a boolean from DB if the
                                            //user was the creator of the game, only the creator can start the game

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_screen);
        bStartGame = (Button) findViewById(R.id.bStartGame);
        bPlayGame = (Button) findViewById(R.id.bPlayGame);
        tvTimeLeft = (TextView) findViewById(R.id.tvTimeLeft);  //update time left from DB
        /* Might be better to just store the end date and time, then put it here */

        tvGroup = (TextView) findViewById(R.id.tvGroup);
        //update group ID with generated ID
        listView = (ListView) findViewById(R.id.listView);
        /*
            Populate listView from DB of group members
        */

        if(creator == false)
        {
            bStartGame.setEnabled(false);               //if not the creator, disable the start button
        }

        Bundle bundle = getIntent().getExtras();        //getting the group ID from the create
        if(bundle != null)                              //group activity
        {                                               //if not creating a group get group ID from DB
            String genID = bundle.getString("ID");
            tvGroup.setText(genID);
        }
        else //get group ID from DB
        {

        }

        if(gameInProgress == true)
        {
            bStartGame.setEnabled(false);               //disable button once game has been started
        }
        else
        {
            bPlayGame.setEnabled(false);                //disable play button when game has not been started
        }
    }

    public void clickStart(View view)
    {
        bStartGame.setEnabled(false);               //disable button once game has been started
        gameInProgress = true;
        bPlayGame.setEnabled(true);

    }

    public void clickPlay(View view)
    {
        bStartGame.setEnabled(false);               //disable button once game has been started
        gameInProgress = true;
        bPlayGame.setEnabled(true);
        Intent intent = new Intent(this, AttackScreenActivity.class);
        startActivity(intent);
    }

    public void clickScan(View view)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
