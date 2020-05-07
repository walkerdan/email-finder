package edu.depaul.email;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListWriterTest {

  @Test
  @DisplayName("should write a simple list to the output")
  void testWritingSimpleList() throws IOException {
    String[] items = {"a", "b", "c"};

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    ListWriter writer = new ListWriter(output);
    writer.writeList(Arrays.asList(items));
    assertEquals("a\nb\nc\n", output.toString());
  }

}
