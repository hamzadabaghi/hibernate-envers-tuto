package com.hibernateenverstuto.repository;

import com.hibernateenverstuto.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepo extends JpaRepository<Opportunity, Long> {
}
