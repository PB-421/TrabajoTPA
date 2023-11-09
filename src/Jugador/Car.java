package Jugador;

public class Car {
    private String model;
    private String color;
    private int topSpeed;
    private double acceleration;
    private double gripPercent;

    public Car(String model, String color, int topSpeed, double gripPercent) {
        this.model = model;
        this.color = color;
        this.topSpeed = topSpeed;
        this.gripPercent = gripPercent;
    }

    public void setAcceleration(double _acceleration) {
        acceleration=_acceleration;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public double getGripPercent() {
        return gripPercent;
    }
}