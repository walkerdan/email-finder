package edu.depaul.email;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageParserTest {

  @Test
  @DisplayName("should be able to create a document from a string")
  void testSimpleDoc() {
    String html = "<html><body>hello</body></html>";
    Document doc = Jsoup.parse(html);
    assertEquals("hello", doc.body().text());
  }

  @Test
  @DisplayName("can find simple links")
  void findsSimpleLinks() {
    String html = "<html><a href='/some/other/file.html'>my link</a></body></html>";
    Document doc = Jsoup.parse(html);
    PageParser parser = new PageParser();
    Set<String> links = parser.findLinks(doc);
    assertEquals("/some/other/file.html", links.toArray()[0]);
  }
}
