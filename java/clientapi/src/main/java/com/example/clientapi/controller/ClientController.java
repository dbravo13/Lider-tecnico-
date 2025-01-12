package com.example.clientapi.controller;

import com.example.clientapi.model.Client;
import com.example.clientapi.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cliente")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.saveClient(client));
    }


}
