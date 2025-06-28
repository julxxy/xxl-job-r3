package com.xxl.job.admin.service.impl;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Slf4j
@Profile({"dev,local,feige"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class R3SupportServiceTest {
    private static final Logger log = LoggerFactory.getLogger(R3SupportServiceTest.class);

    static {
        System.setProperty("--spring.profiles.active", "feige");
    }

    @Autowired
    R3SupportService r3SupportService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void authenticateByLDAP() {
        boolean authenticate = r3SupportService.authenticateByLDAP("admin", "admin123");
        log.info("authenticateByLDAP:{}", authenticate);
    }
}
