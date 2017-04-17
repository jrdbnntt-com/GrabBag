package com.jrdbnntt.cop4656.grabbag.api.modules.game;

import com.android.volley.Response;
import com.jrdbnntt.cop4656.grabbag.api.GrabBagApi;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.CreateRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.CreateResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.FindNearbyPlayersRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.FindNearbyPlayersResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.JoinRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.JoinResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.StartRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.PlayersRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.PlayersResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.SummaryRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.SummaryResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.steal.AttackEndRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.steal.AttackStartRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.steal.AttackStartResponse;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.steal.DefendEndRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.steal.DefendStartRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.steal.LogRequest;
import com.jrdbnntt.cop4656.grabbag.api.modules.game.data.steal.LogResponse;
import com.jrdbnntt.cop4656.grabbag.api.util.ApiModule;
import com.jrdbnntt.cop4656.grabbag.api.util.data.EmptyResponse;

/**
 * Game related routes
 */

public class GameModule extends ApiModule {
    public GameModule(GrabBagApi api) {
        super(api);
    }

    public void start(
            StartRequest req,
            Response.Listener<EmptyResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/start", req, EmptyResponse.class, res, err);
    }

    public void join(
            JoinRequest req,
            Response.Listener<JoinResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/join", req, JoinResponse.class, res, err);
    }

    public void create(
            CreateRequest req,
            Response.Listener<CreateResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/create", req, CreateResponse.class, res, err);
    }

    public void findNearbyPlayers(
            FindNearbyPlayersRequest req,
            Response.Listener<FindNearbyPlayersResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/find_nearby_players", req,
                FindNearbyPlayersResponse.class, res, err);
    }

    public void players(
            PlayersRequest req,
            Response.Listener<PlayersResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/players", req, PlayersResponse.class, res, err);
    }

    public void summary(
            SummaryRequest req,
            Response.Listener<SummaryResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/summary", req, SummaryResponse.class, res, err);
    }

    public void stealAttackEnd(
            AttackEndRequest req,
            Response.Listener<EmptyResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/steal/attack_end", req, EmptyResponse.class, res, err);
    }

    public void stealAttackStart(
            AttackStartRequest req,
            Response.Listener<AttackStartResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/steal/attack_start", req, AttackStartResponse.class, res, err);
    }

    public void stealDefendStart(
            DefendStartRequest req,
            Response.Listener<EmptyResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/steal/defend_start", req, EmptyResponse.class, res, err);
    }

    public void stealDefendEnd(
            DefendEndRequest req,
            Response.Listener<EmptyResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/steal/defend_end", req, EmptyResponse.class, res, err);
    }

    public void stealLog(
            LogRequest req,
            Response.Listener<LogResponse> res,
            Response.ErrorListener err
    ) {
        api.sendPost("/api/game/steal/log", req, LogResponse.class, res, err);
    }


}
