package com.jrdbnntt.cop4656.grabbag.api.modules.game.data;

import com.jrdbnntt.cop4656.grabbag.api.util.data.GsonObject;

/**
 * TODO
 */

public class PlayersResponse extends GsonObject {
    public PlayerInstanceSummary[] player_instances;

    public static class PlayerInstanceSummary extends GsonObject {
        public Integer id;
        public Integer coins;
        public String username;
    }
}
