package com.ezekiel.dockerk8s.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author: Ezekiel Eromosei
 * @created: 24 November 2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SampleDetails {
    private int age;
    private String name;
    private String nationality;
    private String religion;
    private boolean isLazy;
    private boolean learningK8s;
    private SampleData data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SampleData {

        private String tutorial;
        private BigDecimal money;
        private Currency currency;

        private String companyName;
        private String companyUrl;
        private boolean companyAwesome;

    }
}
