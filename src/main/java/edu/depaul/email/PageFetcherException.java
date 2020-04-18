/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

public class PageFetcherException extends RuntimeException {
  public PageFetcherException(String msg, Throwable err) {
    super(msg, err);
  }

}
