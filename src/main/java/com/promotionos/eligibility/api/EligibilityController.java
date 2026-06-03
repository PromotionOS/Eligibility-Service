package com.promotionos.eligibility.api;

import com.promotionos.eligibility.api.dto.AuditLogEntry;
import com.promotionos.eligibility.api.dto.EligibilityCheckRequest;
import com.promotionos.eligibility.api.dto.OffersResponse;
import com.promotionos.eligibility.application.EligibilityApplicationService;
import com.promotionos.eligibility.common.NotImplementedException;
import com.promotionos.eligibility.domain.model.EligibilityResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EligibilityController {

    private final EligibilityApplicationService eligibilityService;

    @PostMapping("/eligibility/check")
    public ResponseEntity<EligibilityResult> check(@RequestBody EligibilityCheckRequest request) {
        // TODO Team 2 Sprint 1
        throw new NotImplementedException("Eligibility check not implemented");
    }

    @GetMapping("/offers")
    public ResponseEntity<OffersResponse> getOffers(
            @RequestParam String tenantId,
            @RequestParam UUID customerId,
            @RequestParam(defaultValue = "0") double cartTotal) {
        // TODO Team 2 Sprint 2
        throw new NotImplementedException("Get offers not implemented");
    }

    @GetMapping("/eligibility/audit")
    public ResponseEntity<List<AuditLogEntry>> getAudit(
            @RequestParam String campaignId,
            @RequestParam String tenantId) {
        // TODO Team 2 Sprint 3
        throw new NotImplementedException("Audit log not implemented");
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
