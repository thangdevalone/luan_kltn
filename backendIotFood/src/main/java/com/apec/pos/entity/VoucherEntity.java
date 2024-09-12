package com.apec.pos.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoucherEntity extends BaseEntity{
    private Integer discount;
    private LocalDate expired;
    private String detail;
    private String code;
    private Integer quantity;
    private String title;

}
