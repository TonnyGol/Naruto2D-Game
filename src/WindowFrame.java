import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {
    public static final int DEFAULT_POSITION = 0;
    public static boolean gameRuns;
    public static int panelChoice;

    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;

    private GamePanel gamePanel;
    private MenuPanel menu;
    private InstructionsPanel instructionsPanel;
    private SettingsPanel settingsPanel;
    private PausePanel pausePanel;

    public WindowFrame(){
        this.setTitle("Naruto Game");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.menu = new MenuPanel(WIDTH, HEIGHT);
        this.add(this.menu);

        this.instructionsPanel = new InstructionsPanel(WIDTH, HEIGHT);

        this.gamePanel = new GamePanel(WIDTH, HEIGHT);
        this.add(this.gamePanel);

        this.mainGameLoop();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void mainGameLoop(){
        new Thread(() ->{
            while (true){
                if(WindowFrame.gameRuns){
                    this.gamePanel.setVisible(true);
                    this.gamePanel.setFocusable(true);
                    this.gamePanel.requestFocus();
                }else {
                    switch (WindowFrame.panelChoice){
                        case 1: {
                            this.menu.setVisible(true);
                            this.menu.setFocusable(true);
                            this.menu.requestFocus();
                        }
                        case 2:{
                           this.instructionsPanel.setVisible(true);
                           this.instructionsPanel.setFocusable(true);
                           this.instructionsPanel.requestFocus();
                        }
                    }
                }
            }
        }).start();
    }

    public static JLabel createPhotoLabel(String text, String fileName, int fontSize) {
        JLabel label = new JLabel(text);
        label.setIcon(new ImageIcon("src\\Images\\"+fileName)); // Set the icon for the label
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, fontSize));
        label.setForeground(Color.ORANGE);
        label.setName(text);

        label.addMouseListener(new ButtonListener());
        return label;
    }
}
