package entity;

import main.FPS;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {


    KeyHandler keyHandler;

    public Player (GamePanel gamePanel, KeyHandler keyHandler)
    {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultPosition();
        getPlayerImage();
    }

    public void setDefaultPosition ()
    {
        x = 100;
        y = 400;
        state = 1;
    }

    public void getPlayerImage()
    {
        try
        {
           // System.out.println("image loading started");
            bufferedImages.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/1P.png")));
            bufferedImages.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/2P.png")));
            bufferedImages.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/3P.png")));

           // System.out.println("image loading ended");
        } catch (IOException e)
        {
            System.out.println("ERROR!");
        }
    }

    int n = 0;
    public void update ()
    {


    }

    public void draw (Graphics2D g2)
    {
        switch (keyHandler.getState())
        {
            case 1 -> this.state = 1;
            case 2 -> this.state = 2;
            case 3 -> this.state = 3;
        }

        BufferedImage image = switch (state)
                {
                    case 1 -> bufferedImages.get(0);
                    case 2 -> bufferedImages.get(1);
                    case 3 -> bufferedImages.get(2);
                    default -> null;
                };

        if (alive)
        {
            g2.drawImage(image, x,y,gamePanel.getTileSize(),gamePanel.getTileSize(),null);
        }


    }

    public void makeAlive ()
    {
        alive = true;
    }



}
