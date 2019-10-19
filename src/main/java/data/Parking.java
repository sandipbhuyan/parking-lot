package data;

public class Parking {
    private Car car;
    private int srNo;

    public Parking() {
    }

    public Parking(Car car, int srNo) {
        this.car = car;
        this.srNo = srNo;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }
}
