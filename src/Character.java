import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Character {
    private final String STAND_IMAGES_PATH = "Images\\Stand";
    private final String RUN_IMAGES_PATH = "Images\\Run";
    private final String RUN_BACK_IMAGES_PATH = "Images\\RunBack";
    private final int CHARACTER_SIZE = 200;

    public static int runFrame;

    private int x;
    private int y;
    private Image standFrame;
    private List<Image> runFrames;
    private List<Image> runBackFrames;

    public Character(int startX, int startY){
        this.x = startX;
        this.y = startY;
        this.standFrame = new ImageIcon(STAND_IMAGES_PATH+".png").getImage();
        this.runFrames = loadFrames(6, RUN_IMAGES_PATH);
        this.runBackFrames = loadFrames(6, RUN_BACK_IMAGES_PATH);

    }

    private List<Image> loadFrames(int frames, String fileName){
        List<Image> frameList = new ArrayList<>(frames);
        for (int i = 1; i <= frames; i++){
            Image frame = new ImageIcon(fileName+i+".png").getImage();
            frameList.add(frame);
        }
        return frameList;
    }

    public void moveUp(){
        this.y -= 15;
    }
    public void moveDown(){
        this.y += 15;
    }
    public void moveRight(){
        this.x += 15;
    }
    public void moveLeft(){
        this.x -= 15;
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
}
