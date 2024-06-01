import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public static String PLAY_COMMAND = "PLAY";
    public static String INSTRUCTION_COMMAND = "INSTRUCTION";
    public static String SETTINGS_COMMAND = "SETTINGS";
    public static String QUIT_COMMAND = "QUIT";

    private final int BUTTON_MARGIN = 60;
    private final int BUTTON_FONT_SIZE = 30;
    private final String IMAGES_FOLDER_PATH = "Images\\";
    private final String BUTTON_BG_FILE_NAME = "Button_BG.png";
    private final String MENU_BG_FILE_NAME = "Menu_BG.png";

    private final Image backgroundImage;

    private int width;
    private int height;

    private JLabel playLabel;
    private JLabel instructionsLabel;
    private JLabel settingsLabel;
    private JLabel quitLabel;

    public MenuPanel(int width, int height){
        this.width = width;
        this.height = height;
        this.setBounds(0, 0, this.width, this.height);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.backgroundImage = new ImageIcon(IMAGES_FOLDER_PATH+MENU_BG_FILE_NAME).getImage();

        // Create labels for each menu option with icons
        this.playLabel = WindowFrame.createPhotoLabel(PLAY_COMMAND, BUTTON_BG_FILE_NAME, BUTTON_FONT_SIZE);
        this.instructionsLabel = WindowFrame.createPhotoLabel(INSTRUCTION_COMMAND, BUTTON_BG_FILE_NAME, BUTTON_FONT_SIZE);
        this.settingsLabel = WindowFrame.createPhotoLabel(SETTINGS_COMMAND, BUTTON_BG_FILE_NAME, BUTTON_FONT_SIZE);
        this.quitLabel = WindowFrame.createPhotoLabel(QUIT_COMMAND, BUTTON_BG_FILE_NAME, BUTTON_FONT_SIZE);

        // Add labels to the panel with some spacing
        int buttonWidthMargin = (width / 4) + 30;
        this.add(Box.createRigidArea(new Dimension(buttonWidthMargin, BUTTON_MARGIN)));
        this.add(playLabel);
        this.add(Box.createRigidArea(new Dimension(buttonWidthMargin, BUTTON_MARGIN)));
        this.add(instructionsLabel);
        this.add(Box.createRigidArea(new Dimension(buttonWidthMargin, BUTTON_MARGIN)));
        this.add(settingsLabel);
        this.add(Box.createRigidArea(new Dimension(buttonWidthMargin, BUTTON_MARGIN)));
        this.add(quitLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
