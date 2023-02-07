public class Loops {

  public static void nHellos(int n) {
    int endInt = 1;
    while (endInt <= n) {
      if (endInt % 10 == 1 && endInt % 100 != 11) {
        System.out.println(endInt + "st hello");
      } else if (endInt % 10 == 2 && endInt % 100 != 12) {
        System.out.println(endInt + "nd hello");
      } else if (endInt % 10 == 3 && endInt % 100 != 13) {
        System.out.println(endInt + "rd hello");
      } else {
        System.out.println(endInt + "th hello");
      }
      endInt++;
    }
  }


  public static double nRandoms(int n) {
    int endInt = 1;
    int count = 0;
    double total = 0;
    while (endInt <= n) {
      double rand = Math.random();
      System.out.println(rand);
      total = total + rand;
      count++;
      endInt++;
    }
    System.out.println();
    return total / count;
  }


  public static boolean isPrime(int n) {
    int endInt = 2;
    boolean niceBool = true;
    while (endInt < n) {
      if (n % endInt == 0) {
        niceBool = false;
      }
      endInt++;
    }
    return niceBool;
  }


  public static String getFactors(int n) {
    int endInt = 1;
    int count = 0;
    while (endInt <= n) {
      if (n % endInt == 0) {
        count++;
      }
      endInt++;
    }
    int[] array = new int[count];
    endInt = 1;
    count = 0;
    while (count < array.length) {
      if (n % endInt == 0) {
        array[count] = endInt;
        count++;
      }
      endInt++;
    }
    String outPut = "";
    for (int i = 0; i < array.length; i++) {
      outPut = outPut + array[i] + ", ";
    }
    return "[" + outPut.substring(0, outPut.length() - 2) + "]";

  }


  private static int rollDie() {
    return (int) (Math.random() * 6) + 1;
  }

  public static void pepysSimulation() {
    final int NTRIALS = 1000000;

    int oneCount = 0;
    int oneCountTwelve = 0;

    for (int trials = 0; trials < NTRIALS; trials++) {
      int roll1 = rollDie();
      

      if (roll1 == 1) {
        oneCount++;
      }

      int timeRolled = 0;
      for (int rolling = 0; rolling < 12; rolling++) {
        int roll2 = rollDie();
        if (roll2 == 1) {
          timeRolled++;
        }
      }
      if (timeRolled >= 2) {
        oneCountTwelve++;
      }
      
    }

    System.out.println("the amount of trials are: " + NTRIALS);
    System.out.println("probability of rolling a 1 with a 6 sided die rolled once: " + (double)oneCount / NTRIALS);
    System.out.println("probability of rolling a 1 at least twice with a 6 sided die rolled 12 times: " + (double)oneCountTwelve / NTRIALS);
  }


  private static int rand() {
    return (int)(Math.random() * 3) ;
  }


  public static void montyHallSimulation(int n) {
    int switchPass = 0;
    int notSwitchPass = 0;
    final int NTRIALS = n;

    for (int trials = 0; trials < NTRIALS; trials++) {
      int [] array = new int[3];
      int prizeDoor = rand();
      array[prizeDoor] = 1;
      int choice = rand();

      int openDoorTest = rand();
      while (openDoorTest == choice && openDoorTest == prizeDoor) {
        openDoorTest = rand();
      }
      int openDoor = openDoorTest;
      array[openDoor] = -1;

      if (choice == prizeDoor) {
        notSwitchPass++;
      }
      if (choice != prizeDoor) {
        switchPass++;
      }
    }
    System.out.println("the probability of switching working is " + (double)switchPass / NTRIALS);
    System.out.println("the probability of not switching working is " + (double)notSwitchPass / NTRIALS);
  }


  public static void main(String[] args) {

    // nHellos(120);

    // System.out.println(nRandoms(5));

    // System.out.println(isPrime(59));

    // System.out.println(getFactors(59));

    // pepysSimulation();

    montyHallSimulation(1000000);

  }
}

// javac Loops.java; java Loops