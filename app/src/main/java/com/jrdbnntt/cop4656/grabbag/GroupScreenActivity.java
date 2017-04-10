package com.jrdbnntt.cop4656.grabbag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GroupScreenActivity extends AppCompatActivity {

    boolean gameInProgress = false;
    Button bStartGame, bPlayGame;
    TextView tvGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_screen);
        bStartGame = (Button) findViewById(R.id.bStartGame);
        bPlayGame = (Button) findViewById(R.id.bPlayGame);
        tvGroup = (TextView) findViewById(R.id.tvGroup);

        //update group ID with generated ID
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String genID = bundle.getString("ID");
            tvGroup.setText(genID);
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
    }
}
