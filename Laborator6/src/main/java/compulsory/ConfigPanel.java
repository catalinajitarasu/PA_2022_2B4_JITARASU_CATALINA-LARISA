package compulsory;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    MainFrame frame = null;
    JLabel label;
    JSpinner spinner;
    JSpinner spinner2;
    JButton button;
    int rows,cols;

    public ConfigPanel() {
        this.frame = frame;
        init();
    }
    private void init() {
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        setCols(8);
        spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        setRows(8);
        button = new JButton("Create");
        button.setBounds(50,100,95,30);

        add(button);
        add(label);
        add(spinner);
        add(spinner2);
    }


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
