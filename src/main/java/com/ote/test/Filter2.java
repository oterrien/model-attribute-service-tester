package com.ote.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@NoArgsConstructor
public class Filter2 {

    private List<String> names;
    private List<String> operators;

    public Set<Name> getFilter() {
        if (names != null) {
            return IntStream.range(0, names.size()).
                    mapToObj(i -> {
                        Name name = new Name();
                        name.value = names.get(i);
                        if (operators != null && operators.size() > i) {
                            name.operator = Operator.valueOf(operators.get(i));
                        }
                        return name;
                    }).
                    collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(of = "value")
    public static class Name {
        private String value;
        private Operator operator = Operator.DIFFERENT;
    }

    enum Operator {
        EQUALS, DIFFERENT
    }
}
