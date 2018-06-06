package com.ote.test;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Filter {

    private Name name;

    @Data
    @NoArgsConstructor
    public static class Name {
        private String value;
        private Operator operator;
    }

    enum Operator {
        EQUALS, DIFFERENT
    }

}
