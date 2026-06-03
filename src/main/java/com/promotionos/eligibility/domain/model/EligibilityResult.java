package com.promotionos.eligibility.domain.model;

import lombok.Value;
import java.math.BigDecimal;
import java.util.UUID;

@Value
public class EligibilityResult {
    boolean eligible;
    UUID campaignId;
    String offerType;
    BigDecimal discountApplied;
    String reason;

    public static EligibilityResult eligible(UUID campaignId, String offerType, BigDecimal discount) {
        return new EligibilityResult(true, campaignId, offerType, discount, null);
    }

    public static EligibilityResult ineligible(UUID campaignId, String reason) {
        return new EligibilityResult(false, campaignId, null, null, reason);
    }
}
