package com.promotionos.eligibility.domain.model;

import lombok.Value;
import java.util.List;
import java.util.UUID;

@Value
public class CustomerProfile {
    UUID customerId;
    String loyaltyTier;
    List<String> segments;
    String division;
    double annualSpend;
}
