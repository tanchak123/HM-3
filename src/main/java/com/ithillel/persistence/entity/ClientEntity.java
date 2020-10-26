package com.ithillel.persistence.entity;

import com.ithillel.persistence.entity.util.CustomLongTimeConverter;
import com.ithillel.persistence.entity.util.CustomUUIDCreator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_client", allocationSize = 1)
public class ClientEntity extends CommonEntity {

    public ClientEntity() {}

    @Column(name = "name")
    private String fullname;

//    @ManyToOne
////    @JoinColumn(name = "acc_id")
//    private AccountEntity account;

    @Column(name = "uuid")
    @CustomUUIDCreator
    private String customUUID;

    @Column(name = "update_date")
    @Convert(converter = CustomLongTimeConverter.class)
    private Long updateDate;

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    /* @Column(name = "create_timestamtp")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createTimestamp;*/
/*
    @Column(name = "create_time")
    private Instant createTime;*/

    @Column(name = "have_access")
    //@Type(type = "org.hibernate.type.NumericBooleanType")
    //@Type(type = "org.hibernate.type.TrueFalseType")
    private boolean haveAccess;

    @Embedded
    @AttributeOverride(name = "additionInfo",column = @Column(name = "descp"))
    private ClientCommonInfo clientCommonInfo;

    public void setClientCommonInfo(ClientCommonInfo clientCommonInfo) {
        this.clientCommonInfo = clientCommonInfo;
    }

    @OneToMany(mappedBy = "client")
    private List<ClientInfoEntity> clientInfos = new ArrayList<>();

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


   /* public Calendar getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Calendar createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }*/

    public boolean isHaveAccess() {
        return haveAccess;
    }

    public void setHaveAccess(boolean haveAccess) {
        this.haveAccess = haveAccess;
    }

    /*
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "create_timestamp")
    private ZonedDateTime createTimestamp; */

//    public AccountEntity getAccount() {
//        return account;
//    }
//
//    public void setAccount(AccountEntity account) {
//        this.account = account;
//    }


    public String getCustomUUID() {
        return customUUID;
    }

    public void setCustomUUID(String customUUID) {
        this.customUUID = customUUID;
    }

    public ClientCommonInfo getClientCommonInfo() {
        return clientCommonInfo;
    }

    public List<ClientInfoEntity> getClientInfos() {
        return clientInfos;
    }

    public void setClientInfos(List<ClientInfoEntity> clientInfos) {
        this.clientInfos = clientInfos;
    }
}
