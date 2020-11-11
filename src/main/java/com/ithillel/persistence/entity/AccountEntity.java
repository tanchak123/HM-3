package com.ithillel.persistence.entity;

import com.ithillel.persistence.entity.util.PassWordKeyCreator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_account", allocationSize = 1)
public class AccountEntity extends CommonEntity {

    @Column(name = "name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(clients, that.clients) &&
                Objects.equals(calendar, that.calendar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clients, calendar);
    }
}
