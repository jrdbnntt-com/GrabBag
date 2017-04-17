package com.jrdbnntt.cop4656.grabbag.api.modules.game.data;

import com.jrdbnntt.cop4656.grabbag.api.util.data.GsonObject;

/**
 * TODO
 */

public class CreateRequest extends GsonObject {
    public String name;
    public String join_code;
    public Integer duration_in_minutes;
    public Integer maximum_steal_distance_in_meters;
    public Integer starting_coins;
    public Integer steal_pecent;
    public Integer steal_game_seconds;
    public Integer steal_defend_seconds;
    public Integer steal_cool_down_seconds;
}
