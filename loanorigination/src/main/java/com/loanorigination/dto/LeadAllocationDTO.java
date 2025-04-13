package com.loanorigination.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeadAllocationDTO {

    private Long id;

    private Long leadId;

    private Long agentId;

    private LocalDateTime allocatedAt;
}
