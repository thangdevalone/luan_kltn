package com.apec.pos.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
public class LogElement {

    private Date modifiedDate;
    private String modifiedBy;
    private String url;
}
