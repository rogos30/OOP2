package organisms.animals;

import main.World;

public class Fox extends Animal{
    public Fox(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 3;
        this.initiative = 7;
        this.symbol = new String("F");
    }

    public void Action() {
        this.age++;
        int[] coords = GetRandomNeighbourCoords();
        int targetX = coords[0], targetY = coords[1];

        if (targetX != -1 && targetY != -1) {
            if (world.GetBoardAt(targetX, targetY) == null) {
                world.Move(targetX, targetY, this);
                SetPositionX(targetX); SetPositionY(targetY);
            }
            else if (this.world.GetBoardAt(targetX, targetY).GetStrength() <= this.strength){
                Collision(world.GetBoardAt(targetX, targetY));
            }
        }
    }
}
