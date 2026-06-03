package com.promotionos.eligibility.infrastructure.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promotionos.eligibility.application.EligibilityApplicationService;
import com.promotionos.eligibility.application.dto.CampaignPublishedEvent;
import com.promotionos.eligibility.common.NotImplementedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CampaignPublishedConsumer implements MessageListener {

    private final EligibilityApplicationService eligibilityService;
    private final ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            CampaignPublishedEvent event = objectMapper.readValue(message.getBody(), CampaignPublishedEvent.class);
            eligibilityService.loadRules(event);
        } catch (NotImplementedException e) {
            log.debug("Skeleton stub: loadRules not yet implemented");
        } catch (Exception e) {
            log.error("Failed to process CampaignPublished event", e);
        }
    }
}
