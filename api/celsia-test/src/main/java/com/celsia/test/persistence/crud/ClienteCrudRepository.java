package com.celsia.test.persistence.crud;

import com.celsia.test.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author
 */
public interface ClienteCrudRepository extends CrudRepository<Cliente, String>{
    
}
