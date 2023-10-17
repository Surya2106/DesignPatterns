package com.example.designpatterns.BridgeDesignPattern.Abstractors;

import com.example.designpatterns.BridgeDesignPattern.Implementors.BreathingTechnique;

public class Human extends LivingThings {

    public Human(BreathingTechnique breathingTechnique) {
        super(breathingTechnique);
    }

    @Override
    public void selectBreathingTechnique() {
        breathingTechnique.breathe();
    }
}
