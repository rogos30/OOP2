package organisms.animals;

import main.World;

public class Wolf extends Animal{
    public Wolf(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 9;
        this.initiative = 5;
        this.symbol = new String("W");
    }

}
