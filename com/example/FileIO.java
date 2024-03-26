package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * This program reads and writes from text files.
 *
 * @author Christopher Di Bert
 * @version 1.0
 * @since 2024-03-21
 */

// FileIO class
public final class FileIO {

  /** Private constructor to prevent instantiation. */
  private FileIO() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    // Gets input filepath.
    File readFile = new File("input.txt");
    try {
      // Creates file writer and wraps it in buffered writer.
      FileWriter fileWriter = new FileWriter("output.txt");
      BufferedWriter writer = new BufferedWriter(fileWriter);
      // Passes the input file path to scanner.
      Scanner sc = new Scanner(readFile);
      // Read while lines exist in the input file.
      while (sc.hasNextLine()) {
        // Gets the sum of each line.
        Double sum = 0d;
        try {
          String[] numbers = sc.nextLine().split(" ");
          for (String numberStr : numbers) {
            sum += Double.parseDouble(numberStr);
          }
          writer.write(Double.toString(sum));
          writer.newLine();
        } catch (Exception e) {
          writer.write("INVALID INPUT!");
          writer.newLine();
        }
      }

      // Closes writer and scanner once done.
      sc.close();
      writer.close();

      // Error thrown if invalid filepath is entered.
    } catch (Exception e) {
      System.out.println("You must enter a valid filepath!");
    }
  }
}
