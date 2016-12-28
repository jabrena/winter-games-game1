package com.wintergames.game3.lambdas;

public class TestBisection2 {
    public static void main(String[] args) {
        double solution = Bisection.solve(
                x -> x*x*x + 4.0*x*x - 10.0,
                1.0, 2.0, 30, 0.0001);
        System.out.println("Using Bisection: Solution of f(x) =  0 is " + solution);
    }
}
