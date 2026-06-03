package com.promotionos.eligibility.domain.repository;

import com.promotionos.eligibility.domain.model.EligibilityRule;
import com.promotionos.eligibility.domain.model.TenantId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EligibilityRuleRepository {
    List<EligibilityRule> findActive(TenantId tenantId);
    Optional<EligibilityRule> findByCampaignId(UUID campaignId, TenantId tenantId);
    EligibilityRule save(EligibilityRule rule);
    void deactivate(UUID campaignId, TenantId tenantId);
}
