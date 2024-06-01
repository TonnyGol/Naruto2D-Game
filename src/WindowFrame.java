import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WindowFrame extends JFrame {
    public static boolean switchPanels;
    public static int panelChoice;

    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    public static final String IMAGES_FOLDER_PATH = "Images\\";

    private final MenuPanel menu;
    private final GamePanel gamePanel;
    private InstructionsPanel instructionsPanel;
    private SettingsPanel settingsPanel;
    private PausePanel pausePanel;
    private List<JPanel> panels;

    public WindowFrame(){
        this.setTitle("Naruto Game");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        switchPanels = false;
        this.panels = new ArrayList<>(5);

        this.menu = new MenuPanel(WIDTH, HEIGHT);
        this.add(this.menu);
        this.panels.add(this.menu);

        this.gamePanel = new GamePanel(WIDTH, HEIGHT);
        this.add(this.gamePanel);
        this.panels.add(this.gamePanel);

        this.mainWindowLoop();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void showOnlyOnePanel(){
        for (JPanel panel : this.panels){
            panel.setVisible(WindowFrame.panelChoice == this.panels.indexOf(panel));
            panel.setFocusable(WindowFrame.panelChoice == this.panels.indexOf(panel));
            panel.requestFocus();
        }
        WindowFrame.switchPanels = false;
    }

    private void mainWindowLoop(){
        new Thread(() ->{
            while (true){
                if (WindowFrame.switchPanels){
                    this.showOnlyOnePanel();
                }
            }
        }).start();
    }

    public static JLabel createPhotoLabel(String text, String fileName, int fontSize) {
        JLabel label = new JLabel(text);
        label.setIcon(new ImageIcon(IMAGES_FOLDER_PATH+fileName)); // Set the icon for the label
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, fontSize));
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setForeground(Color.ORANGE);
        label.setName(text);

        label.addMouseListener(new ButtonListener());
        return label;
    }
}
