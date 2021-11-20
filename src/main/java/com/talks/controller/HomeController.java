package com.talks.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author snaredl
 *
 */
@RestController
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public String home(final Locale locale) {
        LOGGER.info("Welcome home! The client locale is {}.", locale);
        return "WEBAPP-OK";
    } 
}
