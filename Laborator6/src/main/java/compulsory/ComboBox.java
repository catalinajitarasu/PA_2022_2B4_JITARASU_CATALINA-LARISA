package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox extends JPanel {

    private int rows;
    private int columns;
    private boolean pressed = false;
    private int[] values = {4, 5, 6, 7, 8};
    private JTextField heading1 = new JTextField("Grid size:");
    private JComboBox boxOfValue1 = new JComboBox();
    private JComboBox boxOfValue2 = new JComboBox();
    private JButton createButton = new JButton("Create");
    private JButton[][] btn;

    public ComboBox() {
        for (int i = 0; i < values.length; i++) {
            boxOfValue1.addItem(values[i]);
            boxOfValue2.addItem(values[i]);
        }

        heading1.setEditable(false);

        boxOfValue1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rows = (Integer) (((JComboBox) e.getSource()).getSelectedItem());
            }
        });

        boxOfValue2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                columns = rows = (Integer) (((JComboBox) e.getSource()).getSelectedItem());
            }
        });

        createButton.addActionListener(e->{
            this.add(new PlayBoard(rows, columns));
            this.revalidate();
        });

        this.setLayout(new FlowLayout());
        this.add(heading1);
        this.add(boxOfValue1);
        this.add(boxOfValue2);
        this.add(createButton);
    }

}
