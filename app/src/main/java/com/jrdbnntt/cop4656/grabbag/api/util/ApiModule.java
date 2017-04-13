package com.jrdbnntt.cop4656.grabbag.api.util;

import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;

/**
 * Extensions of the main API, consisting of functions that initiate requests
 */

public abstract class ApiModule {
    protected GrabBagApi api;

    public ApiModule(GrabBagApi api) {
        this.api = api;
    }
}
