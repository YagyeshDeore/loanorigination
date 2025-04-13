package com.loanorigination.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "credit_scores")
public class CreditScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long leadId;  // Or reference to loan application if necessary

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private Date checkedAt;

    // Constructor, getters, and setters are handled by Lombok annotations
}
