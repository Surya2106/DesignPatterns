package com.example.designpatterns.ObserverDesignPattern.Observers;

import com.example.designpatterns.ObserverDesignPattern.Observales.StockObservable;

public class EmailObserver implements MainObserver {


    public EmailObserver(String email) {
    }
    @Override
    public void update() {
        System.out.println("Mail send to email");
    }
}
