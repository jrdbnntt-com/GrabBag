package com.jrdbnntt.cop4656.grabbag.api.modules.player.data.get;

import com.jrdbnntt.cop4656.grabbag.api.util.data.GsonObject;

/**
 * TODO
 */

public class GameHistoryResponse extends GsonObject {
    public GameHistory[] games;

    public static class GameHistory extends GsonObject {
        public Integer player_instance_id;
        public Integer player_instance_coins;
        public Integer game_id;
        public Integer game_status;
        public String game_name;
        public Integer player_count;
    }
}
