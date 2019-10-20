package controller;

import data.Car;
import data.Parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingAllocate {
    private HashMap<String, Car> parkingLot;
    private int emptyCount;
    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getEmptyCount() {
        return emptyCount;
    }

    public void setEmptyCount(int emptyCount) {
        this.emptyCount = emptyCount;
    }

    public HashMap<String, Car> getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(HashMap<String, Car> parkingLot) {
        this.parkingLot = parkingLot;
    }

    /**
     * Intialize the parking lot
     * @param count int
     * @return boolean
     */
    public boolean initializeParkingLot(int count)
    {
        for(int i = 1; i <= count; i++)
        {
            this.parkingLot.put(Integer.toString(i), null);
        }
        this.setEmptyCount(count);
        this.setLimit(count);
        return true;
    }

    /**
     * Get the parkingLot is empty or not
     *
     * @return boolean
     */
    public boolean isNotEmpty()
    {
        return this.getEmptyCount() == 0;
    }

    /**
     * @param car Car
     *
     * @return boolean
     */
    public boolean allocateParking(Car car)
    {
        if(this.isNotEmpty())
            return false;

        for(int i = 1; i <= this.getLimit(); i++)
        {
            if(this.getParkingLot().get(Integer.toString(i)) != null)
            {
                this.getParkingLot().put(Integer.toString(i), car);
                this.setEmptyCount(this.getEmptyCount() - 1);
                return true;
            }
        }
        return false;
    }

    /**
     * Leave the parking lot
     *
     * @param place int
     * @return boolean
     */
    public boolean leaveParking(int place)
    {
        if(place > this.getLimit())
            return false;

        this.getParkingLot().put(Integer.toString(place), null);
        this.setEmptyCount(this.getEmptyCount() + 1);
        return true;
    }

    /**
     * Get all parking details
     *
     * @return
     */
    public HashMap<String, Car> getAllParkingDetails()
    {
        return this.getParkingLot();
    }

    /**
     * Get Registration number or slot number according to the color
     *
     * @param color String
     * @param type int 0 -> registration number 1-> slot number
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> findRegistrationOrSlotNumbersFromColor(String color, int type)
    {
        ArrayList<String> redg = new ArrayList<String>();
        ArrayList<String> slot = new ArrayList<String>();
        for(int i = 1; i <= this.getParkingLot().size(); i++ )
        {
            Car car = this.getParkingLot().get(Integer.toString(i));
            if(car.getColor().equals(color.toLowerCase()))
            {
                redg.add(car.getNumber());
                slot.add(Integer.toString(i));
            }

        }
        return type == 0 ? redg: slot;
    }

    /**
     * Find Plot number from redg no
     *
     * @param redg int
     * @return int
     */
    public int findSlotNumberFromRedgNo(String redg)
    {
        for(int i = 1; i <= this.getParkingLot().size(); i++ )
        {
            Car car = this.getParkingLot().get(Integer.toString(i));
            if(car.getNumber().equals(redg))
            {
                return i;
            }
        }
        return 0;
    }
}

