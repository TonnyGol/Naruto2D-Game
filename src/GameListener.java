import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListener implements KeyListener {
    private GamePanel game;
    private Character character;

    public GameListener(GamePanel game, Character character){
        this.game = game;
        this.character = character;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();

        switch (keyPressed) {
            case KeyEvent.VK_W:
                character.moveUp();
                this.game.setCharacterMoves(true);
                break;
            case KeyEvent.VK_S:
                character.moveDown();
                this.game.setCharacterMoves(true);
                break;
            case KeyEvent.VK_A:
                character.moveLeft();
                this.game.setCharacterMoves(true);
                this.game.setCharacterMovesBack(true);
                break;
            case KeyEvent.VK_D:
                character.moveRight();
                this.game.setCharacterMoves(true);
                this.game.setCharacterMovesBack(false);
                break;
            case KeyEvent.VK_ESCAPE:
                WindowFrame.switchPanels = true;
                System.out.println("Escape pressed - Pause Game");
                //WindowFrame.panelChoice = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.game.setCharacterMoves(false);
        Character.runFrame = 0;
        main.sleep(100);
    }
}
