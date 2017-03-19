package com.uzabase.assignment;

import com.uzabase.assignment.converter.FeedConverter;
import com.uzabase.assignment.output.FeedOutputter;
import com.uzabase.assignment.services.FeedReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class RSSFeedApplication {

    @Autowired
    private FeedReaderService feedReaderService;

    @Autowired
    @Qualifier("excludefeedconverter")
    private FeedConverter feedConverter;

    @Autowired
    @Qualifier("standardFeedOutputter")
    private FeedOutputter feedOutputter;

    @Value("${word.to.exclude}")
    private String wordToExclude;

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext ctx = SpringApplication.run(RSSFeedApplication.class, args);
            RSSFeedApplication rss = ctx.getBean(RSSFeedApplication.class);
            rss.convertAndPrintFeed();
        } catch (Exception exception) {
            System.err.print("Exception occurred " + exception.getMessage());
        }
    }

    private void convertAndPrintFeed() {
        Optional<String> feed = feedReaderService.fetchFeed();
        feed.ifPresent(feedValue -> feedOutputter.outputFeed(feedConverter.convertFeed(feedValue, wordToExclude)));
    }
}
