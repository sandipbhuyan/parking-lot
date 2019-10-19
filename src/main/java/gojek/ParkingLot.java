package gojek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingLot {
  public static void main(String[] args) throws IOException  {
    // Infinite Loop until a required solution is not there
    while(true)
    {
      BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
      String name = reader.readLine();
      boolean a = false;
      switch (name.toLowerCase())
      {
        case "a":
          System.out.println("switch");
          continue;
        case "b":
          System.out.println("Hub");
          continue;
        case "exit":
          a = true;
          break;
        default:
          break;
      }
      if(a)
      {
        break;
      }
    }

  }
}
