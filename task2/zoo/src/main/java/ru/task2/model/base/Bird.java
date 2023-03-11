package ru.task2.model.base;

public abstract class Bird extends Animal{
    private int flightAltitude;

    public Bird(int height, int weight, String eyeColor, int flightAltitude) {
        super(height, weight, eyeColor);
        this.flightAltitude = flightAltitude;
    }

    public int getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(int flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    public void fly(){
        System.out.println("I'm flying at " + flightAltitude + " meters");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Bird{" +
                "flightAltitude=" + flightAltitude +
                '}';
    }
}
