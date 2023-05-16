package organisms.animals;

import main.World;

public class Sheep extends Animal{
    public Sheep(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 4;
        this.initiative = 4;
        this.symbol = new String("S");
    }

}
