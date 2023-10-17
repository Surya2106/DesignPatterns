package com.example.designpatterns.urlshortener.service;

import org.apache.commons.lang3.RandomStringUtils;

import static com.example.designpatterns.urlshortener.Constants.DEFAULT_DOMAIN_NAME;

public class RandomUrlGeneratorLogic implements ShortUrlGeneratorLogic{

    @Override
    public String generateShortUrl() {
        return DEFAULT_DOMAIN_NAME + "/" + RandomStringUtils.randomAlphanumeric(3, 100);
    }
}
