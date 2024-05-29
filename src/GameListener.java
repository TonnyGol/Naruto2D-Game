import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListener implements KeyListener {
    private GamePanel game;

    public GameListener(GamePanel game){
        this.game = game;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();

        if(keyPressed == KeyEvent.VK_ESCAPE){
            System.out.println("Escape Pressed");
            this.game.setFocusable(false);
            this.game.setVisible(false);
            WindowFrame.gameRuns = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
