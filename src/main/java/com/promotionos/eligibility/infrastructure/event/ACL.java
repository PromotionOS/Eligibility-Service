package com.promotionos.eligibility.infrastructure.event;

import com.promotionos.eligibility.application.dto.CampaignPublishedEvent;
import com.promotionos.eligibility.common.NotImplementedException;
import com.promotionos.eligibility.domain.model.EligibilityRule;
import org.springframework.stereotype.Component;

@Component
public class ACL {

    public EligibilityRule translate(CampaignPublishedEvent event) {
        // TODO Team 2 Sprint 1: translate CampaignPublished fields into EligibilityRule
        // payload.stackLimit → rule.stackLimit
        // payload.segmentRestriction → rule.segmentRestriction
        // payload.exclusions → rule.exclusions (list of Exclusion value objects)
        // payload.geoScope → rule.geoScope
        // payload.dateStart/dateEnd → rule.dateStart/dateEnd
        throw new NotImplementedException("ACL translation not implemented");
    }
}
