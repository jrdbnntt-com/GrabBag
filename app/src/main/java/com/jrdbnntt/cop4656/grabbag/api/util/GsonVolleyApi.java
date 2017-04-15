package com.jrdbnntt.cop4656.grabbag.api.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;

import java.util.Map;

/**
 * A general API class which combines Gson & Volley for GET/POST requests
 */

public abstract class GsonVolleyApi {

    private String baseUrl;
    private Context context;

    public GsonVolleyApi(String baseUrl, Context context) {
        this.baseUrl = baseUrl;
        this.context = context;
    }

    public <Res> void sendGet(
            String localUrl,
            Class<Res> responseClass,
            Map<String, String> headers,
            Response.Listener<Res> responseListener,
            Response.ErrorListener errorListener
    ) {
        String url = baseUrl + localUrl;
        GsonVolleyGetRequest<Res> request = new GsonVolleyGetRequest<>(
                url, responseClass, headers, responseListener, errorListener
        );
        VolleyManager.getInstance(context).addToRequestQueue(request);
    }

    public <Req, Res> void sendPost(
            String localUrl,
            Req requestObject,
            Class<Res> responseClass,
            Map<String, String> headers,
            Response.Listener<Res> responseListener,
            Response.ErrorListener errorListener
    ) {
        String url = baseUrl + localUrl;
        GsonVolleyPostRequest<Req, Res> request = new GsonVolleyPostRequest<>(
                url, requestObject, responseClass, headers, responseListener, errorListener
        );
        VolleyManager.getInstance(context).addToRequestQueue(request);
    }

    public <Req, Res> void sendPost(
            String localUrl,
            String requestJson,
            Class<Res> responseClass,
            Map<String, String> headers,
            Response.Listener<Res> responseListener,
            Response.ErrorListener errorListener
    ) {
        String url = baseUrl + localUrl;
        GsonVolleyPostRequest<Req, Res> request = new GsonVolleyPostRequest<>(
                url, requestJson, responseClass, headers, responseListener, errorListener
        );
        VolleyManager.getInstance(context).addToRequestQueue(request);
    }
}
