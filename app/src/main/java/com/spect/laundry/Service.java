package com.spect.laundry;

public class Service {
    private String serviceName;
    private String serviceQty;

    public Service(String serviceName, String serviceQty) {
        this.serviceName = serviceName;
        this.serviceQty = serviceQty;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceQty() {
        return serviceQty;
    }

    public void setServiceQty(String serviceQty) {
        this.serviceQty = serviceQty;
    }
}
