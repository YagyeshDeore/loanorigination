package com.loanorigination.dto;

import lombok.*;
        import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeadDTO {
    private Long id;
    private String full_name;
    private String email;
    private String phone;
    private String source;
    private String status;
    private Timestamp created_at;
}
