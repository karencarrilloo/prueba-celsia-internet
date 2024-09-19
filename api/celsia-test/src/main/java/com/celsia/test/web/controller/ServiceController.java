package com.celsia.test.web.controller;

import com.celsia.test.domain.ServiceClient;
import com.celsia.test.domain.service.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 */
@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/getAllServices")
    public ResponseEntity<List<ServiceClient>> getAll() {
        return new ResponseEntity<>(serviceService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/getServicesByClient")
    public ResponseEntity<List<ServiceClient>> findByIdClient(@RequestBody String clientId) {
        return serviceService.findByIdClient(clientId).map(
                clients -> new ResponseEntity<>(clients, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getServicesByclientIdAndName")
    public ResponseEntity<ServiceClient> findById(@RequestParam String identification) {
        return serviceService.findById(identification)
                .map(services -> new ResponseEntity<>(services, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveService")
    public ResponseEntity<ServiceClient> save(@RequestBody ServiceClient serviceClient) {
        return new ResponseEntity<>(serviceService.save(serviceClient), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteService")
    public ResponseEntity deleteById(@RequestBody String identification) {
        if (serviceService.deleteById(identification)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
