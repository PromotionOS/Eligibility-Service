package com.promotionos.eligibility.infrastructure.client;

import com.promotionos.eligibility.common.NotImplementedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CampaignServiceClient {

    @Value("${promotionos.services.campaign-url}")
    private String campaignUrl;

    public boolean isCampaignActive(String campaignId, String tenantId) {
        throw new NotImplementedException("CampaignServiceClient.isCampaignActive not implemented");
    }
}
