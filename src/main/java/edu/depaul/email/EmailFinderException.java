/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

/**
 * Exception class used to encapsulate the details of failures to occur
 * during the run of the application
 */
public class EmailFinderException extends RuntimeException {
  public EmailFinderException(String msg, Throwable err) {
    super(msg, err);
  }

}
