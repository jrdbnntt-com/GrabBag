package com.jrdbnntt.cop4656.grabbag.api.modules.game.data.steal;

import com.jrdbnntt.cop4656.grabbag.api.util.data.GsonObject;

/**
 * TODO
 */

public class LogResponse extends GsonObject {
    public StealAttemptSummary[] completed_steal_attempts;

    public static class StealAttemptSummary extends GsonObject {
        public Integer id;
        public String completed_at;     // Date in ISO format
        public String victim_username;
        public String thief_username;
        public Integer coins_stolen;    // 0 = no steal
        public Integer thief_score;
        public Integer victim_score;
    }
}
