package organisms.animals;

import main.World;
import organisms.Organism;

public abstract class Animal extends Organism {

    public Animal(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
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
            else {
                Collision(world.GetBoardAt(targetX, targetY));
            }
        }
    }

    public void Collision(Organism organism) {
        if (organism.GetSymbol() == this.symbol) {
            Reproduce(this);
        }
	    else if (organism.GetStrength() <= this.strength) {
            //WALKING INTO A WEAKER ORGANISM
            if (!organism.AttackReflected(this) && !organism.AttackAvoided()) {
                //STANDARD INTERACTION
                int enemyX = organism.GetPositionX();
                int enemyY = organism.GetPositionY();
                if (organism.StrengthBoost()) {
                    this.SetStrength(GetStrength() + 3);
                    System.out.print(this.GetSymbol() + " boosted their strength, because ");
                }
                world.Kill(organism);
                System.out.print(this.symbol + " killed " + organism.GetSymbol());
                if (organism.ReturnKill()) {
                    System.out.println(" and " + organism.GetSymbol() + " return-killed " + this.GetSymbol());
                    world.Kill(this);
                }
                else {
                    System.out.println();
                    world.Move(enemyX, enemyY, this);
                    SetPositionX(enemyX);
                    SetPositionY(enemyY);
                }
            }
            else if (!organism.AttackReflected(this) && organism.AttackAvoided()) {
                //WEAKER (ATTACKED) ORGANISM AVOIDED AN ATTACK
                if (GetPositionY() - 1 >= 0 && world.GetBoardAt(GetPositionX(), GetPositionY() - 1) == null) {
                    //ESCAPE UP
                    world.Move(GetPositionX(), GetPositionY() - 1, this);
                    SetPositionY(GetPositionY() - 1);
                    world.Move(GetPositionX(), GetPositionY() + 1, organism);
                    organism.SetPositionY(GetPositionY() + 1);
                    System.out.println(organism.GetSymbol() + " avoided " + GetSymbol() + "'s attack by going up");
                }
                else if (GetPositionY() + 1 < this.world.GetSizeY() && world.GetBoardAt(GetPositionX(), GetPositionY() + 1) == null) {
                    //ESCAPE DOWN
                    world.Move(GetPositionX(), GetPositionY() + 1, this);
                    SetPositionY(GetPositionY() + 1);
                    world.Move(GetPositionX(), GetPositionY() - 1, organism);
                    organism.SetPositionY(GetPositionY() - 1);
                    System.out.println(organism.GetSymbol() + " avoided " + GetSymbol() + "'s attack by going down");
                }
			else if (GetPositionX() - 1 >= 0 && world.GetBoardAt(GetPositionX() - 1, GetPositionY()) == null) {
                    //ESCAPE LEFT
                    world.Move(GetPositionX() - 1, GetPositionY(), this);
                    SetPositionX(GetPositionX() - 1);
                    world.Move(GetPositionX() + 1, GetPositionY(), organism);
                    organism.SetPositionX(GetPositionX() + 1);
                    System.out.println(organism.GetSymbol() + " avoided " + GetSymbol() + "'s attack by going left");
                }
                else if (GetPositionX() + 1 < this.world.GetSizeX() && world.GetBoardAt(GetPositionX() + 1, GetPositionY()) == null) {
                    //ESCAPE RIGHT
                    world.Move(GetPositionX() + 1, GetPositionY(), this);
                    SetPositionX(GetPositionX() + 1);
                    world.Move(GetPositionX() - 1, GetPositionY(), organism);
                    organism.SetPositionX(GetPositionX() - 1);
                    System.out.println(organism.GetSymbol() + " avoided " + GetSymbol() + "'s attack by going right");
                }
			else {
                    //NO ESCAPE
                    int enemyX = organism.GetPositionX();
                    int enemyY = organism.GetPositionY();
                    if (organism.StrengthBoost()) {
                        this.SetStrength(GetStrength() + 3);
                        System.out.print(this.GetSymbol() + " boosted their strength, because ");
                    }
                    world.Kill(organism);
                    System.out.print(this.symbol + " couldn't escape " + organism.GetSymbol());
                    if (organism.ReturnKill()) {
                        System.out.print(" and " + organism.GetSymbol() + " return-killed " + this.GetSymbol());
                        world.Kill(this);
                    }
                    else {
                        world.Move(enemyX, enemyY, this);
                        SetPositionX(enemyX);
                        SetPositionY(enemyY);
                    }
                    System.out.println();
                }
            }
            else if (organism.AttackReflected(this) && !organism.AttackAvoided())
                System.out.println(organism.GetSymbol() + " reflected " + GetSymbol() + "'s attack");
        }
	    else {
            //WALKED INTO A STRONGER ORGANISM
            if (!AttackReflected(organism)) {
                if (this.StrengthBoost()) {
                    organism.SetStrength(GetStrength() + 3);
                    System.out.print(organism.GetSymbol() + " boosted their strength, because ");
                }
                world.Kill(this);
                System.out.println(this.symbol + " walked into " + organism.GetSymbol() + " and died");
            }
            else System.out.println(this.symbol + " walked into " + organism.GetSymbol() + " and reflected their attack");
        }
    }
}
