package com.promotionos.eligibility.infrastructure.client;

import com.promotionos.eligibility.common.NotImplementedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CatalogServiceClient {

    @Value("${promotionos.services.catalog-url}")
    private String catalogUrl;

    public boolean isItemExcluded(String upcCode, String tenantId) {
        throw new NotImplementedException("CatalogServiceClient.isItemExcluded not implemented");
    }
}
