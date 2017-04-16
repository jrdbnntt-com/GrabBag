package com.jrdbnntt.cop4656.grabbag.api.util;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GsonVolleyRequest<Res> extends Request<Res> {
    protected final Gson gson = new Gson();
    private final Class<Res> responseClass;
    private final Map<String, String> headers;
    private final Response.Listener<Res> listener;

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param method HTTP method (Request.Method)
     * @param url URL of the request to make
     * @param responseClass Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public GsonVolleyRequest(int method, String url, Class<Res> responseClass, Map<String, String> headers,
                                Response.Listener<Res> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.responseClass = responseClass;
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(Res response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<Res> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, responseClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }


    @Override
    protected VolleyError parseNetworkError(VolleyError err) {
        if (err.networkResponse != null && err.networkResponse.data != null){
            err = new VolleyError(new String(err.networkResponse.data), err);
        }
        return err;
    }
}