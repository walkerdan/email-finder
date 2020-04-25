/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */

package edu.depaul.email;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class handles the HTTP aspects of the project:
 * Given a URL, if sends a GET to that page and returns
 * the content.
 */
public class PageFetcher {

  private static final Logger logger = LoggerFactory.getLogger(PageFetcher.class);

  public PageFetcher() {}


  public String getString(String url) {
    try {
    Document doc = Jsoup.connect(url).get();
    return doc.outerHtml();
    } catch (IOException e) {
      throw new EmailFinderException("unable to fetch " + url, e);
    } catch (IllegalArgumentException e) {
      throw new EmailFinderException("Invalid URL " + url, e);
    }
  }

  public Document get(String url) {
    try {
      Document doc = Jsoup.connect(url).get();
      return doc;
    } catch (IOException e) {
      throw new EmailFinderException("unable to fetch " + url, e);
    } catch (IllegalArgumentException e) {
      throw new EmailFinderException("Invalid URL " + url, e);
    }
  }

}
