package refactoring.car;

public class Cabriolet extends Car {
    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
