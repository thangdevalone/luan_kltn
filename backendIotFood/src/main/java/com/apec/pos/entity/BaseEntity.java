package com.apec.pos.entity;

import java.util.Date;
import java.util.List;


import com.apec.pos.PosApplication;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @JsonIgnore
    @Column(name = "create_by")
    private String createBy;

//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(name = "log_table", joinColumns = @JoinColumn(name = "log_id"))
//    @JsonIgnore
//    private List<LogElement> logs;

    @Column
    private Boolean status;

    // Constructors, getters, and setters (you can generate them automatically or write them manually)

    // Constructor with createBy and modifiedBy arguments
    public BaseEntity(String createBy, String modifiedBy) {
        this.createDate = new Date();
//        this.createBy = createBy;
    }


    public Boolean getStatus() {
        return status;
    }


    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }


    // Custom method to update modified date and modified by
    @PreUpdate
    protected void onUpdate() {
//        LogElement logElement=new LogElement();
//        logElement.setUrl(PosApplication.currentUrlGlobal);
//        logElement.setModifiedBy(PosApplication.currentUserGlobal);
//        logElement.setModifiedDate(new Date());
//        this.logs.add(logElement)
    }


    @PrePersist
    protected void onCreate() {
        this.status = true;
        this.createDate = new Date();
        this.createBy = PosApplication.currentUserGlobal;
    }
}
