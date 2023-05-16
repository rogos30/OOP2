package main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardWindow implements ActionListener {
    JFrame frame;
    JLabel[][] labels;
    JTextField textX, textY;
    JButton nextTurnButton;
    DefaultListModel<String> listType;
    JList<String> list;
    int sizeX, sizeY;
    String boardType = new String();
    World world;
    public BoardWindow(World world) {
        this.world = world;
        System.out.println(world.GetSizeX()+"gowno");
        frame = new JFrame("Author: Igor Rogozinski, 193326");
        frame.setSize (1280, 720);

        labels = new JLabel[world.GetSizeY()][];
        for (int i=0; i<world.GetSizeY(); i++) {
            labels[i] = new JLabel[world.GetSizeX()];
            for (int j=0; j<world.GetSizeX(); j++) {
                System.out.println("y: "+i+", x: "+j + ", yCoords: " + i*3/4*frame.getHeight()/world.GetSizeY() + ", xCoords: " + j*3/4*frame.getWidth()/world.GetSizeX());
                labels[i][j] = new JLabel();
                labels[i][j].setBounds(50+(j+1)*3/4*frame.getWidth()/world.GetSizeX(), 30+(i+1)*3/4*frame.getHeight()/world.GetSizeY(), frame.getWidth()/world.GetSizeX(), frame.getHeight()/world.GetSizeY());
                labels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                labels[i][j].setBorder(new LineBorder(Color.BLACK));
                /*if (world.GetBoardAt(j, i)!= null) {
                    labels[i][j].setText(world.GetBoardAt(j, i).GetSymbol());
                }*/
                int a=i*world.GetSizeX() + j;
                labels[i][j].setText(""+a);
                frame.add(labels[i][j]);
            }
        }
        nextTurnButton = new JButton("Next Turn");
        nextTurnButton.setBounds(1000, 600, 150, 30);
        nextTurnButton.addActionListener(this);
        frame.add(nextTurnButton);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        world.SimulateTurn();
        for (int i=0; i<world.GetSizeY(); i++) {
            for (int j=0; j<world.GetSizeX(); j++) {
                if (world.GetBoardAt(j, i)!= null) {
                    labels[i][j].setText(world.GetBoardAt(j, i).GetSymbol());
                }
                else {
                    labels[i][j].setText("");
                }
            }
        }
    }
}
