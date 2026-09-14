package com.learning.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigController {

    @Autowired
    private CurrencyServiceConfig config;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfig retrieveAllCourses() {
        return config;
    }
}
