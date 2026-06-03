package com.promotionos.eligibility.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogItemExcludedEvent {
    private String upcCode;
    private String categoryId;
    private String reason;
    private String tenantId;
}
