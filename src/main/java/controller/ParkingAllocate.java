package controller;

import data.Car;
import data.Parking;

import java.util.ArrayList;
import java.util.HashMap;

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
    public boolean isEmpty()
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
        if(this.isEmpty())
            return false;

        for(int i = 1; i < this.getLimit(); i++)
        {
            if(this.getParkingLot().get(Integer.toString(i)) != null)
            {
                this.getParkingLot().put(Integer.toString(i), car);
                return true;
            }
        }
        return true;
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
}

