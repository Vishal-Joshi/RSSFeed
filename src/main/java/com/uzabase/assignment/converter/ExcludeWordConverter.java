package com.uzabase.assignment.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("excludefeedconverter")
public class ExcludeWordConverter implements FeedConverter {
    @Override
    public String convertFeed(String feed, String wordToExclude) {
        return feed.replaceAll(wordToExclude, "--" + wordToExclude + "--");
    }
}
