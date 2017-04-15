package com.jrdbnntt.cop4656.grabbag.api.util;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GsonVolleyGetRequest<Res> extends GsonVolleyRequest<Res> {

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param method HTTP method (Request.Method)
     * @param url URL of the request to make
     * @param responseClass Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public GsonVolleyGetRequest(String url, Class<Res> responseClass, Map<String, String> headers,
                                Response.Listener<Res> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, responseClass, headers, listener, errorListener);
    }

}