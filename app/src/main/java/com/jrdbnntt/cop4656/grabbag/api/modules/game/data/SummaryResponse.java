package com.jrdbnntt.cop4656.grabbag.api.modules.game.data;

import com.jrdbnntt.cop4656.grabbag.api.types.GameStatus;
import com.jrdbnntt.cop4656.grabbag.api.util.data.GsonObject;

/**
 * TODO
 */

public class SummaryResponse extends GsonObject {
    public Integer id;
    public Integer status;          // Game.Status
    public String end_time;         // Date in ISO
    public String start_time;       // Date in ISO
    public String name;
    public String join_code;
    public Integer duration_in_minutes;
    public Integer maximum_steal_distance_in_meters;
    public Integer starting_coins;
    public Integer steal_percent;
    public Integer steal_game_seconds;
    public Integer steal_defend_seconds;
    public Integer steal_cool_down_seconds;
    public Integer player_count;
    public String creator_username;

    public GameStatus getStatus() {
        return GameStatus.getById(this.status);
    }
}
