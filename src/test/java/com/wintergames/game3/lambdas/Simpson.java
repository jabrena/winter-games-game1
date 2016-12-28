package com.wintergames.game3.lambdas;

public class Simpson
  {
    /**
     * Approximates the definite integral using Simpson's Rule.  The function
     * should be continuous in the range [a,b].  The specified number of
     * subintervals should be even, but the value is incremented if it isn't.
     *
     * @param df the function to be integrated
     * @param a  the lower bound of integration
     * @param b  the upper bound of integration
     * @param n  the number of subintervals to be used in computing the integral
     *
     * @return the approximate value of the definite integral
     *
     * @throws IllegalArgumentException if n < 0, n > 100,000, or b < a
     */
    public static Double integrate(DoubleFunction df, Double a, Double b, int n)
      {
        if (n < 0 || n > 100_000)
          {
            String message = n + "out of range";
            throw new IllegalArgumentException(message);
          }
        else if (b < a)
          {
            String message = "a must be less than b; a =" + a + ", b = " + b;
            throw new IllegalArgumentException(message);
          }

        if (a == b)
            return 0.0;

        Double x, deltaX, sum2 = 0.0, sum4;

        if (n % 2 != 0)   // make sure that n is even
            ++n;

        deltaX = (b - a)/n;
        x = a + deltaX;
        sum4 = df.f(x);

        for (int i = 1; i <= (n - 2)/2; ++i)
          {
            x = x + deltaX;
            sum2 = sum2 + df.f(x);
            x = x + deltaX;
            sum4 = sum4 + df.f(x);
          }

        return (deltaX/3.0)*(df.f(a) + df.f(b) + 4.0*sum4 + 2.0*sum2);
      }
  }
