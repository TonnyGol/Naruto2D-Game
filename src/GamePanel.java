import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final String IMAGES_FOLDER = "Images\\";
    private final String GAME_BG_FILE_NAME = "Game_BG.png";

    private final Image backgroundImage;

    private int width;
    private int height;

    public GamePanel(int width, int height){
        this.width = width;
        this.height = height;
        this.setBounds(WindowFrame.DEFAULT_POSITION, WindowFrame.DEFAULT_POSITION, this.width, this.height);
        this.backgroundImage = new ImageIcon(IMAGES_FOLDER+GAME_BG_FILE_NAME).getImage();

        this.addKeyListener(new GameListener(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
