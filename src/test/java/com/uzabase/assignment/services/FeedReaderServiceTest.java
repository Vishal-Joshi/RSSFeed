package com.uzabase.assignment.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class FeedReaderServiceTest {

    private FeedReaderService feedReaderService;

    @Mock
    private RestTemplate restTemplate;

    private final String uzabaseFeedUrl = "http://test/rss";

    @Before
    public void setUp() {
        feedReaderService = new FeedReaderService(restTemplate, uzabaseFeedUrl);
    }

    @Test
    public void testShouldReturnRSSFeed() {
        //given
        Mockito.when(restTemplate.getForEntity(uzabaseFeedUrl, String.class))
                .thenReturn(new ResponseEntity<String>("body", HttpStatus.OK));

        //when
        Optional<String> feed = feedReaderService.fetchFeed();

        //then
        assertThat(feed.get(), is(equalTo("body")));
    }

    @Test
    public void testShouldReturnNothingRSSFeedReturnOtherThan200OK() {
        //given
        Mockito.when(restTemplate.getForEntity(uzabaseFeedUrl, String.class))
                .thenReturn(new ResponseEntity<String>("body", HttpStatus.INTERNAL_SERVER_ERROR));

        //when
        Optional<String> feed = feedReaderService.fetchFeed();

        //then
        assertThat(feed.isPresent(), is(equalTo(false)));
    }

}