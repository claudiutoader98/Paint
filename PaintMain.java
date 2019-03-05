package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Paint");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        PaintPanel paintPanel = new PaintPanel();


        JButton plusButton = new JButton("+");
        plusButton.setMargin( new Insets(0, 0, 0, 0) );
        plusButton.setBounds(10, 7, 13, 13);

        JButton minusButton = new JButton("-");
        minusButton.setMargin( new Insets(0, 0, 0, 0) );
        minusButton.setBounds(10, 25, 13 , 13);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(25, 20, 25, 15);
        textArea.setText(String.valueOf(paintPanel.getSizeFromPaint()));
        textArea.setEditable(false);

        JLabel textAreaTitle = new JLabel("Size");
        textAreaTitle.setBounds(25, 5, 25, 15);

        JLabel textCurrentShape = new JLabel("Current shape");
        textCurrentShape.setBounds(60, 5, 90, 15);

        String[] values = {"Line", "Ellipse", "Rectangle"};

        JComboBox<String> shapes = new JComboBox(values);
        shapes.setBounds(60, 20, 85, 18);


        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(paintPanel.getSizeFromPaint() < 4) {
                    paintPanel.setSizeForPaint(Integer.valueOf(textArea.getText()) + 1);
                    textArea.setText(String.valueOf(paintPanel.getSizeFromPaint()));
                }
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(paintPanel.getSizeFromPaint() > 1){
                    paintPanel.setSizeForPaint(Integer.valueOf(textArea.getText()) - 1);
                    textArea.setText(String.valueOf(paintPanel.getSizeFromPaint()));
                }
            }
        });

        shapes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.chooseShape(shapes.getSelectedIndex());
            }
        });


        JPanel panel1 = new JPanel();
        panel1.add(paintPanel);

        panel1.setBounds(0, 40, 900, 600);
        mainPanel.add(panel1);
        mainPanel.add(plusButton);
        mainPanel.add(minusButton);
        mainPanel.add(textArea);
        mainPanel.add(textAreaTitle);
        mainPanel.add(textCurrentShape);
        mainPanel.add(shapes);

        frame.setContentPane(mainPanel);
        frame.setPreferredSize(new Dimension(910, 640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
