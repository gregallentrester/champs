package net.greg.examples.salient;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;


/**
  Identify and categorize a set of (scalar) integral
  numbers which are equivalent "Champion Numbers".

  A "Champion Number" is a fictive term for a group of
  numbers whose individual, constituent numerals are
  identical in cardinality but differ in ordinality.

  Stated another way, two equivalent Champion Numbers'
  digits appear in either the same order or appear in
  a scrambled order.

  Two examples:

    312,123,231
    45,54
 */
public final class Pilot {

  private static void process() {

    System.err.println("\n\nPilot");


    for (int i=0; i < universe.length; i++) {

      Integer value = 0;
      Integer compositeKey = 0;

      List<Integer> values =
        new ArrayList();

      System.err.println(
        "\n\nElement[" + i + "] " + universe[i]);

      String StringifiedInt =
        Integer.toString(universe[i]);


      for (int j=0; j < StringifiedInt.length(); j++) {

        int codecVal = StringifiedInt.charAt(j);
        compositeKey += codecVal;

        System.err.println(
          "  codecVal " + codecVal + "\n" +
          "  compositeKey " + compositeKey);
      }

      System.err.println(
        GRN + "---> " + NC + "Journal " + journal);

      List<Integer> valuesRef = null;

      if (journal.containsKey(compositeKey)) {

        valuesRef =
          journal.get(compositeKey);

        valuesRef.add(universe[i]);

        journal.put(compositeKey, valuesRef);
      }
      else {

        valuesRef =
          new ArrayList();

        valuesRef.add(universe[i]);
        journal.put(compositeKey, valuesRef);
      }

      keys.add(compositeKey);
    }


    System.err.println(
      GRN + "\n\n Universe" + NC + " | 312,123,10,45,54,67,333,10" +
      GRN + "\n     Keys" + NC + " | " + keys +
      GRN + "\n  Journal" + NC + " | " + journal +
      "\n\n ...  ...  ...\n\n");
  }


  public static void main(String ... args) {
    Pilot.process();
  }


  /*
    A static block is an anonymous method, which
    is effectively a Class-level constructor.
   */
  static {

    universe = new int[] { 312,123,10,45,54,67,333,231 };

    keys = new ArrayList();
    journal = new ConcurrentHashMap();
  }


  private static int [] universe;

  private static List<Integer> keys =
    new ArrayList();

  private static Map<Integer,List<Integer>> journal =
    new ConcurrentHashMap();


  public static final String RED = "\033[1;91m";
  public static final String GRN = "\033[1;92m";
  public static final String YLW = "\033[1;93m";
  public static final String NC = "\u001B[0m";
}
