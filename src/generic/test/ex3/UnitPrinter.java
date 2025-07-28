package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class UnitPrinter {

  public static <T extends BioUnit> void printV1(Shuttle<T> t) {
     t.showInfo();
  }

  public static void printV2(Shuttle<? extends BioUnit> t) {
    t.showInfo();
  }

}
