package com.example.designpatterns.ObserverDesignPattern.Application;

import com.example.designpatterns.ObserverDesignPattern.Observales.IphoneObservable;
import com.example.designpatterns.ObserverDesignPattern.Observales.StockObservable;
import com.example.designpatterns.ObserverDesignPattern.Observers.EmailObserver;
import com.example.designpatterns.ObserverDesignPattern.Observers.MainObserver;
import com.example.designpatterns.ObserverDesignPattern.Observers.MobileObserver;

public class StockApplication {

    public static void main(String[] args) {

        StockObservable iphoneStockObservable = new IphoneObservable();

        MainObserver emailObserver = new EmailObserver("xyz@gmail.com");
        MainObserver emailObserver1 = new EmailObserver("xyz@gmail.com");
        MainObserver mobileObserver = new MobileObserver("7890765456");

        iphoneStockObservable.add(emailObserver);
        iphoneStockObservable.add(emailObserver1);
        iphoneStockObservable.add(mobileObserver);

        iphoneStockObservable.setStockCount(10);

    }


}
