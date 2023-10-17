package com.example.designpatterns.BridgeDesignPattern.Abstractors;

import com.example.designpatterns.BridgeDesignPattern.Implementors.BreathingTechnique;

public abstract class LivingThings {

    BreathingTechnique breathingTechnique;

    LivingThings(BreathingTechnique breathingTechnique) {
        this.breathingTechnique = breathingTechnique;
    }

    abstract public void selectBreathingTechnique();
}
