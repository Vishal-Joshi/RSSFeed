# RSSFeed
Read an RSS Feed and output the result both on Standard output and in a separate file

#Technologies
* Sprint Boot 1.5.2.RELEASE
* Java 8

#Configuration file
application.properties (src/main/resources) contains the configuration for URL of RSS feed, file output location and word to exclude.

#Error conditions
If an error occurs anywhere between fetching RSS feed from external resource to excluding word to writing out to either standard output or
file output,
The error will be written to **standard error output**.