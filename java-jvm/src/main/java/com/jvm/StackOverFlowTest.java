package com.jvm;

public class StackOverFlowTest {

  public static void main(String[] args) {
    Recursive r = new Recursive();
    r.doit(10000);
  }

  static class Recursive{
    public int doit(int t) {
//      return 1;
      return t + doit(t - 1);
    }

  }


}
