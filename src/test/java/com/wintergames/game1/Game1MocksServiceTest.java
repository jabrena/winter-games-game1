package com.wintergames.game1;

import com.wintergames.game1.base.Game1BaseServiceTest;
import com.wintergames.game1.service.Game1Service;
import com.wintergames.game1.stackoverflow.model.Answers;
import com.wintergames.game1.stackoverflow.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

public class Game1MocksServiceTest extends Game1BaseServiceTest {

    @MockBean
    private Game1Service game1Service;

    @Before
    public void setup() {
        final List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setIsAnswered(false);
        items.add(item);
        final Answers answers = new Answers();
        answers.setItems(items);

        given(this.game1Service.getQuestions())
                .willReturn(answers);
    }

    @Test
    public void test() {
        assertThat(game1Service.getQuestions().getItems().size(), is(1));
    }
}