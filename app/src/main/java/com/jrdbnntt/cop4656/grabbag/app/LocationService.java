package com.jrdbnntt.cop4656.grabbag.app;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;

import com.jrdbnntt.cop4656.grabbag.api.modules.player.data.UpdateLocationRequest;
import com.jrdbnntt.cop4656.grabbag.api.util.data.EmptyResponse;

/**
 * Created by filipp on 6/16/2016.
 */
public class LocationService extends Service {

    private LocationListener listener;
    private LocationManager locationManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                GrabBagApi api = new GrabBagApi(getApplicationContext());
                UpdateLocationRequest req = new UpdateLocationRequest();
                req.location_lat=location.getLatitude();
                req.location_lng=location.getLongitude();

                api.getPlayerModule().updateLocation(req, new Response.Listener<EmptyResponse>() {
                    @Override
                    public void onResponse(EmptyResponse response) {
                        return;
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        return;
                    }
                });

                //Intent i = new Intent("location_update");
                //i.putExtra("coordinates",location.getLongitude()+" "+location.getLatitude());
                //sendBroadcast(i);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        };

        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

        //noinspection MissingPermission
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000*60*2,0,listener);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(locationManager != null){
            //noinspection MissingPermission
            locationManager.removeUpdates(listener);
        }
    }
}