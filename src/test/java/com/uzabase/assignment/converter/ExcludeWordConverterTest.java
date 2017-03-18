package com.uzabase.assignment.converter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExcludeWordConverterTest {

    @Test
    public void testShouldReturnFeedWithExcludedWord(){
        //given
        ExcludeWordConverter excludeWordConverter = new ExcludeWordConverter();
        String feed = "My assignment for Uzabase is going well";
        String expectedFeed = "My assignment for --Uzabase-- is going well";

        //when
        String convertedFeed = excludeWordConverter.convertFeed(feed, "Uzabase");

        //then
        assertThat(convertedFeed, is(equalTo(expectedFeed)));

    }

}