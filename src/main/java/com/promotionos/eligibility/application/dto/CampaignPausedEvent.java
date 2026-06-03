package com.promotionos.eligibility.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CampaignPausedEvent {
    private UUID campaignId;
    private String tenantId;
}
