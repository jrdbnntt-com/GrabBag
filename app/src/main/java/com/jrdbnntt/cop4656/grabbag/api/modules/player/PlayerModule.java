package com.jrdbnntt.cop4656.grabbag.api.modules.player;

import com.android.volley.Response;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.player.data.UpdateLocationRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.player.data.get.GameHistoryResponse;
import com.jrdbnntt.cop4656.grabbag.api.util.ApiModule;
import com.jrdbnntt.cop4656.grabbag.api.util.data.EmptyResponse;

/**
 * Player related routes
 */

public class PlayerModule extends ApiModule {
    public PlayerModule(GrabBagApi api) {
        super(api);
    }

    public void updateLocation(
            UpdateLocationRequest req,
            Response.Listener<EmptyResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/player/update_location", req, EmptyResponse.class, res, err);
    }

    public void getGameHistory(
            Response.Listener<GameHistoryResponse> res,
            Response.ErrorListener err
    ) {
        api.sendGet("/api/player/get/game_history", GameHistoryResponse.class, res, err);
    }
}
