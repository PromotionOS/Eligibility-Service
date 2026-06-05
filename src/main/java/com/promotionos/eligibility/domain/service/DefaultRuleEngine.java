package com.promotionos.eligibility.domain.service;

import com.promotionos.eligibility.domain.model.Cart;
import com.promotionos.eligibility.domain.model.CustomerProfile;
import com.promotionos.eligibility.domain.model.EligibilityResult;
import com.promotionos.eligibility.domain.model.EligibilityRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DefaultRuleEngine implements RuleEngine {

    private final SegmentMatcher segmentMatcher;

    @Override
    public EligibilityResult evaluate(EligibilityRule rule, CustomerProfile customer, Cart cart) {
        if (rule == null || !rule.isActive()) {
            return EligibilityResult.ineligible(rule == null ? null : rule.getCampaignId(), "RULE_INACTIVE");
        }
        if (!segmentMatcher.matches(customer, rule.getSegmentRestriction())) {
            return EligibilityResult.ineligible(rule.getCampaignId(), "SEGMENT_MISMATCH");
        }
        return EligibilityResult.eligible(rule.getCampaignId(), null, BigDecimal.ZERO);
    }
}
