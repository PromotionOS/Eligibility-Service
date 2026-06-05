CREATE TABLE IF NOT EXISTS eligibility_rules (
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

CREATE TABLE IF NOT EXISTS exclusions (
    id          BIGSERIAL    PRIMARY KEY,
    rule_id     UUID         NOT NULL REFERENCES eligibility_rules (id) ON DELETE CASCADE,
    category_id VARCHAR(255),
    upc_code    VARCHAR(50),
    reason      VARCHAR(500)
);

CREATE INDEX IF NOT EXISTS idx_eligibility_rules_tenant_active ON eligibility_rules (tenant_id, active);
CREATE INDEX IF NOT EXISTS idx_eligibility_rules_campaign ON eligibility_rules (campaign_id, tenant_id);

INSERT INTO eligibility_rules
    (id, campaign_id, tenant_id, stack_limit, segment_restriction, active, date_start, date_end)
VALUES
    ('a1b2c3d4-e5f6-7890-abcd-ef1234567890',
     'c1d2e3f4-a5b6-7890-cdef-123456789012',
     'tenant-kroger-001', 1, 'PLATINUM', TRUE, '2024-01-01', '2024-12-31'),

    ('b2c3d4e5-f6a7-8901-bcde-f12345678901',
     'c2d3e4f5-a6b7-8901-cdef-234567890123',
     'tenant-kroger-001', 2, 'GOLD', TRUE, '2024-01-01', '2024-12-31')
ON CONFLICT (id) DO NOTHING;
