package com.promotionos.eligibility.domain.model;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class Threshold {
    ThresholdType type;
    BigDecimal spendValue;
    Integer quantityValue;
}
