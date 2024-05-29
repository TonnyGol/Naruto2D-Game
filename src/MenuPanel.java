import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public static String PLAY_COMMAND = "PLAY";
    public static String INSTRUCTION_COMMAND = "INSTRUCTION";
    public static String SETTINGS_COMMAND = "SETTINGS";
    public static String QUIT_COMMAND = "QUIT";

    private final int BUTTON_MARGIN = 60;
    private final int BUTTON_FONT_SIZE = 30;
    private final String IMAGES_FOLDER = "Images\\";
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
        this.setBounds(WindowFrame.DEFAULT_POSITION, WindowFrame.DEFAULT_POSITION, this.width, this.height);
        this.setFocusable(true);
        this.requestFocus();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.backgroundImage = new ImageIcon(IMAGES_FOLDER +MENU_BG_FILE_NAME).getImage();

        // Create labels for each menu option with icons
        this.playLabel = createMenuLabel(PLAY_COMMAND);
        this.instructionsLabel = createMenuLabel(INSTRUCTION_COMMAND);
        this.settingsLabel = createMenuLabel(SETTINGS_COMMAND);
        this.quitLabel = createMenuLabel(QUIT_COMMAND);

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

    private JLabel createMenuLabel(String text) {
        JLabel label = new JLabel(text);
        label.setIcon(new ImageIcon(IMAGES_FOLDER +BUTTON_BG_FILE_NAME)); // Set the icon for the label
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, BUTTON_FONT_SIZE));
        label.setForeground(Color.ORANGE);
        label.setName(text);

        label.addMouseListener(new ButtonListener());
        return label;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
