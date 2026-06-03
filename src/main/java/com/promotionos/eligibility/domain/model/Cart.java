package com.promotionos.eligibility.domain.model;

import lombok.Value;
import java.util.List;

@Value
public class Cart {
    double total;
    List<String> upcCodes;
}
