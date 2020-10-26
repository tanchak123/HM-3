package com.ithillel.persistence.entity;

import com.ithillel.persistence.entity.util.KeyCreator;
import com.ithillel.persistence.entity.util.PassWordKeyCreator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "account")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_account", allocationSize = 1)
public class AccountEntity extends CommonEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    @Convert(converter = PassWordKeyCreator.class)
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "client_account", joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
//    @JoinColumn(name = "acc_id")
    private List<ClientEntity> clients = new ArrayList<>();

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Calendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClientEntity> getClients() {
        return clients;
    }

    public void setClients(List<ClientEntity> clients) {
        this.clients = clients;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
