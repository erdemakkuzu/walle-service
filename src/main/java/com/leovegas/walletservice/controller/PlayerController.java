package com.leovegas.walletservice.controller;

import com.leovegas.walletservice.entity.Player;
import com.leovegas.walletservice.model.CreatePlayerRequest;
import com.leovegas.walletservice.model.CreatePlayerResponse;
import com.leovegas.walletservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayer(@PathVariable("name") final String playerName){
        return ResponseEntity.ok(playerService.getPlayer(playerName));
    }

    @PostMapping
    public ResponseEntity<CreatePlayerResponse> createPlayer(@RequestBody CreatePlayerRequest createPlayerRequest){
        return new ResponseEntity(playerService.createPlayer(createPlayerRequest), HttpStatus.CREATED);
    }


}
