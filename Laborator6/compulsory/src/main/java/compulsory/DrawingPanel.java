package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.sql.Connection;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows;
    int cols;
    int canvasWidth = 400;
    int canvasHeight = 400;
    int boardWidth;
    int boardHeight;
    int cellWidth;
    int cellHeight;
    int padX;
    int padY;
    int stoneSize = 20;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(),
                frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        //paintSticks(g);
        //paintStones(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            g.drawLine(x1, y1, x2, y1);
        }
        //vertical lines
        for(int col=0; col<cols; col++){
            int x1 = padX + cols * boardWidth;
            int y1 = padY;
            int y2 = padY + cellHeight;
            g.drawLine(x1,y1,x1,y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }

    }
}
