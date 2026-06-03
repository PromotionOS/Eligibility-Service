package com.promotionos.eligibility.infrastructure.repository;

import com.promotionos.eligibility.common.NotImplementedException;
import com.promotionos.eligibility.domain.model.EligibilityRule;
import com.promotionos.eligibility.domain.model.TenantId;
import com.promotionos.eligibility.domain.repository.EligibilityRuleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EligibilityRuleRepositoryImpl implements EligibilityRuleRepository {

    @Override
    public List<EligibilityRule> findActive(TenantId tenantId) {
        throw new NotImplementedException("findActive not implemented");
    }

    @Override
    public Optional<EligibilityRule> findByCampaignId(UUID campaignId, TenantId tenantId) {
        throw new NotImplementedException("findByCampaignId not implemented");
    }

    @Override
    public EligibilityRule save(EligibilityRule rule) {
        throw new NotImplementedException("save not implemented");
    }

    @Override
    public void deactivate(UUID campaignId, TenantId tenantId) {
        throw new NotImplementedException("deactivate not implemented");
    }
}
