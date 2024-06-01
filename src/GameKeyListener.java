import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    private final GamePanel game;
    private final Character character;

    public GameKeyListener(GamePanel game, Character character){
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
                this.game.setCharacterMoving(true);
                character.setDy(-character.getCHARACTER_SPEED());
                character.setDx(0);
                break;
            case KeyEvent.VK_S:
                this.game.setCharacterMoving(true);
                character.setDy(character.getCHARACTER_SPEED());
                character.setDx(0);
                break;
            case KeyEvent.VK_A:
                this.game.setCharacterMoving(true);
                this.game.setCharacterMovingBack(true);
                character.setDx(-character.getCHARACTER_SPEED());
                character.setDy(0);
                break;
            case KeyEvent.VK_D:
                this.game.setCharacterMoving(true);
                this.game.setCharacterMovingBack(false);
                character.setDx(character.getCHARACTER_SPEED());
                character.setDy(0);
                break;
            case KeyEvent.VK_SPACE:
                this.game.setCharacterMoving(false);
                this.game.setCharacterJumping(true);
                this.character.setDx(150);
                break;
            case KeyEvent.VK_ESCAPE:
                WindowFrame.panelChoice = 0;
                WindowFrame.switchPanels = true;
                System.out.println("Escape pressed - Pause Game");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.game.setCharacterMoving(false);
        this.game.setCharacterJumping(false);
        this.character.setRunFrame(0);
        this.character.setDx(0);
        this.character.setDy(0);
        main.sleep(100);
    }
}
