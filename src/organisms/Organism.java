package organisms;

import main.Constants;
import main.World;
import organisms.animals.*;
import organisms.plants.*;

import java.util.concurrent.ThreadLocalRandom;


public abstract class Organism {
    protected int strength, initiative, positionX, positionY, age = 0;
    protected String symbol;
    protected World world;

    public Organism(int positionX, int positionY, World world) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.world = world;
    }

    public abstract void Action();

    public void Reproduce(Organism organism) {
        int[] coords = GetRandomNeighbourCoords();
        int targetX = coords[0], targetY = coords[1];

        if (targetX!= -1 && targetY!= -1 && this.world.GetBoardAt(targetX, targetY) == null) {
            if (organism instanceof Antelope) {
                Antelope baby = new Antelope(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Fox) {
                Fox baby = new Fox(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Sheep) {
                Sheep baby = new Sheep(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Turtle) {
                Turtle baby = new Turtle(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Wolf) {
                Wolf baby = new Wolf(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Grass) {
                Grass baby = new Grass(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Dandelion) {
                Dandelion baby = new Dandelion(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Guarana) {
                Guarana baby = new Guarana(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Hogweed) {
                Hogweed baby = new Hogweed(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
            else if (organism instanceof Nightshade) {
                Nightshade baby = new Nightshade(targetX, targetY, world);
                world.AddOrganism(baby, baby.GetPositionX(), baby.GetPositionY());
            }
        }
    }
    public int[] GetRandomNeighbourCoords() {
        int direction = ThreadLocalRandom.current().nextInt(this.GetWorld().GetFieldSides());

        int[] coords = {-1, -1};
        //-1, -1 WILL ONLY RETURN IN CASE THERE ARE NO NEIGHBOURS (BOARD 1x1)
        switch (direction) {
            case Constants.UP:
                if (GetPositionY() - 1 >= 0) {
                    coords[0]=GetPositionX(); coords[1]=GetPositionY() - 1;
                }
                break;
            case Constants.DOWN:
                if (GetPositionY() + 1 < this.world.GetSizeY()) {
                    coords[0]=GetPositionX(); coords[1]=GetPositionY() + 1;
                }
                break;
            case Constants.LEFT:
                if (GetPositionX() - 1 >= 0) {
                    coords[0]=GetPositionX() - 1; coords[1]=GetPositionY();
                }
                break;
            case Constants.RIGHT:
                if (GetPositionX() + 1 < this.world.GetSizeX()) {
                    coords[0]=GetPositionX() + 1; coords[1]=GetPositionY();
                }
                break;
            case Constants.UP_ADDITIONAL:
                if (GetPositionX()%2 == 1) {
                    if (GetPositionX() + 1 < this.world.GetSizeX() && GetPositionY() - 1 >= 0) {
                        coords[0]=GetPositionX() + 1; coords[1]=GetPositionY() - 1;
                    }
                }
                else {
                    if (GetPositionX() - 1 >= 0 && GetPositionY() - 1 >= 0) {
                        coords[0]=GetPositionX() - 1; coords[1]=GetPositionY() - 1;
                    }
                }
                break;
            case Constants.DOWN_ADDITIONAL:
                if (GetPositionX()%2 == 1) {
                    if (GetPositionX() + 1 < this.world.GetSizeX() && GetPositionY() + 1 < this.world.GetSizeY()) {
                        coords[0]=GetPositionX() + 1; coords[1]=GetPositionY() + 1;
                    }
                }
                else {
                    if (GetPositionX() - 1 >= 0 && GetPositionY() + 1 < this.world.GetSizeY()) {
                        coords[0]=GetPositionX() - 1; coords[1]=GetPositionY() + 1;
                    }
                }
                break;
        }
        return coords;
    }

    public boolean AttackReflected(Organism attacker) {
        return false;
    }

    public boolean AttackAvoided() {
        return false;
    }

    public boolean StrengthBoost() {
        return false;
    }

    public boolean ReturnKill() {
        return false;
    }

    public void ConsoleDraw() {
        System.out.print(symbol);
    }

    public int GetStrength() {
        return strength;
    }

    public void SetStrength(int strength) {
        this.strength = strength;
    }

    public int GetInitiative() {
        return initiative;
    }

    public void SetInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int GetAge() {
        return age;
    }

    public int GetPositionX() {
        return positionX;
    }

    public void SetPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int GetPositionY() {
        return positionY;
    }

    public void SetPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String GetSymbol() {
        return symbol;
    }

    public World GetWorld() {
        return world;
    }
}
