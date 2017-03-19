package com.uzabase.assignment.output;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class FileFeedOutputterTest {

    private static final String FEED_FILE_OUTPUT_PATH = "/Users/vishal/feedoutputs/";

    private FileFeedOutputter feedOutputter;

    private File directoryForOutputOfRssFeed;

    @Before
    public void setUp() {
        feedOutputter = new FileFeedOutputter(FEED_FILE_OUTPUT_PATH);
        directoryForOutputOfRssFeed = new File(FEED_FILE_OUTPUT_PATH);
        directoryForOutputOfRssFeed.mkdir();
    }

    @Test
    public void testShouldWriteOutputToAFile() {
        //given
        File[] filesBeforeExecution = directoryForOutputOfRssFeed.listFiles();


        //when
        feedOutputter.outputFeed("hello, Vishal Joshi!");

        //then
        File[] filesAfterExecution = directoryForOutputOfRssFeed.listFiles();
        assertThat(filesAfterExecution.length, is(equalTo(filesBeforeExecution.length + 1)));

    }

    @After
    public void tearDown() {
        for (File file : directoryForOutputOfRssFeed.listFiles()) {
            file.delete();
        }
        directoryForOutputOfRssFeed.delete();
    }

}