package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Response;
import com.google.firebase.messaging.FirebaseMessaging;
import com.jrdbnntt.cop4656.grabbag.R;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.CreateRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.CreateResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.StartRequest;
import com.jrdbnntt.cop4656.grabbag.api.util.data.EmptyResponse;

public class CreateGameActivity extends AppCompatActivity {

    EditText etGroupID;
    GrabBagApi api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        etGroupID = (EditText) findViewById(R.id.etGroupID);
        api = new GrabBagApi(this);
    }

    public void clickCreateGroup(View view)
    {
        String genID = etGroupID.getText().toString().trim();

        CreateRequest request = new CreateRequest();
        request.name = genID;
        request.join_code = genID;
        request.maximum_steal_distance_in_meters = 50;
        request.starting_coins = 100;
        request.steal_defend_seconds = 10;
        request.duration_in_minutes = 60;
        request.steal_percent = 10;
        request.steal_cool_down_seconds = 300;
        request.steal_game_seconds = 10;
        api.getGameModule().create(request, new Response.Listener<CreateResponse>() {
            @Override
            public void onResponse(CreateResponse response) {
                Intent intent = new Intent(getApplicationContext(), GameSummaryActivity.class);
                intent.putExtra("game_id", response.game_id);
                startActivity(intent);
            }
        }, api.dialogErrorListener(this));

        //TODO: Finalize integration. This should theoretically work.
        //Calling "subscribeToTopic" for a topic that doesn't exist should create it.
        //FirebaseMessaging.getInstance().subscribeToTopic(genID);
    }
}
