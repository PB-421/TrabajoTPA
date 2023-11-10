package Jugador;

import java.util.logging.Level;


public class NPC extends Player {
    public int Level;

    public Car NPCCarCreation(int level) {
        Car cochePlayer = new Car("lol", "rojo",
                130 + (level * 15),
                4 + (level * 5));
        cochePlayer.setAcceleration(accelerate(Level));
        return cochePlayer;
    }

    public double accelerate(int level) {
        random random = new random();
        acceleration = random.Randomizer(level);
        return acceleration;
    }

}