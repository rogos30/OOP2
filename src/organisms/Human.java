package organisms;

import organisms.animals.Animal;
import main.World;
import main.Constants;

public class Human extends Animal{
    private int abilityCooldown;

    public Human(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 5;
        this.initiative = 4;
        this.abilityCooldown = 0;
        this.symbol = new String("H");
    }

    public void Action() {
        this.age++;
        world.SetHumanAlive(true);
        if (GetAbilityCooldown() >= 5) SetStrength(GetAbilityCooldown());
        SetAbilityCooldown(GetAbilityCooldown() - 1);

        char direction = world.GetInput();
        switch (direction) {
            case Constants.UP_ARROW:
                if (GetPositionY() - 1 >= 0) {
                    if (world.GetBoardAt(GetPositionX(), GetPositionY() - 1) == null) {
                        world.Move(GetPositionX(), GetPositionY() - 1, this);
                        SetPositionY(GetPositionY() - 1);
                    }
                    else {
                        Collision(world.GetBoardAt(GetPositionX(), GetPositionY() - 1));
                    }
                }
                break;
            case Constants.DOWN_ARROW:
                if (GetPositionY() + 1 < this.world.GetSizeY()) {
                if (world.GetBoardAt(GetPositionX(), GetPositionY() + 1) == null) {
                    world.Move(GetPositionX(), GetPositionY() + 1, this);
                    SetPositionY(GetPositionY() + 1);
                }
                else {
                    Collision(world.GetBoardAt(GetPositionX(), GetPositionY() + 1));
                }
            }
            break;
            case Constants.LEFT_ARROW:
                if (GetPositionX() - 1 >= 0) {
                    if (world.GetBoardAt(GetPositionX() - 1, GetPositionY()) == null) {
                        world.Move(GetPositionX() - 1, GetPositionY(), this);
                        SetPositionX(GetPositionX() - 1);
                    }
                    else {
                        Collision(world.GetBoardAt(GetPositionX() - 1, GetPositionY()));
                    }
                }
                break;
            case Constants.RIGHT_ARROW:
                if (GetPositionX() + 1 < this.world.GetSizeX()) {
                if (world.GetBoardAt(GetPositionX() + 1, GetPositionY()) == null) {
                    world.Move(GetPositionX() + 1, GetPositionY(), this);
                    SetPositionX(GetPositionX() + 1);
                }
                else {
                    Collision(world.GetBoardAt(GetPositionX() + 1, GetPositionY()));
                }
            }
            break;
            case Constants.SPACE:
                Ability();
                break;
        }
        System.out.println("Human strength: " + GetStrength());
        System.out.println("Human cooldown: " + GetAbilityCooldown());
    }

    public void Ability() {
        if (GetAbilityCooldown()<=0) SetAbilityCooldown(10);
    }

    public int GetAbilityCooldown() {
        return abilityCooldown;
    }

    public void SetAbilityCooldown(int cooldown) {
        abilityCooldown = cooldown;
    }
}
