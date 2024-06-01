import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouseListener implements MouseListener {
    private final GamePanel game;
    private final Character character;

    public GameMouseListener(GamePanel game, Character character){
        this.game = game;
        this.character = character;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int mouseCode = mouseEvent.getButton();
        if (mouseCode == MouseEvent.BUTTON1){
            this.game.setCharacterMoving(false);
            this.game.setCharacterAttacking(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.game.setCharacterAttacking(false);
        this.character.setAttackFrame(0);
        main.sleep(100);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
