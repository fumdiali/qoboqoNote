
package qoboqotexteditor;

import javax.swing.JFrame;

/**
 *
 * @author patrick c diali
 * @version 1.0.0
 */
public class QoboqoTextEditor {

    
    public static void main(String[] args) {
        qoboqoGUI obj = new qoboqoGUI();
        obj.setBounds(0, 0, 700, 700);
        obj.setTitle("QoboqoNote");
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
