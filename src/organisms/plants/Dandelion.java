package organisms.plants;

import main.World;
import main.Constants;
import java.util.concurrent.ThreadLocalRandom;

public class Dandelion extends Plant{
    public Dandelion(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 0;
        this.initiative = 0;
        this.symbol = new String("d");
    }

    public void Action() {
        this.age++;
        for (int i = 0; i < Constants.DANDELION_SPREAD_TRIES; i++) {
            int spread = ThreadLocalRandom.current().nextInt(Constants.PLANT_SPREAD_CHANCE);
            if (spread == 0) {
                Reproduce(this);
            }
        }
    }

}
