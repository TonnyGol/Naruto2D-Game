import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final String IMAGES_FOLDER = "Images\\";
    private final String GAME_BG_FILE_NAME = "Game_BG.png";

    private boolean isCharacterMoving;
    private boolean isCharacterMovingBack;
    private boolean isCharacterAttacking;
    private boolean isCharacterJumping;

    private int width;
    private int height;
    private final Character character;
    private final Image backgroundImage;

    public GamePanel(int width, int height){
        this.width = width;
        this.height = height;
        this.isCharacterMoving = false;
        this.isCharacterMovingBack = false;
        this.isCharacterAttacking = false;
        this.isCharacterJumping = false;
        this.setBounds(0, 0, this.width, this.height);

        this.character = new Character(5, 600);
        this.backgroundImage = new ImageIcon(IMAGES_FOLDER+GAME_BG_FILE_NAME).getImage();

        this.mainGameLoop();
        this.addKeyListener(new GameKeyListener(this, this.character));
        this.addMouseListener(new GameMouseListener(this, this.character));
        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }

    private void characterJump(Graphics g){
        if (this.character.canMove()){
            this.character.move();
            this.character.paintJump(g);
            main.sleep(150);
            this.loopCharacterFrames();
        }else {
            this.character.paint(g);
        }
    }
    private void characterMove(Graphics g){
        if (this.character.canMove()){
            this.character.move();
            if (this.isCharacterMovingBack){
                this.character.paintRunBack(g);
            }else {
                this.character.paintRun(g);
            }
            main.sleep(50);
            this.loopCharacterFrames();
        }else {
            this.character.paint(g);
        }
    }
    private void characterAttack(Graphics g){
        this.character.paintAttack(g);
        main.sleep(100);
        this.loopCharacterFrames();
    }

    private void loopCharacterFrames(){
        if (this.isCharacterMoving){
            this.character.setRunFrame(this.character.getRunFrame() + 1);
            if (this.character.getRunFrame() % 6 == 0){
                this.character.setRunFrame(0);
            }
        } else if (this.isCharacterAttacking) {
            this.character.setAttackFrame(this.character.getAttackFrame() + 1);
            if (this.character.getAttackFrame() % 6 == 0){
                this.character.setAttackFrame(0);
            }
        } else if (this.isCharacterJumping) {
            this.character.setJumpFrame(this.character.getJumpFrame() + 1);
            if (this.character.getJumpFrame() == 2){
                this.character.setJumpFrame(0);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);
        if (this.isCharacterMoving){
            this.characterMove(g);
        } else if (this.isCharacterAttacking) {
            this.characterAttack(g);
        } else if (this.isCharacterJumping) {
            this.characterJump(g);
        } else {
            this.character.paint(g);
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

    public boolean isCharacterMoving() {
        return isCharacterMoving;
    }

    public boolean isCharacterAttacking() {
        return isCharacterAttacking;
    }

    public boolean isCharacterMovingBack() {
        return isCharacterMovingBack;
    }

    public boolean isCharacterJumping() {
        return isCharacterJumping;
    }

    public void setCharacterMoving(boolean characterMoving) {
        this.isCharacterMoving = characterMoving;
    }

    public void setCharacterMovingBack(boolean characterMovingBack) {
        this.isCharacterMovingBack = characterMovingBack;
    }

    public void setCharacterAttacking(boolean characterAttacking) {
        this.isCharacterAttacking = characterAttacking;
    }

    public void setCharacterJumping(boolean characterJumping) {
        isCharacterJumping = characterJumping;
    }
}
