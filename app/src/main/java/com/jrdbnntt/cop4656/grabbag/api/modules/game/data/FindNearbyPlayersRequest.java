package com.jrdbnntt.cop4656.grabbag.api.modules.game.data;

import com.jrdbnntt.cop4656.grabbag.api.util.data.GsonObject;

/**
 * TODO
 */

public class FindNearbyPlayersRequest extends GsonObject {
    public Integer game_id;
    public Double location_lat;
    public Double location_lng;
}
