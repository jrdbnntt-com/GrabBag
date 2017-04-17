package com.jrdbnntt.cop4656.grabbag.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.google.firebase.messaging.FirebaseMessaging;
import com.jrdbnntt.cop4656.grabbag.R;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.JoinRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.JoinResponse;

public class JoinGameActivity extends AppCompatActivity {

    EditText etEnterGroupId;
    GrabBagApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        etEnterGroupId = (EditText) findViewById(R.id.etEnterGroupId);
        api = new GrabBagApi(this);
    }

    public void clickJoinGroup(View view)
    {
        JoinRequest req = new JoinRequest();
        req.game_join_code = etEnterGroupId.getText().toString().trim();
        api.getGameModule().join(req, new Response.Listener<JoinResponse>() {
            @Override
            public void onResponse(JoinResponse response) {
                Intent intent = new Intent(getApplicationContext(), GameSummaryActivity.class);
                intent.putExtra("game_id", response.game_id);
                startActivity(intent);
            }
        }, api.dialogErrorListener(this));
    }
}
