package com.uzabase.assignment.converter;

public class ExcludeWordConverter implements FeedConverter {
    @Override
    public String convertFeed(String feed, String wordToExclude) {
        return feed.replaceAll(wordToExclude, "--" + wordToExclude + "--");
    }
}
