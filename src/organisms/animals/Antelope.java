package organisms.animals;

import main.World;
import main.Constants;

import java.util.concurrent.ThreadLocalRandom;

public class Antelope extends Animal{
    public Antelope(int positionX, int positionY, World world) {
        super(positionX, positionY, world);
        this.strength = 4;
        this.initiative = 4;
        this.symbol = new String("A");
    }

    public void Action() {
        this.age++;
        int direction = ThreadLocalRandom.current().nextInt(this.GetWorld().GetFieldSides());
        switch (direction) {
            case Constants.UP -> {
                if (GetPositionY() - 2 >= 0) {
                    if (world.GetBoardAt(GetPositionX(), GetPositionY() - 1) == null) {
                        if (world.GetBoardAt(GetPositionX(), GetPositionY() - 2) == null) {
                            world.Move(GetPositionX(), GetPositionY() - 2, this);
                            SetPositionY(GetPositionY() - 2);
                        } else {
                            Collision(world.GetBoardAt(GetPositionX(), GetPositionY() - 2));
                        }
                    } else {
                        Collision(world.GetBoardAt(GetPositionX(), GetPositionY() - 1));
                    }
                }
            }
            case Constants.DOWN -> {
                if (GetPositionY() + 2 < this.world.GetSizeY()) {
                    if (world.GetBoardAt(GetPositionX(), GetPositionY() + 1) == null) {
                        if (world.GetBoardAt(GetPositionX(), GetPositionY() + 2) == null) {
                            world.Move(GetPositionX(), GetPositionY() + 2, this);
                            SetPositionY(GetPositionY() + 2);
                        } else {
                            Collision(world.GetBoardAt(GetPositionX(), GetPositionY() + 2));
                        }
                    } else {
                        Collision(world.GetBoardAt(GetPositionX(), GetPositionY() + 1));
                    }
                }
            }
            case Constants.LEFT -> {
                if (GetPositionX() - 2 >= 0) {
                    if (world.GetBoardAt(GetPositionX() - 1, GetPositionY()) == null) {
                        if (world.GetBoardAt(GetPositionX() - 2, GetPositionY()) == null) {
                            world.Move(GetPositionX() - 2, GetPositionY(), this);
                            SetPositionX(GetPositionX() - 2);
                        } else {
                            Collision(world.GetBoardAt(GetPositionX() - 2, GetPositionY()));
                        }
                    } else {
                        Collision(world.GetBoardAt(GetPositionX() - 1, GetPositionY()));
                    }
                }
            }
            case Constants.RIGHT -> {
                if (GetPositionX() + 2 < this.world.GetSizeX()) {
                    if (world.GetBoardAt(GetPositionX() + 1, GetPositionY()) == null) {
                        if (world.GetBoardAt(GetPositionX() + 2, GetPositionY()) == null) {
                            world.Move(GetPositionX() + 2, GetPositionY(), this);
                            SetPositionX(GetPositionX() + 2);
                        } else {
                            Collision(world.GetBoardAt(GetPositionX() + 2, GetPositionY()));
                        }
                    } else {
                        Collision(world.GetBoardAt(GetPositionX() + 1, GetPositionY()));
                    }
                }
            }
            case Constants.UP_ADDITIONAL -> {
                if (GetPositionY() % 2 == 0) {
                    if (GetPositionX() - 1 >= 0 && GetPositionY() - 2 >= 0) {
                        if (world.GetBoardAt(GetPositionX() - 1, GetPositionY() - 1) == null) {
                            if (world.GetBoardAt(GetPositionX() - 1, GetPositionY() - 2) == null) {
                                world.Move(GetPositionX() - 1, GetPositionY() - 2, this);
                                SetPositionX(GetPositionX() - 1); SetPositionY(GetPositionY() - 2);
                            } else {
                                Collision(world.GetBoardAt(GetPositionX() - 1, GetPositionY() - 2));
                            }
                        } else {
                            Collision(world.GetBoardAt(GetPositionX() - 1, GetPositionY() - 1));
                        }
                    }
                }
                else {
                    if (GetPositionX() + 1 >= 0 && GetPositionY() - 2 >= 0) {
                        if (world.GetBoardAt(GetPositionX() + 1, GetPositionY() - 1) == null) {
                            if (world.GetBoardAt(GetPositionX() + 1, GetPositionY() - 2) == null) {
                                world.Move(GetPositionX() + 1, GetPositionY() - 2, this);
                                SetPositionX(GetPositionX() + 1); SetPositionY(GetPositionY() - 2);
                            } else {
                                Collision(world.GetBoardAt(GetPositionX() + 1, GetPositionY() - 2));
                            }
                        } else {
                            Collision(world.GetBoardAt(GetPositionX() + 1, GetPositionY() - 1));
                        }
                    }
                }
            }
            case Constants.DOWN_ADDITIONAL -> {
                if (GetPositionY() % 2 == 0) {
                    if (GetPositionX() - 1 >= 0 && GetPositionY() + 2 >= 0) {
                        if (world.GetBoardAt(GetPositionX() - 1, GetPositionY() + 1) == null) {
                            if (world.GetBoardAt(GetPositionX() - 1, GetPositionY() + 2) == null) {
                                world.Move(GetPositionX() - 1, GetPositionY() + 2, this);
                                SetPositionX(GetPositionX() - 1); SetPositionY(GetPositionY() + 2);
                            } else {
                                Collision(world.GetBoardAt(GetPositionX() - 1, GetPositionY() + 2));
                            }
                        } else {
                            Collision(world.GetBoardAt(GetPositionX() - 1, GetPositionY() + 1));
                        }
                    }
                }
                else {
                    if (GetPositionX() + 1 >= 0 && GetPositionY() + 2 >= 0) {
                        if (world.GetBoardAt(GetPositionX() + 1, GetPositionY() + 1) == null) {
                            if (world.GetBoardAt(GetPositionX() + 1, GetPositionY() + 2) == null) {
                                world.Move(GetPositionX() + 1, GetPositionY() + 2, this);
                                SetPositionX(GetPositionX() + 1); SetPositionY(GetPositionY() + 2);
                            } else {
                                Collision(world.GetBoardAt(GetPositionX() + 1, GetPositionY() + 2));
                            }
                        } else {
                            Collision(world.GetBoardAt(GetPositionX() + 1, GetPositionY() + 1));
                        }
                    }
                }
            }
        }
    }

    public boolean AttackAvoided() {
        int avoided = ThreadLocalRandom.current().nextInt(2);
        return avoided == 1;
    }
}
