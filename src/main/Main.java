package main;

import organisms.Human;
import organisms.animals.*;
import organisms.plants.*;

public class Main {

    public static void main(String[] args) {
        int sizeX, sizeY;
        World world = null;

        IntroWindow introWindow = new IntroWindow();
        while (world == null) {
            sizeX = introWindow.GetSizeX();
            sizeY = introWindow.GetSizeY();
            //System.out.println(sizeX + " niewulgarnyDebug ;)");
            world = introWindow.GetWorld();
        }


        Human human1 = new Human(0, 0, world);
        if (human1.GetPositionX() >=0 && human1.GetPositionX() < world.GetSizeX() && human1.GetPositionY() >= 0 && human1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(human1, human1.GetPositionX(), human1.GetPositionY());

        Antelope antelope1 = new Antelope(13, 3, world);
        if (antelope1.GetPositionX() >= 0 && antelope1.GetPositionX() < world.GetSizeX() && antelope1.GetPositionY() >= 0 && antelope1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(antelope1, antelope1.GetPositionX(), antelope1.GetPositionY());

        Antelope antelope2 = new Antelope(3, 7, world);
        if (antelope2.GetPositionX() >= 0 && antelope2.GetPositionX() < world.GetSizeX() && antelope2.GetPositionY() >= 0 && antelope2.GetPositionY() < world.GetSizeY())
            world.AddOrganism(antelope2, antelope2.GetPositionX(), antelope2.GetPositionY());


        Guarana guarana1 = new Guarana(5, 2, world);
        if (guarana1.GetPositionX() >= 0 && guarana1.GetPositionX() < world.GetSizeX() && guarana1.GetPositionY() >= 0 && guarana1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(guarana1, guarana1.GetPositionX(), guarana1.GetPositionY());

        Guarana guarana2 = new Guarana(11, 13, world);
        if (guarana2.GetPositionX() >= 0 && guarana2.GetPositionX() < world.GetSizeX() && guarana2.GetPositionY() >= 0 && guarana2.GetPositionY() < world.GetSizeY())
            world.AddOrganism(guarana2, guarana2.GetPositionX(), guarana2.GetPositionY());



        Nightshade nightshade1 = new Nightshade(17, 7, world);
        if (nightshade1.GetPositionX() >= 0 && nightshade1.GetPositionX() < world.GetSizeX() && nightshade1.GetPositionY() >= 0 && nightshade1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(nightshade1, nightshade1.GetPositionX(), nightshade1.GetPositionY());



        Sheep sheep1 = new Sheep(3, 3, world);
        if (sheep1.GetPositionX() >= 0 && sheep1.GetPositionX() < world.GetSizeX() && sheep1.GetPositionY() >= 0 && sheep1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(sheep1, sheep1.GetPositionX(), sheep1.GetPositionY());

        Sheep sheep2 = new Sheep(13, 4, world);
        if (sheep2.GetPositionX() >= 0 && sheep2.GetPositionX() < world.GetSizeX() && sheep2.GetPositionY() >= 0 && sheep2.GetPositionY() < world.GetSizeY())
            world.AddOrganism(sheep2, sheep2.GetPositionX(), sheep2.GetPositionY());

        Sheep sheep3 = new Sheep(10, 9, world);
        if (sheep3.GetPositionX() >= 0 && sheep3.GetPositionX() < world.GetSizeX() && sheep3.GetPositionY() >= 0 && sheep3.GetPositionY() < world.GetSizeY())
            world.AddOrganism(sheep3, sheep3.GetPositionX(), sheep3.GetPositionY());

        Sheep sheep4 = new Sheep(2, 7, world);
        if (sheep4.GetPositionX() >= 0 && sheep4.GetPositionX() < world.GetSizeX() && sheep4.GetPositionY() >= 0 && sheep4.GetPositionY() < world.GetSizeY())
            world.AddOrganism(sheep4, sheep4.GetPositionX(), sheep4.GetPositionY());



        Wolf wolf1 = new Wolf(10, 18, world);
        if (wolf1.GetPositionX() >= 0 && wolf1.GetPositionX() < world.GetSizeX() && wolf1.GetPositionY() >= 0 && wolf1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(wolf1, wolf1.GetPositionX(), wolf1.GetPositionY());

        Wolf wolf2 = new Wolf(15, 15, world);
        if (wolf2.GetPositionX() >= 0 && wolf2.GetPositionX() < world.GetSizeX() && wolf2.GetPositionY() >= 0 && wolf2.GetPositionY() < world.GetSizeY())
            world.AddOrganism(wolf2, wolf2.GetPositionX(), wolf2.GetPositionY());



        Turtle turtle1 = new Turtle(5, 5, world);
        if (turtle1.GetPositionX() >= 0 && turtle1.GetPositionX() < world.GetSizeX() && turtle1.GetPositionY() >= 0 && turtle1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(turtle1, turtle1.GetPositionX(), turtle1.GetPositionY());



        Hogweed hogweed1 = new Hogweed(17, 7, world);
        if (hogweed1.GetPositionX() >= 0 && hogweed1.GetPositionX() < world.GetSizeX() && hogweed1.GetPositionY() >= 0 && hogweed1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(hogweed1, hogweed1.GetPositionX(), hogweed1.GetPositionY());

        Hogweed hogweed2 = new Hogweed(15, 5, world);
        if (hogweed2.GetPositionX() >= 0 && hogweed2.GetPositionX() < world.GetSizeX() && hogweed2.GetPositionY() >= 0 && hogweed2.GetPositionY() < world.GetSizeY())
            world.AddOrganism(hogweed2, hogweed2.GetPositionX(), hogweed2.GetPositionY());







        Grass grass1 = new Grass(2, 1, world);
        if (grass1.GetPositionX() >= 0 && grass1.GetPositionX() < world.GetSizeX() && grass1.GetPositionY() >= 0 && grass1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(grass1, grass1.GetPositionX(), grass1.GetPositionY());

        Grass grass2 = new Grass(3, 18, world);
        if (grass2.GetPositionX() >= 0 && grass2.GetPositionX() < world.GetSizeX() && grass2.GetPositionY() >= 0 && grass2.GetPositionY() < world.GetSizeY())
            world.AddOrganism(grass2, grass2.GetPositionX(), grass2.GetPositionY());


        Fox fox1 = new Fox(2, 15, world);
        if (fox1.GetPositionX() >= 0 && fox1.GetPositionX() < world.GetSizeX() && fox1.GetPositionY() >= 0 && fox1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(fox1, fox1.GetPositionX(), fox1.GetPositionY());


        Dandelion dandelion1 = new Dandelion(0, 19, world);
        if (dandelion1.GetPositionX() >= 0 && dandelion1.GetPositionX() < world.GetSizeX() && dandelion1.GetPositionY() >= 0 && dandelion1.GetPositionY() < world.GetSizeY())
            world.AddOrganism(dandelion1, dandelion1.GetPositionX(), dandelion1.GetPositionY());

        Dandelion dandelion2 = new Dandelion(10, 0, world);
        if (dandelion2.GetPositionX() >= 0 && dandelion2.GetPositionX() < world.GetSizeX() && dandelion2.GetPositionY() >= 0 && dandelion2.GetPositionY() < world.GetSizeY())
            world.AddOrganism(dandelion2, dandelion2.GetPositionX(), dandelion2.GetPositionY());

        world.DrawWorld();

        BoardWindow boardWindow = new BoardWindow(world);
        String userInput;
    }
}
