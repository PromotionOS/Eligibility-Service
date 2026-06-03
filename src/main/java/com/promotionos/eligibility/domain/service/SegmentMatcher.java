package com.promotionos.eligibility.domain.service;

import com.promotionos.eligibility.domain.model.CustomerProfile;

public interface SegmentMatcher {
    boolean matches(CustomerProfile customer, String segmentRestriction);
}
