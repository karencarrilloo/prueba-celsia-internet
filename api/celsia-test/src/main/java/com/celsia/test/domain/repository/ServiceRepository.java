package com.celsia.test.domain.repository;

import com.celsia.test.domain.ServiceClient;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author
 */
public interface ServiceRepository {
    
    List<ServiceClient> getAll();
    Optional<List<ServiceClient>> findByIdClient(String clientId);
    Optional<ServiceClient> findById(String identification);
    ServiceClient save(ServiceClient service);
    void deleteById(String serviceId);
    
}
