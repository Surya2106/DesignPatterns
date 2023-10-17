package com.example.designpatterns.BridgeDesignPattern;

import com.example.designpatterns.BridgeDesignPattern.Abstractors.Human;
import com.example.designpatterns.BridgeDesignPattern.Implementors.BreathingTechnique;
import com.example.designpatterns.BridgeDesignPattern.Implementors.LungTechnique;

public class ClientApplication {

    public static void main(String[] args) {

        BreathingTechnique gillBreathing = new LungTechnique();
        Human human =  new Human(gillBreathing);
        human.selectBreathingTechnique();

    }
}
