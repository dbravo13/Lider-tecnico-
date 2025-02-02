package com.example.clientapi.service;

import com.example.clientapi.model.Client;
import com.example.clientapi.repository.ClientRepository;
import com.example.exception.DuplicateResourceException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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

    public List<Client> getAllClientsSortedByName() {
        return clientRepository.findAll().stream()
                .sorted((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()))
                .toList();
    }

    public List<Client> getAllClientsSortedByAge() {
        return clientRepository.findAll().stream()
                .map(client -> {
                    client.setEdad(calculateAge(client.getFechaNacimiento())); 
                    return client; 
                })
                .sorted((c1, c2) -> c1.getEdad().compareTo(c2.getEdad())) 
                .toList(); 
    }
    
    private int calculateAge(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public long getClientCount() {
        return clientRepository.count();
    }

    public double getAverageAge() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .mapToInt(client -> calculateAge(client.getFechaNacimiento()))
                .average()
                .orElse(0.0);
    }


}
