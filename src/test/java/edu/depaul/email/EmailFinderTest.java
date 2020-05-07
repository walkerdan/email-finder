package edu.depaul.email;

import org.junit.jupiter.api.Test;

public class EmailFinderTest {

  @Test
  void test1() {
    String[] url = {"https://cdm.depaul.edu"};
    EmailFinder.main(url);
  }

}
