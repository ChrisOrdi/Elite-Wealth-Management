package com.ordina.ewm.elitewealthmanagement.controller;

import com.ordina.ewm.elitewealthmanagement.model.Client;
import com.ordina.ewm.elitewealthmanagement.service.EwmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ewm")
public class EwmController {

    private final EwmService ewmService;

    @Autowired
    public EwmController (EwmService ewmService) {
        this.ewmService = ewmService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return ewmService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable Long clientId) {
        return ewmService.getClientById(clientId);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return ewmService.addClient(client);
    }

    @PutMapping("/{clientId}")
    public Client updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) {
        return ewmService.updateClient(clientId, updatedClient);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        ewmService.deleteClient(clientId);
    }

}
