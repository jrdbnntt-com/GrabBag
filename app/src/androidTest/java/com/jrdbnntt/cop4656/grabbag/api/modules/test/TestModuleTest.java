package com.jrdbnntt.cop4656.grabbag.api.modules.test;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jrdbnntt.cop4656.grabbag.api.AsyncResponseListener;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.test.data.SimplePostTestRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.test.data.SimplePostTestResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.test.data.get.SimpleGetTestResponse;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


/**
 * Testing the test API module
 */

@RunWith(AndroidJUnit4.class)
public class TestModuleTest {

    @Test
    public void simplePostTestIntegrationTest() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        GrabBagApi api = new GrabBagApi(appContext);
        final AsyncResponseListener responseListener = new AsyncResponseListener();

        SimplePostTestRequest req = new SimplePostTestRequest();
        req.some_integer = 34;

        api.getTestModule().sendTestPost(req, new Response.Listener<SimplePostTestResponse>() {
            @Override
            public void onResponse(SimplePostTestResponse response) {
                responseListener.response = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseListener.error = error;
            }
        });

        synchronized (responseListener) {
            responseListener.wait(2000);
        }
        responseListener.assertSuccess();
        SimplePostTestResponse response = (SimplePostTestResponse) responseListener.response;

        assertEquals(response.some_message, "You entered " + req.some_integer);
    }

    @Test
    public void simpleGetTestIntegrationTest() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        final GrabBagApi api = new GrabBagApi(appContext);
        final AsyncResponseListener responseListener = new AsyncResponseListener();

        api.getTestModule().sendTestGet(new Response.Listener<SimpleGetTestResponse>() {
            @Override
            public void onResponse(SimpleGetTestResponse response) {
                responseListener.response = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseListener.error = error;
            }
        });

        synchronized (responseListener) {
            responseListener.wait(2000);
        }

        responseListener.assertSuccess();
        SimpleGetTestResponse response = (SimpleGetTestResponse) responseListener.response;

        assertEquals(response.some_string, "Hello world!");

    }
}
