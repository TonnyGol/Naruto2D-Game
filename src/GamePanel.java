import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final String IMAGES_FOLDER = "Images\\";
    private final String GAME_BG_FILE_NAME = "Game_BG.png";

    private final Image backgroundImage;

    private int width;
    private int height;
    private boolean characterMoves;
    private boolean characterMovesBack;
    private Character character;

    public GamePanel(int width, int height){
        this.width = width;
        this.height = height;
        this.characterMoves = false;
        this.characterMovesBack = false;
        this.setBounds(WindowFrame.DEFAULT_POSITION, WindowFrame.DEFAULT_POSITION + 100, this.width, this.height - 100);

        this.character = new Character(5, 600);
        this.backgroundImage = new ImageIcon(IMAGES_FOLDER+GAME_BG_FILE_NAME).getImage();

        this.mainGameLoop();
        this.addKeyListener(new GameListener(this, this.character));
        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.characterMoves){
            g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);
            if (this.characterMovesBack){
                this.character.paintRunBack(g);
            }else {
                this.character.paintRun(g);
            }
            main.sleep(40);
            this.loopCharacterRunFrames();
        }else {
            g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);
            this.character.paint(g);
        }
    }

    private void loopCharacterRunFrames(){
        Character.runFrame++;
        if (Character.runFrame % 6 == 0){
            Character.runFrame = 0;
        }
    }

    private void mainGameLoop(){
        new Thread(()->{
            while (true){
                if (WindowFrame.panelChoice == 1){
                    repaint();
                }
            }
        }).start();
    }

    public void setCharacterMoves(boolean characterMoves) {
        this.characterMoves = characterMoves;
    }

    public void setCharacterMovesBack(boolean characterMovesBack) {
        this.characterMovesBack = characterMovesBack;
    }
}
