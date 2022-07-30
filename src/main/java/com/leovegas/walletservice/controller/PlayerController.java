package com.leovegas.walletservice.controller;

import com.leovegas.walletservice.constant.Operations;
import com.leovegas.walletservice.entity.Player;
import com.leovegas.walletservice.model.CreatePlayerRequest;
import com.leovegas.walletservice.model.CreatePlayerResponse;
import com.leovegas.walletservice.model.GetPlayerResponse;
import com.leovegas.walletservice.service.PlayerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    PlayerService playerService;
    @Autowired

    PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping(value = "/{playerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = Operations.GET_PLAYER)
    public ResponseEntity<GetPlayerResponse> getPlayer(@PathVariable("playerName") final String playerName) {
        return ResponseEntity.ok(playerService.getPlayer(playerName));
    }

    @GetMapping(value = "/players", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = Operations.GET_PLAYERS)
    public ResponseEntity<List<GetPlayerResponse>> getPlayers() {
        return ResponseEntity.ok(playerService.getPlayers());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = Operations.CREATE_PLAYER)
    public ResponseEntity<CreatePlayerResponse> createPlayer(@RequestBody final CreatePlayerRequest createPlayerRequest) {
        return new ResponseEntity(playerService.createPlayer(createPlayerRequest), HttpStatus.CREATED);
    }


}
