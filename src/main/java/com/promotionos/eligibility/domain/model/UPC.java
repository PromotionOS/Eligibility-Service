package com.promotionos.eligibility.domain.model;

import lombok.Value;

@Value
public class UPC {
    String code;

    public static UPC of(String code) {
        return new UPC(code);
    }
}
