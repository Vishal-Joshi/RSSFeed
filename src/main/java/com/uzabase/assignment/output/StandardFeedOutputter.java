package com.uzabase.assignment.output;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("standardFeedOutputter")
public class StandardFeedOutputter implements FeedOutputter {

    @Override
    public void outputFeed(String feedToOutput) {
        System.out.print(feedToOutput);
    }
}
