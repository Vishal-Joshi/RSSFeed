package com.uzabase.assignment.output;

public class StandardFeedOutputter implements FeedOutputter {

    @Override
    public void outputFeed(String feedToOutput) {
        System.out.print(feedToOutput);
    }
}
