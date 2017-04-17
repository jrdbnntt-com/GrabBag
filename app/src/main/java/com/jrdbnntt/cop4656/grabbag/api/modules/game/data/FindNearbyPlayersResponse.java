package com.jrdbnntt.cop4656.grabbag.api.modules.game.data;

import com.jrdbnntt.cop4656.grabbag.api.util.data.GsonObject;

/**
 * TODO
 */

public class FindNearbyPlayersResponse extends GsonObject {
    public Double steal_radius_in_meters;
    public CardinalSpread cardinal_spread;
    public PlayerInstanceSummary[] pis_in_steal_range;
    public PlayerInstanceSummary[] pis_in_view_range;
    public PlayerInstanceSummary[] pis_in_cool_down;

    public static class Location extends GsonObject {
        public Double lat;
        public Double lng;
    }

    public static class CardinalSpread extends GsonObject {
        public Location north;
        public Location north_west;
        public Location north_east;
        public Location south;
        public Location south_west;
        public Location south_east;
        public Location east;
        public Location west;
    }

    public static class PlayerInstanceSummary extends GsonObject {
        public Integer game_id;
        public Integer player_instance_id;
        public String username;
        public Double distance_in_meters;
        public Double location_lat;
        public Double location_lng;
        public String cool_down_end_time;   // Date in ISO format
    }
}
