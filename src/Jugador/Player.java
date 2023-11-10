package Jugador;

import Jugador.Car;

public class Player {
    private String name;
    private Car car;
    public double acceleration;

    public void Player(String _name) {
        name = _name;
    }

    public void chooseCar(Car _car) {
        car = _car;
        System.out.println(name + " ha elegido un coche: " + car.getModel());
    }

    public void accelerate(double num) {
        acceleration=num;
    }
}