package organisms.plants;

import main.World;

public class Grass extends Plant{
    public Grass(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 5;
        this.initiative = 0;
        this.symbol = new String("g");
    }
}
