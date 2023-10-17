package com.example.designpatterns.ObserverDesignPattern.Observers;

public class MobileObserver implements MainObserver {


    public MobileObserver(String email) {
    }

    @Override
    public void update() {
        System.out.println("message send to mobile");
    }
}
