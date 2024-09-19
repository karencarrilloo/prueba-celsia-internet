package com.celsia.test.web.controller;

import com.celsia.test.domain.Client;
import com.celsia.test.domain.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getClientById")
    public ResponseEntity<Client> findById(@RequestBody String clientId) {
        return clientService.findById(clientId).map(
                clients -> new ResponseEntity<>(clients, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveClient")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteClient")
    public ResponseEntity deleteById(@RequestBody String clientId) {
        if (clientService.deleteById(clientId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
