package com.example.clientapi.service;

import com.example.clientapi.model.Client;
import com.example.clientapi.repository.ClientRepository;
import com.example.exception.DuplicateResourceException;

import org.springframework.stereotype.Service;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        if (clientRepository.existsByEmail(client.getEmail())) {
            throw new DuplicateResourceException("El correo ya está registrado: " + client.getEmail());
        }
        if (clientRepository.existsByDocumento(client.getDocumento())) {
            throw new DuplicateResourceException("El documento de identidad ya está registrado: " + client.getDocumento());
        }
        return clientRepository.save(client);
    }

}
