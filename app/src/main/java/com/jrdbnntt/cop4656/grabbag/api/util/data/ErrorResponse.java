package com.jrdbnntt.cop4656.grabbag.api.util.data;

/**
 * Standard error response from server
 */

public class ErrorResponse extends GsonObject {
    public String error;    // Type of exception: External/Internal
    public String cause;    // Actual exception type thrown
    public String message;
}
