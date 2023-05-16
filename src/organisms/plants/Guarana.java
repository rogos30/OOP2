package organisms.plants;

import main.World;
import main.Constants;
import java.util.concurrent.ThreadLocalRandom;

public class Guarana extends Plant{
    public Guarana(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 0;
        this.initiative = 0;
        this.symbol = new String("u");
    }

    public boolean StrengthBoost() {
        return true;
    }

}
