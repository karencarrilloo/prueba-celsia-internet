package com.celsia.test.domain.repository;

import com.celsia.test.domain.Client;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author
 */
public interface ClientRepository {

    List<Client> getAll();
    Optional<Client> findById(String clientId);
    Client save(Client client);
    void deleteById(String clientId);
    
}
