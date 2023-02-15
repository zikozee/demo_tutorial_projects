package com.ezekiel.dockerk8s.controller;


import com.ezekiel.dockerk8s.dto.SampleDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Currency;


/**
 * @author: Ezekiel Eromosei
 * @created: 24 November 2022
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "tutorial")
public class DockerK8sController {
    public static final String LOGGER_EVENT = "DEMO_EVENT";

    private final Environment env;

    @Value("${demo.company.name}")
    public String company;

    @GetMapping
    public ResponseEntity<SampleDetails> getJacksonDetails(){

        String name = env.getProperty("demo.name");
        boolean isCompanyAwesome = Boolean.TRUE.equals(env.getProperty("demo.company.awesome", Boolean.class));
        String url = env.getProperty("demo.company.url");

        log.info("Event={}, id={}, name={}, company={}", LOGGER_EVENT, java.util.UUID.randomUUID(), name, company);

        SampleDetails sampleDetails = SampleDetails.builder()
                .age(54)
                .name(name)
                .nationality("Nigeria")
                .religion(company)
                .isLazy(false)
                .learningK8s(true)
                .data(SampleDetails.SampleData.builder()
                        .tutorial("Devops Deployment Simplified")
                        .money(new BigDecimal(10000))
                        .currency(Currency.getInstance("NGN"))
                        .companyName(company)
                        .companyAwesome(isCompanyAwesome)
                        .companyUrl(url)
                        .build())
                .build();

        return new ResponseEntity<>(sampleDetails, HttpStatus.OK);

    }
}
