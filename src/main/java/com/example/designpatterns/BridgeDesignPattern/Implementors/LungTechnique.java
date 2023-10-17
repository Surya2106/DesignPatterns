package com.example.designpatterns.BridgeDesignPattern.Implementors;

public class LungTechnique implements BreathingTechnique {

    @Override
    public void breathe() {
        System.out.println("lung breathing technique");
    }
}
