package refactoring.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    public final int MAX_TRUCK_SPEED = 80;
    public final int MAX_SEDAN_SPEED = 120;
    public final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case 0 :
                return new Truck(numberOfPassengers);
            case 1 :
                return new Sedan(numberOfPassengers);
            case 2 :
                return new Cabriolet(numberOfPassengers);
        }
        return null;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) throw new Exception();
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return date.after(summerStart) && date.before(summerEnd);
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        return isSummer(date, summerStart, summerEnd) ? getSummerConsumption(length) : getWinterConsumption(length);
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && (fuel > 0);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) return numberOfPassengers;
        return 0;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) fastenPassengersBelts();
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}
