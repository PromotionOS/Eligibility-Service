package com.promotionos.eligibility.api.dto;

import lombok.Value;
import java.time.Instant;
import java.util.UUID;

@Value
public class AuditLogEntry {
    UUID id;
    UUID campaignId;
    UUID customerId;
    String action;
    Instant timestamp;
}
