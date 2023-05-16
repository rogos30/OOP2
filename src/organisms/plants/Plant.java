package organisms.plants;

import main.Constants;
import java.util.concurrent.ThreadLocalRandom;

import main.World;
import organisms.Organism;

public abstract class Plant extends Organism{
    public Plant(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
    }

    public void Action() {
        this.age++;
        int spread = ThreadLocalRandom.current().nextInt(Constants.PLANT_SPREAD_CHANCE);
        if (spread == 0) {
            Reproduce(this);
        }
    }

}
