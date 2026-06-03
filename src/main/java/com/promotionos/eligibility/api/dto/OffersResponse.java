package com.promotionos.eligibility.api.dto;

import com.promotionos.eligibility.domain.model.EligibilityResult;
import lombok.Value;
import java.util.List;

@Value
public class OffersResponse {
    List<EligibilityResult> offers;
}
