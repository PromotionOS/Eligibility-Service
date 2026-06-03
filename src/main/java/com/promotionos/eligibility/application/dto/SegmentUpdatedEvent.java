package com.promotionos.eligibility.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class SegmentUpdatedEvent {
    private UUID customerId;
    private List<String> segments;
    private String tenantId;
}
