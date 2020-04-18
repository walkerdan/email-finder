/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jsoup.nodes.Document;

/**
 *
 */
public class PageCrawler {
  private int maxEmails= 50;
  private Set<String> emails = new HashSet<>();
  PageFetcher fetcher = new PageFetcher();
  PageParser parser = new PageParser();
  String base = null;
  Set<String> checkedUrls = new HashSet<>();

  public void crawl(String url) {

    if (emails.size() >= maxEmails) {
      return;
    }
    if (base == null) {
      base = url;
    }
    Document doc = null;
    try {
       doc = fetcher.get(url);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    Set<String> newEmails = parser.findEmails(doc);
    if (newEmails.size() > 0) {
      emails.addAll(newEmails);
      if (emails.size() >= maxEmails) {
        System.out.println("finished!");
        return;
      }
    }
    Set<String> urls = parser.findLinks(doc);
    if (urls.size() > 0) {
      for (String newUrl : urls) {
        if (! checkedUrls.contains((newUrl))) {
          checkedUrls.add(newUrl);
          if (newUrl.startsWith("http")) {
            crawl(newUrl);
          } else {
            crawl(base + newUrl);
          }
        }
      }
    }
    System.out.println(emails.size());
  }

  public void report(String fileName) {

    FileOutputStream stream = null;
    try {
      stream = new FileOutputStream(fileName);
      ListWriter writer = new ListWriter(stream);
      writer.writeList(emails);
    } catch (Exception err) {
      throw new PageFetcherException("Error while write out email addresses", err);
    } finally {
      if (stream != null) {
        try {
          stream.close();
        } catch (IOException err) {
          throw new PageFetcherException("Error while closing output file", err);
        }
      }
    }
  }

}
