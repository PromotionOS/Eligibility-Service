package com.promotionos.eligibility.api.dto;

import com.promotionos.eligibility.domain.model.Cart;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class EligibilityCheckRequest {
    private UUID campaignId;
    private String tenantId;
    private UUID customerId;
    private Cart cart;
}
