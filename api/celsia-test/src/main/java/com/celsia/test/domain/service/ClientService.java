package com.celsia.test.domain.service;

import com.celsia.test.domain.Client;
import com.celsia.test.domain.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> findById(String clientId) {
        return clientRepository.findById(clientId);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public boolean deleteById(String clientId) {
        return findById(clientId).map(client -> {
            clientRepository.deleteById(clientId);
            return true;
        }).orElse(false);
    }

}
