package com.ithillel.persistence.entity;

import com.ithillel.persistence.entity.util.CustomKeyConverter;

import javax.persistence.*;

@Embeddable
public class ClientCommonInfo {

    @Column(name = "client_type")
    @Enumerated(value = EnumType.STRING)
    private ClientType clientType;

    @Column(name = "description")
    @Convert(converter = CustomKeyConverter.class)
    private String additionInfo;

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getDescription() {
        return additionInfo;
    }

    public void setDescription(String description) {
        this.additionInfo = description;
    }
}
