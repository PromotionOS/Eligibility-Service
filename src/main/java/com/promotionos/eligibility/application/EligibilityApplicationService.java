package com.promotionos.eligibility.application;

import com.promotionos.eligibility.application.dto.CampaignPublishedEvent;
import com.promotionos.eligibility.application.dto.CatalogItemExcludedEvent;
import com.promotionos.eligibility.common.NotImplementedException;
import com.promotionos.eligibility.domain.model.Cart;
import com.promotionos.eligibility.domain.model.EligibilityResult;
import com.promotionos.eligibility.domain.model.TenantId;
import com.promotionos.eligibility.domain.repository.EligibilityRuleRepository;
import com.promotionos.eligibility.domain.service.RuleEngine;
import com.promotionos.eligibility.domain.service.SegmentMatcher;
import com.promotionos.eligibility.infrastructure.client.CatalogServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EligibilityApplicationService {

    private final EligibilityRuleRepository ruleRepository;
    private final RuleEngine ruleEngine;
    private final SegmentMatcher segmentMatcher;
    private final CatalogServiceClient catalogClient;

    public EligibilityResult check(UUID campaignId, TenantId tenantId, UUID customerId, Cart cart) {
        // TODO Team 2 Sprint 1: implement segment matching + status filter
        // TODO Team 2 Sprint 2: add exclusions, threshold, geo, stack
        throw new NotImplementedException("Eligibility check not implemented");
    }

    public List<EligibilityResult> getOffers(TenantId tenantId, UUID customerId, Cart cart) {
        // TODO Team 2 Sprint 2: implement GET /offers
        throw new NotImplementedException("Get offers not implemented");
    }

    public void loadRules(CampaignPublishedEvent event) {
        // TODO Team 2 Sprint 1: implement ACL translation + rule loading
        throw new NotImplementedException("Load rules not implemented");
    }

    public void removeRules(UUID campaignId, TenantId tenantId) {
        // TODO Team 2 Sprint 1: implement rule removal on CampaignPaused
        throw new NotImplementedException("Remove rules not implemented");
    }

    public void updateExclusions(CatalogItemExcludedEvent event) {
        // TODO Team 2 Sprint 2: implement exclusion update
        throw new NotImplementedException("Update exclusions not implemented");
    }
}
