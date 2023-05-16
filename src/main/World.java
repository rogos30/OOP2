package main;

import organisms.Organism;

public class World {
    private final int sizeX, sizeY;
    private int turn=0, fieldSides;
    private final Organism[][] board;
    private final LinkedList organisms;
    private boolean humanAlive = true, hex;
    private char input;


    public World(int sizeX, int sizeY, boolean hex) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.hex = hex;
        if (hex) this.fieldSides = 6;
        else this.fieldSides = 4;
        this.turn = 0;
        this.input = 0;

        board = new Organism[sizeY][sizeX];
        organisms = new LinkedList();
    }

    public void SimulateTurn() {
        this.SetHumanAlive(false);

        Node node = organisms.GetHead();
        while (node != null) {
            if (node.GetOrganism()!=null) node.GetOrganism().Action();
            node = node.GetNext();
        }
        this.DrawWorld();
        //organisms.Print();
        turn++;
    }

    public void DrawWorld() {
        /*System.out.println("Author: Igor Rogozinski, 193326, group 3");
        System.out.println(turn + ". turn");
        for (int i = 0; i < sizeX + 2; i++) System.out.print("#");
        System.out.println();
        for (int i = 0; i < sizeY; i++) {
            System.out.print("#");
            for (int j = 0; j < sizeX; j++) {
                if (board[i][j] != null) {
                    board[i][j].ConsoleDraw();
                }
                else System.out.print(" ");
            }
            System.out.println("#");
        }
        for (int i = 0; i < sizeX + 2; i++) System.out.print("#");
        System.out.println(); */
    }

    public void AddOrganism(Organism organism, int positionX, int positionY) {
        board[positionY][positionX] = organism;
        organism.SetPositionX(positionX);
        organism.SetPositionY(positionY);
        organisms.Add(organism);
    }

    public void Kill(Organism organism) {
        board[organism.GetPositionY()][organism.GetPositionX()] = null;
        organisms.Remove(organism);
    }

    public void Move(int destinationX, int destinationY, Organism organism) {
        System.out.println(organism.GetSymbol() + " moved from (" + organism.GetPositionX() + ", " + organism.GetPositionY() + ") to (" + destinationX + ", " + destinationY + ")");
        board[organism.GetPositionY()][organism.GetPositionX()] = null;
        board[destinationY][destinationX] = organism;
    }

    public void SaveGame() {
        // TO DO
    }

    public void LoadGame() {
        // TO DO
    }

    public int GetTurn() {
        return turn;
    }

    public int GetFieldSides() {
        return fieldSides;
    }

    public int GetSizeX() {
        return sizeX;
    }

    public int GetSizeY() {
        return sizeY;
    }

    public char GetInput() {
        return input;
    }

    public void SetInput(char ch) {
        this.input = ch;
    }

    public boolean GetHumanAlive() {
        return humanAlive;
    }

    public void SetHumanAlive(boolean humanAlive) {
        this.humanAlive = humanAlive;
    }

    public boolean IsHex() { return hex; }

    public LinkedList GetOrganisms() {
        return organisms;
    }

    public Organism GetBoardAt(int positionX, int positionY) {
        return board[positionY][positionX];
    }

}
