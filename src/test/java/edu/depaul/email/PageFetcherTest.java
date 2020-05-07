package edu.depaul.email;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageFetcherTest {
  
  @Test
  @DisplayName("Should return page content when URL is valid")
  void getValidPage() {
    PageFetcher fetcher = new PageFetcher();
    String page = fetcher.getString("http://google.com");
    String phrase = "Search the world's information";
    assertTrue(page.contains(phrase));
  }

  @Test
  @DisplayName("Should throw PageFetcherException when page does not exist")
  void testNoSuchPage() {
    PageFetcher fetcher = new PageFetcher();
    assertThrows(EmailFinderException.class, () -> fetcher.get(""));
  }

  @Test
  @DisplayName("Verify that root CDM page contains a link to the faculty listing")
  void testRootContainFaculty() {
    PageFetcher fetcher = new PageFetcher();
    String page = fetcher.getString("https://www.cdm.depaul.edu");
    String phrase = "Faculty.aspx";
    assertTrue(page.contains(phrase));
  }
}
