package organisms.animals;

import main.World;
import main.Constants;
import java.util.concurrent.ThreadLocalRandom;
import organisms.Organism;

public class Turtle extends Animal{
    public Turtle(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 2;
        this.initiative = 1;
        this.symbol = new String("T");
    }

    public void Action() {
        this.age++;
        int[] coords = GetRandomNeighbourCoords();
        int moveChance = ThreadLocalRandom.current().nextInt(Constants.TURTLE_MOVE_CHANCE);
        int targetX = coords[0], targetY = coords[1];

        if (targetX != -1 && targetY != -1 && moveChance == 0) {
            if (world.GetBoardAt(targetX, targetY) == null) {
                world.Move(targetX, targetY, this);
                SetPositionX(targetX); SetPositionY(targetY);
            }
            else {
                Collision(world.GetBoardAt(targetX, targetY));
            }
        }
    }

    public boolean AttackReflected(Organism attacker) {
        return attacker.GetStrength() < 5;
    }
}
