package compulsory;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel=new ConfigPanel();
        canvas = new DrawingPanel(this);
        controlPanel=new ControlPanel(this);

        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(controlPanel,SOUTH);
        add(configPanel,NORTH);

        pack();
    }
}
