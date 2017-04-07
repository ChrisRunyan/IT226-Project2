import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {

	JPanel firstPanel = new JPanel();

	JFrame frame = new JFrame();

	JButton addAlarm = new JButton();
	JButton addTimer = new JButton();
	JButton delete = new JButton();

	public GUI() {
		frame.add(firstPanel);

		addAlarm.setText("Add an Alarm");
		addAlarm.setPreferredSize(new Dimension(200, 100));
		firstPanel.add(addAlarm);
		addAlarm.addActionListener(new ActionListener1());

		addTimer.setText("Add a Timer");
		addTimer.setPreferredSize(new Dimension(200, 100));
		firstPanel.add(addTimer);
		addTimer.addActionListener(new ActionListener1());

		delete.setText("Delete");
		delete.setPreferredSize(new Dimension(200, 100));
		firstPanel.add(delete);
		delete.addActionListener(new ActionListener1());

		add(firstPanel);

	}

	class ActionListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getActionCommand() == "Add an Alarm") {
				System.out.println("ALARM");

				GUIHelper newGUI = new GUIHelper(1);
				newGUI.setTitle("Add an alarm");
				newGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				newGUI.setSize(150, 300);
				newGUI.setVisible(true);

			}
			if (event.getActionCommand() == "Add a Timer") {
				System.out.println("TIMER");

				GUIHelper newGUI2 = new GUIHelper(2);
				newGUI2.setTitle("Add an alarm");
				newGUI2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				newGUI2.setSize(150, 300);
				newGUI2.setVisible(true);
			}
			if (event.getActionCommand() == "Delete") {
				System.out.println("DELETE");
			}

		}

	}
}
