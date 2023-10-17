package com.example.designpatterns.BridgeDesignPattern.Abstractors;

import com.example.designpatterns.BridgeDesignPattern.Implementors.BreathingTechnique;

public class Tree extends LivingThings {

    public Tree(BreathingTechnique breathingTechnique) {
        super(breathingTechnique);
    }

    @Override
    public void selectBreathingTechnique() {
        breathingTechnique.breathe();
    }
}
