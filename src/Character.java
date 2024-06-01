import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Character {
    private final String STAND_IMAGE_PATH = "resources\\Images\\Stand.png";
    private final String RUN_IMAGES_PATH = "resources\\Images\\Run";
    private final String RUN_BACK_IMAGES_PATH = "resources\\Images\\RunBack";
    private final String ATTACK_IMAGES_PATH = "resources\\Images\\Attack";
    private final String JUMP_IMAGES_PATH = "resources\\Images\\Jump";
    private final String JUMP_BACK_IMAGES_PATH = "resources\\Images\\JumpBack";
    private final String STRONG_ATTACK_IMAGES_PATH = "resources\\Images\\StrongAttack";
    private final int CHARACTER_SIZE = 200;
    private final int CHARACTER_SPEED = 40;

    private int runFrame;
    private int attackFrame;
    private int jumpFrame;

    private int x;
    private int y;
    private int dx;
    private int dy;
    private Image standFrame;
    private List<Image> runFrames;
    private List<Image> runBackFrames;
    private List<Image> jumpFrames;
    private List<Image> jumpBackFrames;
    private List<Image> attackFrames;
    private List<Image> strongAttackFrames;

    public Character(int startX, int startY){
        this.x = startX;
        this.y = startY;
        this.dx = 0;
        this.dy = 0;
        this.attackFrame = 0;
        this.runFrame = 0;
        this.standFrame = new ImageIcon(STAND_IMAGE_PATH).getImage();
        this.runFrames = loadFrames(6, RUN_IMAGES_PATH);
        this.runBackFrames = loadFrames(6, RUN_BACK_IMAGES_PATH);
        this.attackFrames = loadFrames(5, ATTACK_IMAGES_PATH);
        this.jumpFrames = loadFrames(3, JUMP_IMAGES_PATH);
        this.jumpBackFrames = loadFrames(3, JUMP_BACK_IMAGES_PATH);
        this.strongAttackFrames = loadFrames(5, STRONG_ATTACK_IMAGES_PATH);
    }

    private List<Image> loadFrames(int frames, String fileName){
        List<Image> frameList = new ArrayList<>(frames);
        for (int i = 1; i <= frames; i++){
            Image frame = new ImageIcon(fileName+i+".png").getImage();
            frameList.add(frame);
        }
        return frameList;
    }

    public boolean canMove(){
        int xPosition = this.x + dx;
        int yPosition = this.y + dy;
        boolean xPositionOk = xPosition >= -75 && xPosition <= 1800;
        boolean yPositionOk = yPosition >= 250 && yPosition <= 700;
        return xPositionOk && yPositionOk;
    }

    public void move(){
        this.x += this.dx;
        this.y += this.dy;
    }

    public int getAttackFrame() {
        return attackFrame;
    }
    public int getRunFrame() {
        return runFrame;
    }
    public int getCHARACTER_SPEED() {
        return CHARACTER_SPEED;
    }
    public int getJumpFrame() {
        return jumpFrame;
    }

    public void setJumpFrame(int jumpFrame) {
        this.jumpFrame = jumpFrame;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }
    public void setRunFrame(int runFrame) {
        this.runFrame = runFrame;
    }
    public void setAttackFrame(int attackFrame) {
        this.attackFrame = attackFrame;
    }

    public void paint(Graphics g){
        g.drawImage(this.standFrame, this.x, this.y, CHARACTER_SIZE, CHARACTER_SIZE, null);
    }

    public void paintRun(Graphics g){
        g.drawImage(this.runFrames.get(runFrame), this.x, this.y, CHARACTER_SIZE, CHARACTER_SIZE, null);
    }
    public void paintRunBack(Graphics g){
        g.drawImage(this.runBackFrames.get(runFrame), this.x, this.y, CHARACTER_SIZE, CHARACTER_SIZE, null);
    }
    public void paintAttack(Graphics g){
        g.drawImage(this.attackFrames.get(attackFrame), this.x, this.y, CHARACTER_SIZE, CHARACTER_SIZE, null);
    }
    public void paintStrongAttack(Graphics g){
        g.drawImage(this.strongAttackFrames.get(attackFrame), this.x, this.y, CHARACTER_SIZE, CHARACTER_SIZE, null);
    }
    public void paintJump(Graphics g){
        if (jumpFrame == 1){
            g.drawImage(this.jumpFrames.get(jumpFrame), this.x, this.y-150, CHARACTER_SIZE, CHARACTER_SIZE, null);
        }else {
            g.drawImage(this.jumpFrames.get(jumpFrame), this.x, this.y, CHARACTER_SIZE, CHARACTER_SIZE, null);
        }
    }
    public void paintJumpBack(Graphics g){
        if (jumpFrame == 1){
            g.drawImage(this.jumpBackFrames.get(jumpFrame), this.x, this.y-150, CHARACTER_SIZE, CHARACTER_SIZE, null);
        }else {
            g.drawImage(this.jumpBackFrames.get(jumpFrame), this.x, this.y, CHARACTER_SIZE, CHARACTER_SIZE, null);
        }
    }
}
