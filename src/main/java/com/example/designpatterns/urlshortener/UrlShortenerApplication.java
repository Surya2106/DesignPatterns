package com.example.designpatterns.urlshortener;

import com.example.designpatterns.urlshortener.service.RandomUrlGeneratorLogic;
import com.example.designpatterns.urlshortener.service.ShortUrlGeneratorLogic;
import com.example.designpatterns.urlshortener.service.ShortUrlService;

import java.util.Scanner;

public class UrlShortenerApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ShortUrlGeneratorLogic randomUrlGeneratorLogic = new RandomUrlGeneratorLogic();

        ShortUrlService shortUrlService = new ShortUrlService(randomUrlGeneratorLogic);

        System.out.println(" Hello Guys!! Welcome to URL shortner service!!\n" +
                "Please follow with the below options to continue with the app\n" +
                "1. Create short URL for the given long URL\n" +
                "2. Given short URL redirect me to long URL\n" +
                "3. Exit\n");

        while(true) {

            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    String longUrl = scanner.next();
                    shortUrlService.createShortURL(longUrl);
                }
                case 2 -> {
                    String shortUrl = scanner.next();
                    shortUrlService.redirectToLongUrl(shortUrl);
                }
                case 3 -> {
                }
            }
        }

    }
}
