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

    // get all the clients using the method made in the service
    @GetMapping
    public List<Client> getAllClients() {
        return ewmService.getAllClients();
    }

    // get 1 client by id  using the method made in the service
    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable Long clientId) {
        return ewmService.getClientById(clientId);
    }


    // add a client  using the method made in the service
    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return ewmService.addClient(client);
    }


    // update a client using the  method made in the service
    @PutMapping("/{clientId}")
    public Client updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) {
        return ewmService.updateClient(clientId, updatedClient);
    }

    // delete a client using the method made in the service

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        ewmService.deleteClient(clientId);
    }

}
