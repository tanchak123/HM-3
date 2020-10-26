package com.ithillel.persistence.entity;

import com.ithillel.persistence.entity.util.CustomKeyConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client_info")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_client_info", allocationSize = 1)
public class ClientInfoEntity extends CommonEntity {

    @Column(name = "email")
    @Convert(converter = CustomKeyConverter.class)
    private String email;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private ClientEntity client;

}
