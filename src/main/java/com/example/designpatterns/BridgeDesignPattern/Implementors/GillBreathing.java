package com.example.designpatterns.BridgeDesignPattern.Implementors;

public class GillBreathing implements BreathingTechnique {

    @Override
    public void breathe() {
        System.out.println("gill breathing technique");
    }
}
