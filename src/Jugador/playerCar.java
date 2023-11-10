package Jugador;
public class playerCar {
    public Car playerCarCreation(int level) {
        Car cochePlayer = new Car("Porsche","Rojo",
                130 + (level * 15),4 + (level * 5));
        return cochePlayer;
    }
}