package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private int state = 1;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_Q)
        {
            this.state = 1;
        }
        if (code == KeyEvent.VK_W)
        {
            this.state = 2;
        }
        if (code == KeyEvent.VK_E)
        {
            this.state = 3;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getState ()
    {
        return this.state;
    }
}