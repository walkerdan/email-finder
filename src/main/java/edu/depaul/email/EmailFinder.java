/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

import edu.depaul.email.StorageService.StorageType;
import static edu.depaul.email.StorageService.StorageType.EMAIL;
import static edu.depaul.email.StorageService.StorageType.GOODLINKS;
import static edu.depaul.email.StorageService.StorageType.BADLINKS;

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
        .addLocation(EMAIL, "email.txt")
        .addLocation(GOODLINKS, "good-links.txt")
        .addLocation(BADLINKS, "badlinks.txt");
    return storage;
  }

  public void run(String[] args) {
    if (args.length >= 1) {
      String root = args[0];
      StorageService storage = setupStorage();
      PageCrawler crawler = new PageCrawler(storage);
      crawler.crawl(root);
      crawler.report();
    } else {
      System.out.println("NO starting URL");
    }
  }

  public static void main(String[] args) {
    EmailFinder finder = new EmailFinder();
    finder.run(args);
  }

}
