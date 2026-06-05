package com.promotionos.eligibility.domain.service;

import com.promotionos.eligibility.domain.model.CustomerProfile;
import org.springframework.stereotype.Component;

@Component
public class DefaultSegmentMatcher implements SegmentMatcher {

    @Override
    public boolean matches(CustomerProfile customer, String segmentRestriction) {
        if (segmentRestriction == null || segmentRestriction.isBlank()) {
            return true;
        }
        return customer != null
            && customer.getSegments() != null
            && customer.getSegments().contains(segmentRestriction);
    }
}
