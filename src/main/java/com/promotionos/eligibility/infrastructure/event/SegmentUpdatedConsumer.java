package com.promotionos.eligibility.infrastructure.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promotionos.eligibility.application.dto.SegmentUpdatedEvent;
import com.promotionos.eligibility.common.NotImplementedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SegmentUpdatedConsumer implements MessageListener {

    private final ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            SegmentUpdatedEvent event = objectMapper.readValue(message.getBody(), SegmentUpdatedEvent.class);
            // TODO Team 2 Sprint 2: invalidate customer cache for event.getCustomerId()
            throw new NotImplementedException("SegmentUpdated handling not implemented");
        } catch (NotImplementedException e) {
            log.debug("Skeleton stub: SegmentUpdated not yet implemented");
        } catch (Exception e) {
            log.error("Failed to process SegmentUpdated event", e);
        }
    }
}
