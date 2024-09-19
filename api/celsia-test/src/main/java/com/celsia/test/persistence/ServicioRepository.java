package com.celsia.test.persistence;

import com.celsia.test.domain.ServiceClient;
import com.celsia.test.domain.repository.ServiceRepository;
import com.celsia.test.persistence.crud.ServicioCrudRepository;
import com.celsia.test.persistence.entity.Servicio;
import com.celsia.test.persistence.mapper.ServiceMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author
 */
@Repository
public class ServicioRepository implements ServiceRepository {

    @Autowired
    private ServicioCrudRepository servicioCrudRepository;

    @Autowired
    private ServiceMapper mapper;

    @Override
    public List<ServiceClient> getAll() {
        return mapper.toServices((List<Servicio>) servicioCrudRepository.findAll());
    }

    @Override
    public Optional<List<ServiceClient>> findByIdClient(String clientId) {
        return servicioCrudRepository.findByIdentificacion(clientId)
                .map(servicios -> mapper.toServices(servicios));
    }

    @Override
    public Optional<ServiceClient> findById(String identification) {
        Optional<Servicio> servicio = servicioCrudRepository.findById(identification);
        return servicio.map(serv -> mapper.toService(serv));
    }

    @Override
    public ServiceClient save(ServiceClient service) {
        Servicio servicio = mapper.toServicio(service);
        return mapper.toService(servicioCrudRepository.save(servicio));
    }

    @Override
    public void deleteById(String serviceId) {
        servicioCrudRepository.deleteById(serviceId);
    }

}
