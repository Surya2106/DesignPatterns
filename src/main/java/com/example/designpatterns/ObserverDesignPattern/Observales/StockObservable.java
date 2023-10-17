package com.example.designpatterns.ObserverDesignPattern.Observales;

import com.example.designpatterns.ObserverDesignPattern.Observers.MainObserver;

public interface StockObservable {

    public void add(MainObserver mainObserver);

    public void remove(MainObserver mainObserver);

    public void notifyObservers();

    public void setStockCount(int stock);
}
