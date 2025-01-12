package com.example.clientapi.controller;

import com.example.clientapi.model.Client;
import com.example.clientapi.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/orden-nombre")
    public ResponseEntity<List<Client>> getClientsSortedByName() {
        return ResponseEntity.ok(clientService.getAllClientsSortedByName());
    }

    @GetMapping("/orden-edad")
    public ResponseEntity<List<Client>> getClientsSortedByAge() {
        return ResponseEntity.ok(clientService.getAllClientsSortedByAge());
    }


}
