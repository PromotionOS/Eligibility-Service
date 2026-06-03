package com.promotionos.eligibility.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class EligibilityRule {
    private UUID id;
    private UUID campaignId;
    private TenantId tenantId;
    private int stackLimit;
    private String segmentRestriction;
    private List<String> geoScope = new ArrayList<>();
    private List<Exclusion> exclusions = new ArrayList<>();
    private Threshold threshold;
    private boolean active;
    private LocalDate dateStart;
    private LocalDate dateEnd;

    public static EligibilityRule create(UUID campaignId, TenantId tenantId) {
        EligibilityRule rule = new EligibilityRule();
        rule.id = UUID.randomUUID();
        rule.campaignId = campaignId;
        rule.tenantId = tenantId;
        rule.stackLimit = 1;
        rule.active = true;
        return rule;
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean isActiveOn(LocalDate date) {
        return this.active
            && !date.isBefore(this.dateStart)
            && !date.isAfter(this.dateEnd);
    }
}
