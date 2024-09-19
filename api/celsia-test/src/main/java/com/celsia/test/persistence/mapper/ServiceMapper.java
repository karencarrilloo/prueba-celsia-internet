package com.celsia.test.persistence.mapper;

import com.celsia.test.domain.ServiceClient;
import com.celsia.test.persistence.entity.Servicio;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author
 */
@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface ServiceMapper {

    @Mappings({
        @Mapping(source = "identificacion", target = "identification"),
        @Mapping(source = "servicio", target = "service"),
        @Mapping(source = "fechaInicio", target = "startDate"),
        @Mapping(source = "ultimaFacturacion", target = "lastBilling"),
        @Mapping(source = "ultimoPago", target = "lastPay"),
        @Mapping(source = "cliente", target = "client"),
    })
    ServiceClient toService(Servicio servicio);
    List<ServiceClient> toServices(List<Servicio> servicio);
    
    @InheritInverseConfiguration
    Servicio toServicio(ServiceClient service);

}
