package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTable;

public class PayRoll extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayRoll frame = new PayRoll();
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
	public PayRoll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Object[][] payData = {
				{"Name1", 34567, 0, "", null},
				{"Name2", 45678, 0, "", null},
				{"Name3", 56787, 0, "", null}
		};
		String[] columns = {"姓名", "應發", "扣除款", "備註", "實發工資"};
		
		for(int i = 0; i < payData.length; i++) {
			payData[i][4] = (int)payData[i][1] - (int)payData[i][2];
		}
		
		table = new JTable(payData,columns);
		table.setPreferredScrollableViewportSize(new Dimension(400,300));
	    contentPane.add(new JScrollPane(table),BorderLayout.CENTER);
		
	}

}
