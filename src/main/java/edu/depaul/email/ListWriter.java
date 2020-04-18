/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

/**
 * Writes a given list to an output stream.  Each element is written to
 * a new line.
 */
public class ListWriter {

  private final OutputStream output;
  private byte[] newLine = {'\n'};

  public ListWriter(OutputStream output) {
    this.output = output;
  }

  public void writeList(Collection<String> aList) throws IOException {
    for (String item : aList) {
      output.write(item.getBytes());
      output.write(newLine);
    }
  }
}
