package com.loanorigination.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "underwriting_results")
public class UnderWritingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long loanApplicationId; // Reference to loan application

    @Column(nullable = false)
    private boolean approved;

    @Column(nullable = false)
    private String reasoning;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date updatedAt;

}
