package com.hibernateenverstuto.controller;

import com.hibernateenverstuto.model.Opportunity;
import com.hibernateenverstuto.repository.OpportunityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import static com.hibernateenverstuto.utils.Constants.OPPORTUNITIES_ENDPOINT;
import static org.springframework.http.HttpStatus.OK;

/**
 * This controller describes the entry points to test hibernate envers
 * in a practical scenario.
 */

@Controller
@RequiredArgsConstructor
@RequestMapping(OPPORTUNITIES_ENDPOINT)
public class OpportunityController {
    /**
     * OpportunityRepo dependency
     */
    private final OpportunityRepo opportunityRepo;

    /**
     * getOpportunities() : get all opportunities.
     * @return List<Opportunity> : a list of opportunities.
     */
    @GetMapping
    public ResponseEntity<List<Opportunity>> getOpportunities() {
         return new ResponseEntity<>(this.opportunityRepo.findAll(), OK);
    }

    /**
     * createOpportunity() : create an opportunity.
     * @param opportunity : opportunity to create.
     * @return ResponseEntity<Opportunity> : created opportunity.
     */

    @PostMapping
    public ResponseEntity<Opportunity> createOpportunity(@RequestBody Opportunity opportunity) {
        return new ResponseEntity<>(this.opportunityRepo.save(opportunity), OK);
    }
}
