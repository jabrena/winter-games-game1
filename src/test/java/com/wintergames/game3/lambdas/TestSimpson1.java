package com.wintergames.game3.lambdas;

public class TestSimpson1 {
    public static void main(String[] args) {
        DoubleFunctionSineAdapter sine = new DoubleFunctionSineAdapter();
        Double result = Simpson.integrate(sine, 0.0, Math.PI, 30);
        System.out.println("Using Simpson: Integral of sine from 0 to pi is " + result);
    }
}
