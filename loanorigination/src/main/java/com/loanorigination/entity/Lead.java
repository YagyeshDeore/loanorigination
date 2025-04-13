package com.loanorigination.entity;

import jakarta.persistence.*;
        import lombok.*;

        import java.sql.Timestamp;

@Entity
@Table(name = "leads")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String full_name;
    private String email;
    private String phone;
    private String source;
    private String status;
    private Timestamp created_at;
}
