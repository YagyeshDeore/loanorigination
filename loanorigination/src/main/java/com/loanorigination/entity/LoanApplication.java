package com.loanorigination.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loan_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;

    private String loanType;

    private Double amount;

    @Column(name = "status")
    private String status;

    @OneToOne(mappedBy = "loanApplication", cascade = CascadeType.ALL)
    private Document document;

    // Add other relationships if needed
}
