package com.jrdbnntt.cop4656.grabbag.api;

import com.android.volley.VolleyError;


import static org.junit.Assert.*;

/**
 * Utility for testing api calls
 */

public class AsyncResponseListener {
    public Object response;
    public VolleyError error;

    public void assertSuccess() {
        assertNotNull(response);
        assertNull(error);
    }
}
