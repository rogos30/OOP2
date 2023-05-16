package main;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroWindow implements ActionListener {
    JFrame frame;
    JLabel labelX, labelY, labelType;
    JTextField textX, textY;
    JButton button;
    DefaultListModel<String> listType;
    JList<String> list;
    int sizeX, sizeY;
    String boardType = new String();
    World world;

    public IntroWindow() {
        frame = new JFrame("Insert board parameters:");
        frame.setSize (720, 180);

        labelX = new JLabel("Enter width: ");
        labelX.setBounds(50,50, 150,30);
        textX = new JTextField("20");
        textX.setBounds(125,50, 50,30);

        labelY = new JLabel("Enter height: ");
        labelY.setBounds(225,50, 150,30);
        textY = new JTextField("20");
        textY.setBounds(300,50, 50,30);

        labelType = new JLabel("Select a board type:");
        labelType.setBounds(400, 50, 200, 30);
        listType = new DefaultListModel<>();
        listType.addElement("square"); listType.addElement("hexagonal");
        list = new JList<>(listType);
        list.setSelectedIndex(0);
        list.setBounds(600,47,175,36);

        button = new JButton("Confirm");
        button.setBounds(500, 100, 150, 30);
        button.addActionListener(this);


        frame.add(labelX); frame.add(labelY); frame.add(labelType);
        frame.add(textX); frame.add(textY); frame.add(list); frame.add(button);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        try {
            sizeX=Integer.parseInt(textX.getText());
            sizeY=Integer.parseInt(textY.getText());
            boardType = list.getSelectedValue();
            if (sizeX>0 && sizeY>0) frame.dispose();
            world = new World (sizeX, sizeY, GetBoardType().equals("hexagonal"));
        } catch (NumberFormatException error) {
            System.out.println("wrong input");
        }
    }

    public int GetSizeX() { return sizeX; }
    public int GetSizeY() { return sizeY; }

    public String GetBoardType() { return boardType; }

    public World GetWorld() { return world; }

}
