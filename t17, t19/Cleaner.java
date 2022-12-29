package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Cleaner extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cleaner frame = new Cleaner();
					//if(cleanTable.needCleanedTable())
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
	
	class newString{
		static int num = 0;
	}
	
	public void setLable(String tableNum) {
		JLabel lblNewLabel = new JLabel(tableNum);
		lblNewLabel.setBounds(10+newString.num/4*90, 10+newString.num%4*90, 80, 80);
		lblNewLabel.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel.setVerticalTextPosition(JLabel.CENTER);
		contentPane.add(lblNewLabel);
		newString.num++;
	}
	
	public Cleaner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		for(String tableNum : CleanTable.newTable.needCleanedTableNum) {
			setLable(tableNum);
		}
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}