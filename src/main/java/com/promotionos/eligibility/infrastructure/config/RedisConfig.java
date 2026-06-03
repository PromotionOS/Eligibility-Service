package com.promotionos.eligibility.infrastructure.config;

import com.promotionos.eligibility.infrastructure.event.CampaignPausedConsumer;
import com.promotionos.eligibility.infrastructure.event.CampaignPublishedConsumer;
import com.promotionos.eligibility.infrastructure.event.CatalogItemExcludedConsumer;
import com.promotionos.eligibility.infrastructure.event.SegmentUpdatedConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {

    @Value("${promotionos.redis.channels.campaign-published}")
    private String campaignPublishedChannel;

    @Value("${promotionos.redis.channels.campaign-paused}")
    private String campaignPausedChannel;

    @Value("${promotionos.redis.channels.catalog-item-excluded}")
    private String catalogItemExcludedChannel;

    @Value("${promotionos.redis.channels.segment-updated}")
    private String segmentUpdatedChannel;

    private final CampaignPublishedConsumer campaignPublishedConsumer;
    private final CampaignPausedConsumer campaignPausedConsumer;
    private final CatalogItemExcludedConsumer catalogItemExcludedConsumer;
    private final SegmentUpdatedConsumer segmentUpdatedConsumer;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(campaignPublishedConsumer, new ChannelTopic(campaignPublishedChannel));
        container.addMessageListener(campaignPausedConsumer, new ChannelTopic(campaignPausedChannel));
        container.addMessageListener(catalogItemExcludedConsumer, new ChannelTopic(catalogItemExcludedChannel));
        container.addMessageListener(segmentUpdatedConsumer, new ChannelTopic(segmentUpdatedChannel));
        return container;
    }
}
