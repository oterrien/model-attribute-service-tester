package com.ote.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping
@Slf4j
public class TestRestController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Filter test(@ModelAttribute Filter filter) {
        return filter;
    }

    @GetMapping(value = "/test2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Filter2.Name> test2(@ModelAttribute Filter2 filter) {
        Set<Filter2.Name> newFilter = filter.getFilter();
        log.warn(newFilter.toString());
        return newFilter;
    }
}
