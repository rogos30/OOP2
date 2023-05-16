package organisms.plants;

import main.World;
import main.Constants;
import java.util.concurrent.ThreadLocalRandom;
import organisms.animals.Animal;

public class Hogweed extends Plant{
    public Hogweed(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 10;
        this.initiative = 0;
        this.symbol = new String("h");
    }

    public boolean ReturnKill() {
        return true;
    }

    public void Action() {
        this.age++;
        //KILLING ANIMALS AROUND IT
        if (GetPositionY() - 1 >= 0 && world.GetBoardAt(GetPositionX(), GetPositionY() - 1) instanceof Animal) {
            world.Kill(world.GetBoardAt(GetPositionX(), GetPositionY() - 1));
        }
        if (GetPositionY() + 1 < this.world.GetSizeY() && world.GetBoardAt(GetPositionX(), GetPositionY() + 1) instanceof Animal) {
            world.Kill(world.GetBoardAt(GetPositionX(), GetPositionY() + 1));
        }
        if (GetPositionX() - 1 >= 0 && world.GetBoardAt(GetPositionX() - 1, GetPositionY()) instanceof Animal) {
            world.Kill(world.GetBoardAt(GetPositionX() - 1, GetPositionY()));
        }
        if (GetPositionX() + 1 < this.world.GetSizeX() && world.GetBoardAt(GetPositionX() + 1, GetPositionY()) instanceof Animal) {
            world.Kill(world.GetBoardAt(GetPositionX() + 1, GetPositionY()));
        }

        int spread = ThreadLocalRandom.current().nextInt(Constants.PLANT_SPREAD_CHANCE);
        if (spread == 0) {
            Reproduce(this);
        }
    }

}
