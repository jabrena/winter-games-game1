package com.wintergames.game3.lambdas;

public class TestSimpson3 {
    public static void main(String[] args) {
        DoubleFunction sine = (Double x) -> Math.sin(x);
        Double result = Simpson.integrate(sine, 0.0, Math.PI, 30);
        System.out.println("Using Simpson: Integral of sine from 0 to pi is " + result);
    }
}
