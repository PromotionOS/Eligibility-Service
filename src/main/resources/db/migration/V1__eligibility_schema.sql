CREATE TABLE eligibility_rules (
    id            UUID         PRIMARY KEY,
    campaign_id   UUID         NOT NULL,
    tenant_id     VARCHAR(255) NOT NULL,
    stack_limit   INT          NOT NULL DEFAULT 1,
    segment_restriction VARCHAR(255),
    geo_scope     TEXT[],
    threshold_type VARCHAR(50),
    spend_value   DECIMAL(10, 2),
    quantity_value INT,
    active        BOOLEAN      NOT NULL DEFAULT TRUE,
    date_start    DATE,
    date_end      DATE,
    created_at    TIMESTAMP    NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE TABLE exclusions (
    id          BIGSERIAL    PRIMARY KEY,
    rule_id     UUID         NOT NULL REFERENCES eligibility_rules (id) ON DELETE CASCADE,
    category_id VARCHAR(255),
    upc_code    VARCHAR(50),
    reason      VARCHAR(500)
);

CREATE INDEX idx_eligibility_rules_tenant_active ON eligibility_rules (tenant_id, active);
CREATE INDEX idx_eligibility_rules_campaign       ON eligibility_rules (campaign_id, tenant_id);
