package com.promotionos.eligibility.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CampaignPublishedEvent {
    private UUID campaignId;
    private String tenantId;
    private int stackLimit;
    private String segmentRestriction;
    private List<String> geoScope;
    private List<ExclusionDto> exclusions;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String offerType;

    @Data
    @NoArgsConstructor
    public static class ExclusionDto {
        private String categoryId;
        private String upcCode;
        private String reason;
    }
}
