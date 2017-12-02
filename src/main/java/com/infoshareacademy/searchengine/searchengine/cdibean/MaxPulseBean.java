package com.infoshareacademy.searchengine.searchengine.cdibean;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MaxPulseBean implements MaxPulse{


    @Override
    public double getPulseMan(int age) {
        return 202 - (0.55 * age);
    }

    @Override
    public double getPulseWoman(int age) {
        return 216 - (1.09 * age);
    }
}
