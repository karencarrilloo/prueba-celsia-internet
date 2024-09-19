package com.celsia.test.persistence;

import com.celsia.test.domain.Client;
import com.celsia.test.domain.repository.ClientRepository;
import com.celsia.test.persistence.crud.ClienteCrudRepository;
import com.celsia.test.persistence.entity.Cliente;
import com.celsia.test.persistence.mapper.ClientMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author
 */
@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public List<Client> getAll() {
        return mapper.toClients((List<Cliente>) clienteCrudRepository.findAll());
    }

    @Override
    public Optional<Client> findById(String clientId) {
        return clienteCrudRepository.findById(clientId)
                .map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void deleteById(String clientId) {
        clienteCrudRepository.deleteById(clientId);
    }

}
