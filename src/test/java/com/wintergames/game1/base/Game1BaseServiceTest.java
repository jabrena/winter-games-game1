package com.wintergames.game1.base;

import com.wintergames.game1.Game1App;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Game1App.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class Game1BaseServiceTest {
    
}