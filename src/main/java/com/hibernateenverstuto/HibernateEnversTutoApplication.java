package com.hibernateenverstuto;

import com.hibernateenverstuto.model.Opportunity;
import com.hibernateenverstuto.repository.OpportunityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
public class HibernateEnversTutoApplication implements CommandLineRunner {

    @Autowired
    OpportunityRepo opportunityRepo;
    public static void main(String[] args) {
        SpringApplication.run(HibernateEnversTutoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var opportunities = Stream.of(
                new Opportunity("Opportunity 1", "Description 1", 1_000_600L),
                new Opportunity("Opportunity 2", "Description 2", 3_500_000L),
                new Opportunity("Opportunity 3", "Description 3", 2_100_560L)
        ).collect(Collectors.toList());

        this.opportunityRepo.saveAll(opportunities);
    }

}
