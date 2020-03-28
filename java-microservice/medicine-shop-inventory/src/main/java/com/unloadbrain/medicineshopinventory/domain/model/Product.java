package com.unloadbrain.medicineshopinventory.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseEntity {

    @NotBlank
    @Length(max = 30)
    @Column(length = 30)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal purchasePrice = BigDecimal.ZERO;

    private LocalDate expire;

    private BigDecimal stock = BigDecimal.ZERO;
}
