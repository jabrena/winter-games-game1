package com.wintergames.game3.lambdas;

public class TestSimpson4 {
    public static void main(String[] args) {
        double result = Simpson.integrate(
                x -> Math.sin(x),
                0.0, Math.PI, 30);
        System.out.println("Using Simpson: Integral of sine from 0 to pi is " + result);
    }
}
