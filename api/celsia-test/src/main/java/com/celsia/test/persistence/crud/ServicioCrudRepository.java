package com.celsia.test.persistence.crud;

import com.celsia.test.persistence.entity.Servicio;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author
 */
public interface ServicioCrudRepository extends CrudRepository<Servicio, String>{
    
    @Modifying
    @Query(value = "SELECT * FROM SERVICIOS WHERE IDENTIFICACION = ? ORDER BY FECHAINICIO ASC", nativeQuery = true)
    Optional<List<Servicio>> findByIdentificacion(String clientId);
    
    Optional<List<Servicio>> findByIdentificacionOrderByFechaInicioAsc(String identificacion);
        
    @Modifying
    @Query(value = "DELETE FROM SERVICIOS WHERE IDENTIDFICACION = ? AND SERVICIO = ?", nativeQuery = true)
    void deleteService(String identification, String service);
}
