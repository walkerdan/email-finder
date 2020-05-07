package edu.depaul.email;

import org.junit.jupiter.api.Test;
import static edu.depaul.email.StorageService.StorageType.EMAIL;
import static edu.depaul.email.StorageService.StorageType.GOODLINKS;
import static edu.depaul.email.StorageService.StorageType.BADLINKS;



public class PageCrawlerTest {

  @Test
  void e2eTest() {
    StorageService storage = new StorageService();
    storage
        .addLocation(EMAIL, "email.txt")
        .addLocation(GOODLINKS, "good-links.txt")
        .addLocation(BADLINKS, "bad-links.txt");
    PageCrawler crawler = new PageCrawler(storage, 25);
    crawler.crawl("http://cdm.depaul.edu");
    crawler.report();
  }

}
