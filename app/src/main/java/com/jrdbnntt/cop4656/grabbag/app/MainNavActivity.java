package com.jrdbnntt.cop4656.grabbag.app;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.google.android.gms.vision.text.Text;
import com.jrdbnntt.cop4656.grabbag.R;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.player.data.get.GameHistoryResponse;
import com.jrdbnntt.cop4656.grabbag.api.util.data.EmptyResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainNavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    GrabBagApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        api = new GrabBagApi(this);

        setupViewForCurrentGames();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = null;

        if (id == R.id.nav_create_game) {
            intent = new Intent(this, CreateGameActivity.class);
        } else if (id == R.id.nav_join_game) {
            intent = new Intent(this, JoinGameActivity.class);
        } else if (id == R.id.nav_log_out) {
            logOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if (intent != null) {
            startActivity(intent);
        }

        return true;
    }

    private void logOut() {
        // Log out user and go to home
        api.getUserModule().logOut(new Response.Listener<EmptyResponse>() {
            @Override
            public void onResponse(EmptyResponse response) {
                Intent intent = new Intent(getApplicationContext(), SplashLoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, api.dialogErrorListener(this));
    }

    /**
     * TODO actually use fragments
     */
    private void setupViewForCurrentGames() {
        api.getPlayerModule().getGameHistory(new Response.Listener<GameHistoryResponse>() {
            @Override
            public void onResponse(GameHistoryResponse response) {
                ListView lvGameList = (ListView) findViewById(R.id.lvGameList);
                ArrayList<GameHistoryResponse.GameHistory> histories = new ArrayList<>(Arrays.asList(response.games));
                final GameHistoryAdapter adapter = new GameHistoryAdapter(getApplicationContext(), histories);

                lvGameList.setAdapter(adapter);
                lvGameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        GameHistoryResponse.GameHistory game = adapter.getItem(position);
                        if (game == null) {
                            return;
                        }
                        // TODO go to game summary
                        // go to map view (for now)
                        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                        intent.putExtra("game_id", game.game_id);
                        startActivity(intent);
                    }
                });
            }
        }, api.dialogErrorListener(this));
    }


    public class GameHistoryAdapter extends ArrayAdapter<GameHistoryResponse.GameHistory> {
        public GameHistoryAdapter(@NonNull Context context, ArrayList<GameHistoryResponse.GameHistory> histories) {
            super(context, 0, histories);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            GameHistoryResponse.GameHistory game = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_game_summary_short, parent, false);
            }

            TextView tvGameName = (TextView) convertView.findViewById(R.id.tvGameName);
            TextView tvPlayerCount = (TextView) convertView.findViewById(R.id.tvPlayerCount);
            TextView tvCoinCount = (TextView) convertView.findViewById(R.id.tvCoinCount);

            if (game != null) {
                tvGameName.setText(game.game_name);
                tvPlayerCount.setText(String.format(Locale.getDefault(), "%d", game.player_count));
                tvCoinCount.setText(String.format(Locale.getDefault(), "%d", game.player_instance_coins));
            }

            return convertView;
        }
    }


}
