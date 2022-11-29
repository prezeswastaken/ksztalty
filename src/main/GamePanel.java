package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.net.SocketOption;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 4;
                //Tile size = 64
    final public int tileSize = originalTileSize * scale;
    final int maxScreenCol = 18;
    final int maxScreenRow = 14;

    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyHandler);

    public GamePanel () {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }


    public void startGameThread (){

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        while (gameThread != null)
        {
             update();

             repaint();
        }

    }

    public void update()
    {
        player.update();

    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2  = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();

    }
}