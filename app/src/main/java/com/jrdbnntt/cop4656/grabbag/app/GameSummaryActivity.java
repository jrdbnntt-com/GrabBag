package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.jrdbnntt.cop4656.grabbag.R;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.FindNearbyPlayersResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.SummaryRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.SummaryResponse;

public class GameSummaryActivity extends AppCompatActivity {

    boolean gameInProgress = false;         //needs to be replaced with a boolean from DB if game is in progress
    Button bStartGame, bPlayGame;
    TextView tvGroup;
    ListView listView;
    TextView tvTimeLeft;
    boolean creator = true;                //needs to be replaced with a boolean from DB if the
                                            //user was the creator of the game, only the creator can start the game

    GrabBagApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_screen);
        api = new GrabBagApi(this);


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


        SummaryRequest req = new SummaryRequest();
        req.game_id = getIntent().getIntExtra("game_id", 0);
        api.getGameModule().summary(req, new Response.Listener<SummaryResponse>() {
            @Override
            public void onResponse(SummaryResponse response) {
                if (response.id != null) {
                    tvGroup.setText(response.id);
                }
            }
        }, api.dialogErrorListener(this));

        if(creator == false)
        {
            bStartGame.setEnabled(false);               //if not the creator, disable the start button
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
