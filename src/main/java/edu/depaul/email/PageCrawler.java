/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

import java.util.HashSet;
import java.util.Set;
import org.jsoup.nodes.Document;

/**
 * Given a starting URL string, this class finds links and email addresses
 * on the referenced page and the recursively performs the same task on
 * any links it finds.
 * When the target number of emails have been found, the process write out 3
 * results:
 * 1. list of email addresses
 * 2. list of URLs that were successfully processed
 * 3. list of URLs that could not be reached
 */
public class PageCrawler {
  private int maxEmails= 50;
  private Set<String> emails = new HashSet<>();
  PageFetcher fetcher = new PageFetcher();
  PageParser parser = new PageParser();
  String base = null;
  Set<String> checkedUrls = new HashSet<>();
  Set<String> goodLinks = new HashSet<>();
  Set<String> badLinks = new HashSet<>();

  private StorageService storage;

  public PageCrawler(StorageService storage) {
    this(storage, 50);
  }

  public PageCrawler(StorageService storage, int maxEmails) {
    this.storage = storage;
    this.maxEmails = maxEmails;
  }

  public void crawl(String url) {

    if (emails.size() >= maxEmails) {
      return;
    }
    if (base == null) {
      base = url;
    }
    Document doc = null;
    try {
       checkedUrls.add(url);
       doc = fetcher.get(url);
    } catch (Exception e) {
      badLinks.add(url);
      System.out.println(e.getMessage());
      return;
    }
    goodLinks.add(url);
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

  public void report() {
    storage.storeList("emails", emails);
    storage.storeList("good-links", goodLinks);
    storage.storeList("bad-links", badLinks);
  }

}
