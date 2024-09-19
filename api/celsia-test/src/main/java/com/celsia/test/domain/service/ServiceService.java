package com.celsia.test.domain.service;

import com.celsia.test.domain.ServiceClient;
import com.celsia.test.domain.repository.ServiceRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceClient> getAll() {
        return serviceRepository.getAll();
    }

    public Optional<List<ServiceClient>> findByIdClient(String clientId) {
        return serviceRepository.findByIdClient(clientId);
    }

    public Optional<ServiceClient> findById(String identification) {
        return serviceRepository.findById(identification);
    }

    public ServiceClient save(ServiceClient service) {
        return serviceRepository.save(service);
    }

    public boolean deleteById(String identification) {
        return findById(identification).map(product -> {
            serviceRepository.deleteById(identification);
            return true;
        }).orElse(false);
    }

}
