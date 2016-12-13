package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by joshfix on 12/13/16.
 */
@Component
@Slf4j
public class Demo {

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        String prop = env.getProperty("my.very.long.property");
        log.info("my.very.long.property value: " + prop);
    }
}
