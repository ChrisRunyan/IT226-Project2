package edu.ilstu;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TimerHelper extends JFrame {
	private JPanel contentPane;
	private Timer t;
	public int count = 10;
	private JTextField txtSeconds;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimerHelper frame = new TimerHelper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimerHelper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltime = new JLabel("");
		lbltime.setHorizontalTextPosition(SwingConstants.CENTER);
		lbltime.setHorizontalAlignment(SwingConstants.CENTER);
		lbltime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltime.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbltime.setBounds(218, 33, 145, 66);
		contentPane.add(lbltime);
		
		JButton btnNewButton = new JButton("start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = new Timer(1000, new ActionListener(){
					public void actionPerformed(ActionEvent e){
						count--;
						lbltime.setText(count +"");
						if(count == 0){
							JOptionPane.showMessageDialog(btnNewButton ,"time up");
							t.stop();
						}
					}
					
				});
				t.start();
				if(count == 0){
					JOptionPane.showMessageDialog(btnNewButton ,"time's up");
					t.stop();
				}
			}
		});
		btnNewButton.setBounds(177, 112, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("pause");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stop();
			}
		});
		btnNewButton_1.setBounds(286, 112, 97, 25);
		contentPane.add(btnNewButton_1);
		
		txtSeconds = new JTextField();
		txtSeconds.setText("seconds");
		txtSeconds.setBounds(12, 52, 97, 22);
		contentPane.add(txtSeconds);
		txtSeconds.setColumns(10);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a;
				a = Integer.parseInt(txtSeconds.getText());
				count = a;
			}
		});
		btnAdd.setBounds(12, 112, 97, 25);
		contentPane.add(btnAdd);
	}
}
