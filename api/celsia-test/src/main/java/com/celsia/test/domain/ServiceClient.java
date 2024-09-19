package com.celsia.test.domain;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class ServiceClient {

    private String identification;
    private String service;
    private LocalDateTime startDate;
    private LocalDateTime lastBilling;
    private String lastPay;
    private Client client;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getLastBilling() {
        return lastBilling;
    }

    public void setLastBilling(LocalDateTime lastBilling) {
        this.lastBilling = lastBilling;
    }

    public String getLastPay() {
        return lastPay;
    }

    public void setLastPay(String lastPay) {
        this.lastPay = lastPay;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
