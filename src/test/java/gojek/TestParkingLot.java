package gojek;


import controller.ParkingAllocate;
import controller.ParkingController;
import data.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestParkingLot {
    private ParkingAllocate parkingAllocate;

    @Before
    public void setUp() throws Exception
    {
        this.parkingAllocate = new ParkingAllocate();
        parkingAllocate.setParkingLot(new HashMap<String, Car>());
    }

    @Test
    public void testParkingLot()
    {
        assertTrue(this.parkingAllocate.initializeParkingLot(6));
        Car car1 = new Car("KA-01-HH-1234","white");
        Car car2 = new Car("KA-01-HH-9999","white");
        Car car3 = new Car("KA-01-BB-0001","bkack");
        Car car4 = new Car("KA-01-HH-7777","red");
        Car car5 = new Car("KA-01-HH-2701","blue");
        Car car6 = new Car("KA-01-HH-3141","black");
        assertEquals(this.parkingAllocate.allocateParking(car1),1);
        assertEquals(this.parkingAllocate.allocateParking(car2),2);
        assertEquals(this.parkingAllocate.allocateParking(car3),3);
        assertEquals(this.parkingAllocate.allocateParking(car4),4);
        assertEquals(this.parkingAllocate.allocateParking(car5),5);
        assertEquals(this.parkingAllocate.allocateParking(car6),6);
        assertTrue(this.parkingAllocate.leaveParking(4));
        assertNotNull(this.parkingAllocate.getAllParkingDetails());
        Car car7 = new Car("KA-01-P-333", "white");
        Car car8 = new Car("DL-12-AA-9999", "white");
        assertEquals(this.parkingAllocate.allocateParking(car5),4);
        assertEquals(this.parkingAllocate.allocateParking(car5),0);
        assertNotNull(this.parkingAllocate.findRegistrationOrSlotNumbersFromColor("white",0));
        assertNotNull(this.parkingAllocate.findRegistrationOrSlotNumbersFromColor("white",1));
        assertEquals(this.parkingAllocate.findSlotNumberFromRedgNo("KA-01-HH-3141"), 6);
        assertEquals(this.parkingAllocate.findSlotNumberFromRedgNo("MH-04-AY-1111"), 0);

    }

}
