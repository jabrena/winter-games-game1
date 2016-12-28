package com.wintergames.game3.lambdas;

public class TestSimpson2 {
    public static void main(String[] args) {
        DoubleFunction sineAdapter = new DoubleFunction() {
            public Double f(Double x)
              {
                return Math.sin(x);
              }
        };

        double result = Simpson.integrate(sineAdapter, 0.0, Math.PI, 30);
        System.out.println("Using Simpson: Integral of sine from 0 to pi is " + result);
    }
}
