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
