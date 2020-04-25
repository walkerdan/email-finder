/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates storage handling so that we can use a variety of services.  The
 * initial implementation just uses the file system.
 */
public class StorageService {

  private Map<String, String> locations = new HashMap<>();

  public StorageService addLocation(String name, String location) {

    locations.put(name, location);
    return this;
  }

  public void storeList(String handle, Collection<String> aList) {
    String location = locations.get(handle);

    FileOutputStream stream = null;
    try {
      stream = new FileOutputStream(location);
      ListWriter writer = new ListWriter(stream);
      writer.writeList(aList);
    } catch (Exception err) {
      throw new EmailFinderException("Error while write out " + handle, err);
    } finally {
      if (stream != null) {
        try {
          stream.close();
        } catch (IOException err) {
          throw new EmailFinderException("Error while closing output file", err);
        }
      }
    }
  }
}
