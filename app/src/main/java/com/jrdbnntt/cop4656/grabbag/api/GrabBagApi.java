package com.jrdbnntt.cop4656.grabbag.api;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jrdbnntt.cop4656.grabbag.api.modules.test.TestModule;
import com.jrdbnntt.cop4656.grabbag.api.modules.user.UserModule;
import com.jrdbnntt.cop4656.grabbag.api.util.GsonVolleyApi;
import com.jrdbnntt.cop4656.grabbag.api.util.data.ErrorResponse;

/**
 * Interface for making requests to the server. Abstracts out the requests so that the user only
 * needs to worry about the inputs & outputs
 */

public class GrabBagApi extends GsonVolleyApi {

    private static final String BASE_URL = "https://gb.jrdbnntt.com/api";

    private TestModule testModule;
    private UserModule userModule;

    public GrabBagApi(Context context) {
        super(BASE_URL, context);
    }


    public TestModule getTestModule() {
        if (testModule == null) {
            testModule = new TestModule(this);
        }
        return testModule;
    }

    public UserModule getUserModule() {
        if (userModule == null) {
            userModule = new UserModule(this);
        }
        return userModule;
    }

    public Response.ErrorListener dialogErrorListener(final Context context) {
        return new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(this.getClass().getName(), error.getMessage());

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context)
                        .setIconAttribute(android.R.attr.alertDialogIcon)
                        .setPositiveButton("Ok", null);

                // Build the dialog based on the response
                NetworkResponse response = getNetworkResponse(error);
                if (response == null) {
                    dialogBuilder.setTitle("Error");
                    dialogBuilder.setMessage("Network error");
                } else {
                    switch (response.statusCode) {
                        case 400:   // Bad request (validation probably failed)
                            Gson gson = new Gson();
                            ErrorResponse res = gson.fromJson(
                                    error.getMessage(), ErrorResponse.class);
                            dialogBuilder.setTitle(res.cause);
                            dialogBuilder.setMessage(res.message);
                            break;
                        case 401:   // Unauthorized, possibly not logged in
                            dialogBuilder.setTitle("Unauthorized");
                            dialogBuilder.setMessage("You do not have permission to do that");
                            break;
                        default:
                            dialogBuilder.setTitle("Unknown Error");
                            dialogBuilder.setMessage(error.getMessage());
                    }
                }

                dialogBuilder.create().show();
            }

        };
    }

    public NetworkResponse getNetworkResponse(VolleyError error) {
        if (error.networkResponse != null) {
            return error.networkResponse;
        }
        Throwable cause = error.getCause();
        if (cause != null && cause instanceof VolleyError) {
            return ((VolleyError) cause).networkResponse;
        }
        return null;
    }


}
