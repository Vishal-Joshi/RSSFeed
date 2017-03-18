package com.uzabase.assignment.output;

import org.springframework.stereotype.Component;

@Component
public interface FeedOutputter {
    void outputFeed(String feedToOutput);
}
