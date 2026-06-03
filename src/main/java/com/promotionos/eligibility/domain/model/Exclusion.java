package com.promotionos.eligibility.domain.model;

import lombok.Value;

@Value
public class Exclusion {
    String categoryId;
    String upcCode;
    String reason;
}
