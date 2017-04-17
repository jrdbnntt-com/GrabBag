package com.jrdbnntt.cop4656.grabbag.api.types;

/**
 * TODO
 */

public enum GameStatus {
    START_PENDING(0),       // Waiting for creator to start game, new players can join the game
    ACTIVE(1),              // Game is live, players may steal from one another
    PAUSED(3),              // players may not steal from one another temporarily
    COMPLETE_PENDING(4),    // Waiting for any unfinished steal attempts
    COMPLETE(5);            // Scores are final, no pending steal attempts

    final int id;

    GameStatus(int id) {
        this.id = id;
    }

    public static GameStatus getById(int id) {
        for (GameStatus status : GameStatus.values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status id: " + id);
    }
}
