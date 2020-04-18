/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

/**
 * This is the main class for this application.
 * Usage:
 *   EmailFinder <a root URL>
 * Example:
 *   EmailFinder http://cdm.depaul.edu
 */
public class EmailFinder {

  public static void main(String[] args) {
    if (args.length >= 1) {
        String root = args[0];
        PageCrawler crawler = new PageCrawler();
        crawler.crawl(root);
        crawler.report("emails.txt");
    }
  }

}
