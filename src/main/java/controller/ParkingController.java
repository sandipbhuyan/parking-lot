package controller;

import data.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ParkingController {
    private ParkingAllocate parkingAllocate;

    public ParkingController() {
        this.parkingAllocate = new ParkingAllocate();
        parkingAllocate.setParkingLot(new HashMap<String, Car>());
    }

    /**
     * Initialize parking controller
     * @param slots int
     */
    public void initializeParking(int slots)
    {
        if(this.parkingAllocate.initializeParkingLot(slots))
        {
            System.out.println("Created a parking lot with "+ slots + " slots");
        }
        else
        {
            System.out.println("Unable to create parking lot. Please try again");
        }
    }

    /**
     * Allocate Parking controller
     *
     * @param regd String
     * @param color String
     */
    public void allocateParking(String regd,  String color)
    {
        Car car = new Car(regd, color.toLowerCase());
        int slot = this.parkingAllocate.allocateParking(car);
        if(slot != 0)
        {
            System.out.println("Allocated plot number : "+ slot);
        }
        else {
            System.out.println("Sorry, Parking lot is full");
        }
    }

    /**
     * Leave parking controller
     *
     * @param slot int
     */
    public void leaveParking(int slot)
    {
        if(this.parkingAllocate.leaveParking(slot)){
            System.out.println("Parking lot " + slot + " is free now");
        }
        else {
            System.out.println("Unable to leave parking");
        }
    }

    /**
     * Parking lot Status
     */
    public void parkingStatus()
    {
        HashMap<String, Car> parkingDetails = this.parkingAllocate.getAllParkingDetails();
        System.out.println("Sr no\t\t Registration no\t\tColour");
        for(int i = 1; i <= this.parkingAllocate.getLimit(); i++)
        {
            Car car = parkingDetails.get(Integer.toString(i));
            if(car == null)
                continue;
            System.out.println(i+"\t\t"+car.getNumber()+"\t\t"+car.getColor());
        }
    }

    /**
     * Search functionality
     *
     * @param color String
     * @param type String
     */
    public void findRegistrationOrSlotNumbersFromColor(String color, int type)
    {
        ArrayList<String> regd = this.parkingAllocate.findRegistrationOrSlotNumbersFromColor(color,type);
        if(regd == null)
        {
            System.out.println("Not found");
        }
        Iterator<String> r = regd.iterator();
        while (r.hasNext())
        {
            System.out.print(", " + r.next() );
        }
    }

    /**
     * Get slot number from regd no
     *
     * @param regd String
     */
    public void slotNumberFromRegdNo(String regd)
    {
        int num = this.parkingAllocate.findSlotNumberFromRedgNo(regd);
        if(num == 0)
        {
            System.out.println("Not found");
        }
        else{
            System.out.println(num);
        }
    }

    public void showCommands()
    {
        System.out.println("\ncreate_parking_lot <number> : To form a parking lot of size <number>");
        System.out.println("park <Registration Number> <Color> - park a car into the nearest parking lot");
        System.out.println("leave <parking_lot_no> - Remove the car from the perticular slot");
        System.out.println("status - Parking lot current status");
        System.out.println("registration_numbers_for_cars_with_colour <color> - get the registration numbers according to color");
        System.out.println("slot_numbers_for_cars_with_colour <color> - Get the slot numbers according to colors");
        System.out.println("slot_number_for_registration_number <registration_number> - get the slot numbers according to a registration number");
    }
}
