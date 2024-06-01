import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Component label = e.getComponent();
        String labelText = label.getName();
        if(labelText != null){
            if (labelText.equals(MenuPanel.PLAY_COMMAND)){
                WindowFrame.switchPanels = true;
                WindowFrame.panelChoice = 1;
            }
            if (labelText.equals(MenuPanel.INSTRUCTION_COMMAND)){
                WindowFrame.switchPanels = true;
                WindowFrame.panelChoice = 2;
            }
            if (labelText.equals(MenuPanel.QUIT_COMMAND)){
                System.exit(0);
            }
            System.out.println(labelText + " Button pressed");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
