package com.loanorigination.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sanctions")
public class Sanction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long loanApplicationId;

    @Column(nullable = false)
    private String sanctionedAmount;

    @Column(nullable = false)
    private Date sanctionDate;

    @Column(nullable = false)
    private String agreementStatus; // e.g., "Pending", "Signed", "Rejected"

    @Column
    private String remarks;
}
