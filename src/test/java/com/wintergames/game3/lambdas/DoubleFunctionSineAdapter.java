
package com.wintergames.game3.lambdas;

public class DoubleFunctionSineAdapter implements DoubleFunction {
    public Double f(Double x)
      {
        return Math.sin(x);
      }

}
