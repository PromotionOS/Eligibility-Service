package com.promotionos.eligibility.infrastructure.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promotionos.eligibility.application.EligibilityApplicationService;
import com.promotionos.eligibility.application.dto.CampaignPausedEvent;
import com.promotionos.eligibility.common.NotImplementedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CampaignPausedConsumer implements MessageListener {

    private final EligibilityApplicationService eligibilityService;
    private final ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            CampaignPausedEvent event = objectMapper.readValue(message.getBody(), CampaignPausedEvent.class);
            eligibilityService.removeRules(event.getCampaignId(),
                com.promotionos.eligibility.domain.model.TenantId.of(event.getTenantId()));
        } catch (NotImplementedException e) {
            log.debug("Skeleton stub: removeRules not yet implemented");
        } catch (Exception e) {
            log.error("Failed to process CampaignPaused event", e);
        }
    }
}
