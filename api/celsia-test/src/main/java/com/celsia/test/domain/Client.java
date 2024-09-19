package com.celsia.test.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author
 */
public class Client {
    
    private String identification;
    private String name;
    private String lastName;
    private String identificationType;
    private LocalDateTime birthDate;
    private String cellphone;
    private String email;
//    private List<Service> Service;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Service> getService() {
//        return Service;
//    }
//
//    public void setService(List<Service> Service) {
//        this.Service = Service;
//    }
    
}
