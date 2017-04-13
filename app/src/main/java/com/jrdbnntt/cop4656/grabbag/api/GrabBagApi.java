package com.jrdbnntt.cop4656.grabbag.api;

import android.content.Context;

import com.jrdbnntt.cop4656.grabbag.api.modules.test.TestModule;
import com.jrdbnntt.cop4656.grabbag.api.util.GsonVolleyApi;

/**
 * Interface for making requests to the server. Abstracts out the requests so that the user only
 * needs to worry about the inputs & outputs
 */

public class GrabBagApi extends GsonVolleyApi {

    private static final String BASE_URL = "https://gb.jrdbnntt.com/api";

    private TestModule testModule;


    public GrabBagApi(Context context) {
        super(BASE_URL, context);
    }


    public TestModule getTestModule() {
        if (testModule == null) {
            testModule = new TestModule(this);
        }
        return testModule;
    }


}
