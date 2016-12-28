package com.wintergames.game3.optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OptionalDemo {

    private static final Logger logger = LoggerFactory.getLogger(OptionalDemo.class);


    public void methodWithOptionalParameter(Optional<String> param1){
        if(param1.isPresent()){
            logger.info("It is not present the parameter");
        }else{
            logger.info("The parameter is {}", param1);
        }
    }

    public static void main(String... args) {
        OptionalDemo demo =
                new OptionalDemo();
        demo.methodWithOptionalParameter(null);
        demo.methodWithOptionalParameter("Hello World");
    }

}
