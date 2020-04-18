/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * A class to parse HTML documents in order to find
 * embedded email addresses and links to other pages
 */
public class PageParser {

  public Set<String> findEmails(Document doc) {
    Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
    Matcher matcher = p.matcher(doc.text());
    Set<String> emails = new HashSet<>();
    while (matcher.find()) {
      emails.add(matcher.group());
    }
    return emails;
  }

  public Set<String> findLinks(Document doc) {
    Set<String> links = new HashSet<>();

    Elements elements = doc.select("a[href]");
    for (Element e : elements) {
      links.add(e.attr("href"));
    }
    return links;
  }
}
