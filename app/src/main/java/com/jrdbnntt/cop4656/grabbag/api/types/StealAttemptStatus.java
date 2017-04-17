package com.jrdbnntt.cop4656.grabbag.api.types;

/**
 * TODO
 */

public enum StealAttemptStatus {
    WAITING_FOR_THIEF_END(0),
    WAITING_FOR_DEFENSE_START(2),
    WAITING_FOR_DEFENSE_END(3),
    COMPLETE(4),
    EXPIRED(5);

    final int id;

    StealAttemptStatus(int id) {
        this.id = id;
    }

    public static StealAttemptStatus getById(int id) {
        for (StealAttemptStatus status : StealAttemptStatus.values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status id: " + id);
    }
}