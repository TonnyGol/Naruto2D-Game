import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Component label = e.getComponent();
        if (label.getName().equals(MenuPanel.PLAY_COMMAND)){
            WindowFrame.gameRuns = true;
            label.getParent().setFocusable(false);
            label.getParent().setVisible(false);
        }
        if (label.getName().equals("INSTRUCTION")){
            label.getParent().setFocusable(false);
            label.getParent().setVisible(false);
            WindowFrame.panelChoice = 2;
            WindowFrame.gameRuns = false;
        }
        if (label.getName().equals(MenuPanel.QUIT_COMMAND)){
            System.exit(0);
        }

        System.out.println(label.getName() + " label pressed");
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
