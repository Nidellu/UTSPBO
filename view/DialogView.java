package UTSPBO.view;

import javax.swing.JOptionPane;

public class DialogView {

    public static String showInputDialog(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public static void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
