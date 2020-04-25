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

  private StorageService setupStorage() {
    StorageService storage = new StorageService();
    storage
        .addLocation("email", "email.txt")
        .addLocation("good-links", "good-links.txt")
        .addLocation("bad-links", "badlinks.txt");
    return storage;
  }

  public void run(String[] args) {
    if (args.length >= 1) {
      String root = args[0];
      StorageService storage = setupStorage();
      PageCrawler crawler = new PageCrawler(storage);
      crawler.crawl(root);
      crawler.report();
    }
  }

  public static void main(String[] args) {
    EmailFinder finder = new EmailFinder();
    finder.run(args);
  }

}
