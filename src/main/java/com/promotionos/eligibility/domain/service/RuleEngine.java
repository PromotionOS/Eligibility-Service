package com.promotionos.eligibility.domain.service;

import com.promotionos.eligibility.domain.model.Cart;
import com.promotionos.eligibility.domain.model.CustomerProfile;
import com.promotionos.eligibility.domain.model.EligibilityResult;
import com.promotionos.eligibility.domain.model.EligibilityRule;

public interface RuleEngine {
    EligibilityResult evaluate(EligibilityRule rule, CustomerProfile customer, Cart cart);
}
