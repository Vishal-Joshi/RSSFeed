package com.uzabase.assignment.output;

import org.springframework.beans.factory.annotation.Value;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileFeedOutputter implements FeedOutputter {

    public FileFeedOutputter(@Value("${output.feed.file.path}") String feedFileOutput) {
        this.feedFileOutput = feedFileOutput;
    }

    private String feedFileOutput;

    @Override
    public void outputFeed(String feedToOutput) {
        try {
            FileWriter fileWriter = new FileWriter(feedFileOutput + new Date().toString() + ".txt");
            fileWriter.append(feedToOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
