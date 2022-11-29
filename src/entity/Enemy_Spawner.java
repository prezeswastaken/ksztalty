package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;



public class Enemy_Spawner extends Entity {

    private final GamePanel gamePanel;

    public Enemy_Spawner (GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;

        setDefaultPosition();
        getSpawnerImage();
    }

    public void setDefaultPosition ()
    {
        x = 900;
        y = 400;
        state = 1;
    }

    public void getSpawnerImage()
    {
        try
        {
            System.out.println("spawner image loading started");
            s1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("enemy/enemy_spawner.png"));

            System.out.println("spawner image loading ended");
        } catch (IOException e)
        {
            System.out.println("ERROR!");
        }
    }

    public void update ()
    {


    }
    public void draw (Graphics2D g2)
    {
        BufferedImage image = s1;

        g2.drawImage(image, x,y,gamePanel.tileSize,gamePanel.tileSize,null);

    }
}