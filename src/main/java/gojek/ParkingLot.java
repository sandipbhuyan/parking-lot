package gojek;

import controller.ParkingAllocate;
import controller.ParkingController;
import data.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ParkingLot {
  public static void main(String[] args) throws IOException  {
    // Infinite Loop until a required solution is not there
    ParkingController parkingController = new ParkingController();
    boolean flag = false;
    while(true)
    {
      BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
      String name = reader.readLine();
      String commands[] = name.split(" ");
      if(commands[0].equals(""))
      {
        System.out.println("Invalid Input");
        continue;
      }
      switch (commands[0].toLowerCase())
      {
        case "create_parking_lot":
          if(commands.length != 2){
            System.out.println("Not enough input");
            continue;
          }
          parkingController.initializeParking(Integer.parseInt(commands[1]));
          continue;
        case "park":
          if(commands.length != 3) {
            System.out.println("Not enough input");
            continue;
          }
          parkingController.allocateParking(commands[1],commands[2]);
          continue;
        case "leave":
          if(commands.length != 2) {
            System.out.println("Not Enough input");
            continue;
          }
          parkingController.leaveParking(Integer.parseInt(commands[1]));
          continue;
        case "status":
          parkingController.parkingStatus();
          continue;
        case "registration_numbers_for_cars_with_colour":
          if(commands.length != 2)
          {
            System.out.println("Not enough input");
            continue;
          }
          parkingController.findRegistrationOrSlotNumbersFromColor(commands[1],0);
          continue;
        case "slot_numbers_for_cars_with_colour":
          if(commands.length != 2)
          {
            System.out.println("Not enough input");
            continue;
          }
          parkingController.findRegistrationOrSlotNumbersFromColor(commands[1],1);
          continue;
        case "slot_number_for_registration_number":
          if(commands.length != 2)
          {
            System.out.println("Not enough input");
            continue;
          }
          parkingController.slotNumberFromRegdNo(commands[1]);
          continue;
        case "exit":
          flag = true;
          break;
        default:
          System.out.println("Not enough input");
          break;
      }
      if(flag)
      {
        break;
      }
    }

  }
}
