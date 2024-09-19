package com.celsia.test.persistence.mapper;

import com.celsia.test.domain.Client;
import com.celsia.test.persistence.entity.Cliente;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

/**
 *
 * @author
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {
    
    @Mappings({
        @Mapping(source = "identificacion", target = "identification"),
        @Mapping(source = "nombres", target = "name"),
        @Mapping(source = "apellidos", target = "lastName"),
        @Mapping(source = "tipoIdentificacion", target = "identificationType"),
        @Mapping(source = "fechaNacimiento", target = "birthDate"),
        @Mapping(source = "numeroCelular", target = "cellphone"),
        @Mapping(source = "correoElectronico", target = "email"),
//        @Mapping(source = "servicios", target = "service"),
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> cliente);
    
    @InheritInverseConfiguration
    Cliente toCliente(Client Client);
    
}
