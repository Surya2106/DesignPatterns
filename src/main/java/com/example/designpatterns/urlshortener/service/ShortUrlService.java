package com.example.designpatterns.urlshortener.service;

import com.example.designpatterns.urlshortener.entity.Url;

import java.util.HashMap;
import java.util.Map;

import static com.example.designpatterns.urlshortener.Constants.INVALID_SHORT_URL;
import static com.example.designpatterns.urlshortener.Constants.SHORT_URL_GENERATED_SUCCESSFULLY;

public class ShortUrlService {

    private Map<String, String> mapShortUrlToLongUrl;
    private Map<String, String> mapLongUrlToShortUrl;
    private ShortUrlGeneratorLogic shortUrlGeneratorLogic;

    public ShortUrlService(final ShortUrlGeneratorLogic shortUrlGeneratorLogic) {
        this.shortUrlGeneratorLogic = shortUrlGeneratorLogic;
        this.mapShortUrlToLongUrl = new HashMap<>();
        this.mapLongUrlToShortUrl = new HashMap<>();
    }

    public String createShortURL(final String longUrl) {
        if(mapLongUrlToShortUrl.containsKey(longUrl)) {
            System.out.println("Entered LONG URL already has a mapping to one short URL");
            return mapLongUrlToShortUrl.get(longUrl);
        }

        String shortenedUrl = shortUrlGeneratorLogic.generateShortUrl();
        mapLongUrlToShortUrl.put(longUrl, shortenedUrl);
        mapShortUrlToLongUrl.put(shortenedUrl, longUrl);
        System.out.println(SHORT_URL_GENERATED_SUCCESSFULLY + " : " + shortenedUrl);
        return shortenedUrl;
    }

    public String redirectToLongUrl(final String shortUrl) {
        if(mapShortUrlToLongUrl.containsKey(shortUrl)) {
            System.out.println("Redirecting to the below mentioned URL!!");
            return mapShortUrlToLongUrl.get(shortUrl);
        }

        System.out.println(INVALID_SHORT_URL);
        return INVALID_SHORT_URL;
    }

}
