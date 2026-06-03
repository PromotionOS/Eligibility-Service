package com.promotionos.eligibility.domain.model;

import lombok.Value;

@Value
public class TenantId {
    String value;

    public static TenantId of(String value) {
        return new TenantId(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
