package com.promotionos.eligibility;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class EligibilityContractTest {

    @MockBean
    RedisConnectionFactory redisConnectionFactory;

    @Test
    @Disabled("TODO Team 2 Sprint 1: implement segment matching")
    void goldCustomerRejectedFromPlatinumCampaign() {
        // Scenario 2 — must return SEGMENT_MISMATCH
    }

    @Test
    @Disabled("TODO Team 2 Sprint 1: implement segment matching")
    void platinumCustomerQualifiesForPlatinumCampaign() {
        // Scenario 3 — must return eligible: true
    }

    @Test
    @Disabled("TODO Team 2 Sprint 2: implement paused campaign filter")
    void pausedCampaignNotServed() {
        // Scenario 11 — must not appear in offers response
    }

    @Test
    @Disabled("TODO Team 2 Sprint 2: implement scheduled campaign filter")
    void scheduledCampaignNotServed() {
        // Scenario 12 — must not appear in offers response
    }
}
