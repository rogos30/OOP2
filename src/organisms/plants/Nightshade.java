package organisms.plants;

import main.World;
import main.Constants;
import java.util.concurrent.ThreadLocalRandom;

public class Nightshade extends Plant{
    public Nightshade(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 99;
        this.initiative = 0;
        this.symbol = new String("n");
    }

    public boolean ReturnKill() {
        return true;
    }

}
