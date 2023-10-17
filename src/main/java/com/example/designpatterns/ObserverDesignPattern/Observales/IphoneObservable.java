package com.example.designpatterns.ObserverDesignPattern.Observales;

import com.example.designpatterns.ObserverDesignPattern.Observers.MainObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable {

    private List<MainObserver> mainObserverList = new ArrayList<>();
    private int stockCount = 0;

    @Override
    public void add(MainObserver mainObserver) {
        mainObserverList.add(mainObserver);
    }

    @Override
    public void remove(MainObserver mainObserver) {
        mainObserverList.remove(mainObserver);
    }

    @Override
    public void notifyObservers() {

        for(MainObserver mainObserver : mainObserverList) {
            mainObserver.update();
        }
    }

    @Override
    public void setStockCount(int stock) {
        if(stockCount == 0)
            notifyObservers();
        stockCount += stock;

    }
}
