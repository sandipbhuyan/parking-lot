package gojek;

import controller.ParkingAllocate;
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
    while(true)
    {
      ParkingAllocate parking = new ParkingAllocate();
      BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
      String name = reader.readLine();
      String commands[] = name.split(" ");
      boolean a = false;
      if(commands.length == 0)
      {
        System.out.println("Invalid Input");
        continue;
      }
      switch (commands[0].toLowerCase())
      {
        case "create_parking_lot":
          if( commands.length == 2 && parking.initializeParkingLot(Integer.parseInt(commands[1])))
          {
            System.out.println("Created a parking lot with "+ commands[1] + " slots");

          }
          else
          {
            System.out.println("Unable to create parking lot. Please try again");
          }
          continue;
        case "park":
          if(commands.length == 3) {
            Car car = new Car(commands[1], commands[2].toLowerCase());
            int slot = parking.allocateParking(car);
            if(slot != 1)
            {
              System.out.println("Allocated plot number : "+ slot);
            }
            else {
              System.out.println("Sorry, Parking lot is full");
            }
          }
          else  {
            System.out.println("Not enough input");
          }
          System.out.println("Hub");
          continue;
        case "leave":
          if(commands.length == 2 && parking.leaveParking(Integer.parseInt(commands[1]))){
            System.out.println("Slot number of " + commands[1] + " free");
          }
          else {
            System.out.println("Not sufficient input");
          }
          continue;
        case "status":
          HashMap<String, Car> parkingDetails = parking.getAllParkingDetails();
          System.out.println("Sr no\t\t Registration no\t\tColour");
          for(int i = 1; i <= parking.getLimit(); i++)
          {
            Car car = parkingDetails.get(Integer.toString(i));
            System.out.println(i+"\t\t"+car.getNumber()+"\t\t"+car.getColor());
          }
          break;
        case "registration_numbers_for_cars_with_colour":
          if(commands.length == 2)
          {
            ArrayList<String> regd = parking.findRegistrationOrSlotNumbersFromColor(commands[1],0);
            if(regd == null)
            {
              System.out.println("Not found");
              continue;
            }
            Iterator<String> r = regd.iterator();
            while (r.hasNext())
            {
              System.out.print(", " + r.next() );
            }
          }
          else
          {
            System.out.println("Not enough input");
          }
          continue;
        case "slot_numbers_for_cars_with_colour":
          if(commands.length == 2)
          {
            ArrayList<String> slots = parking.findRegistrationOrSlotNumbersFromColor(commands[1],0);
            if(slots == null)
            {
              System.out.println("Not found");
              continue;
            }
            Iterator<String> r = regd.iterator();

            while (r.hasNext())
            {
              System.out.print(", " + r.next() );
            }
          }
          else
          {
            System.out.println("Not enough input");
          }
        case "slot_number_for_registration_number":
          if(commands.length == 2)
          {
            int num = parking.findSlotNumberFromRedgNo(commands[1]);
            if(num == 0)
            {
              System.out.println("Not found");
            }
            else{
              System.out.println(num);
            }
          }
          else {
            System.out.println("Not enough input");
          }
          continue;
        case "exit":
          a = true;
          continue;
        default:
          System.out.println("Not enough input");
          break;
      }
      if(a)
      {
        break;
      }
    }

  }
}
