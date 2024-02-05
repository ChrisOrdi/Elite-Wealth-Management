package com.ordina.ewm.elitewealthmanagement.service;

import com.ordina.ewm.elitewealthmanagement.model.Client;
import com.ordina.ewm.elitewealthmanagement.repository.EwmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EwmService {

    private final EwmRepository ewmClientRepository;

    @Autowired
    public EwmService(EwmRepository ewmClientRepository) {
        this.ewmClientRepository = ewmClientRepository;
    }

    public List<Client> getAllClients() {
        return ewmClientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        Optional<Client> optionalClient = ewmClientRepository.findById(clientId);
        return optionalClient.orElse(null);
    }

    public Client addClient(Client client) {
        return ewmClientRepository.save(client);
    }

    public Client updateClient(Long clientId, Client updatedClient) {
        if (ewmClientRepository.existsById(clientId)) {
            updatedClient.setId(clientId);
            return ewmClientRepository.save(updatedClient);
        }
        return null; // Handle not found case
    }

    public void deleteClient(Long clientId) {
        ewmClientRepository.deleteById(clientId);
    }

}
