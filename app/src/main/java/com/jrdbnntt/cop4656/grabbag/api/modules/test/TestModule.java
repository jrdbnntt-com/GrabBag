package com.jrdbnntt.cop4656.grabbag.api.modules.test;

import com.android.volley.Response;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.test.data.SimplePostTestRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.test.data.SimplePostTestResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.test.data.get.SimpleGetTestResponse;
import com.jrdbnntt.cop4656.grabbag.api.util.ApiModule;

/**
 * API Module for testing api functionality
 */

public class TestModule extends ApiModule {

    public TestModule(GrabBagApi api) {
        super(api);
    }

    public void sendTestGet(
            Response.Listener<SimpleGetTestResponse> res,
            Response.ErrorListener err
    ) {
        api.sendGet("/test/get/simple_get_test", SimpleGetTestResponse.class, null, res, err);
    }

   public void sendTestPost(
           SimplePostTestRequest req,
           Response.Listener<SimplePostTestResponse> res,
           Response.ErrorListener err
   ) {
       api.sendPost("/test/simple_post_test", req, SimplePostTestResponse.class, null, res, err);
   }
}
