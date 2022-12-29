package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class CleanTable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CleanTable frame = new CleanTable();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class newTable{
		static boolean Flag;
		static int i = 5;
		static Set<String> needCleanedTableNum = new LinkedHashSet<>();
	}
	
	public static boolean needCleanedTable() {
		if(newTable.needCleanedTableNum.isEmpty())
			return false;
		else
			return true;
	}
	
	public void setTable(int num) {
		JButton btnNewButton = new JButton("第"+num+"桌");
		btnNewButton.addActionListener(new ActionListener() {
			boolean colorFlag = false;
			public void actionPerformed(ActionEvent e) {
				if(colorFlag == false) {
					btnNewButton.setBackground(new Color(255, 255, 0));
					colorFlag = true;
					newTable.needCleanedTableNum.add("第"+num+"桌");
				}else {
					btnNewButton.setBackground(new Color(240, 240, 240));
					colorFlag = false;
					newTable.needCleanedTableNum.remove("第"+num+"桌");
				}
			}
		});
		btnNewButton.setBounds(10+(num-1)/4*90, 10+(num-1)%4*90, 80, 80);
		contentPane.add(btnNewButton);
		newTable.Flag = true;
	}
	
	
	/**
	 * Create the frame.
	 */
	public CleanTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("第1桌");
		
		btnNewButton.addActionListener(new ActionListener() {
			boolean colorFlag1 = false;
			public void actionPerformed(ActionEvent e) {
				if(colorFlag1 == false) {
					btnNewButton.setBackground(new Color(255, 255, 0));
					colorFlag1 = true;
					newTable.needCleanedTableNum.add("第1桌");
				}else {
					btnNewButton.setBackground(new Color(240, 240, 240));
					colorFlag1 = false;
					newTable.needCleanedTableNum.remove("第1桌");
				}
			}
		});
		btnNewButton.setBounds(10, 10, 80, 80);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("第2桌");
		btnNewButton_1.addActionListener(new ActionListener() {
			boolean colorFlag2 = false;
			public void actionPerformed(ActionEvent e) {
				if(colorFlag2 == false) {
					btnNewButton_1.setBackground(new Color(255, 255, 0));
					colorFlag2 = true;
					newTable.needCleanedTableNum.add("第2桌");
				}else {
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					colorFlag2 = false;
					newTable.needCleanedTableNum.remove("第2桌");
				}
			}
		});
		btnNewButton_1.setBounds(10, 100, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("第3桌");
		btnNewButton_2.addActionListener(new ActionListener() {
			boolean colorFlag3 = false;
			public void actionPerformed(ActionEvent e) {
				if(colorFlag3 == false) {
					btnNewButton_2.setBackground(new Color(255, 255, 0));
					colorFlag3 = true;
					newTable.needCleanedTableNum.add("第3桌");
				}else {
					btnNewButton_2.setBackground(new Color(240, 240, 240));
					colorFlag3 = false;
					newTable.needCleanedTableNum.remove("第3桌");
				}
			}
		});
		btnNewButton_2.setBounds(10, 190, 80, 80);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("第4桌");
		btnNewButton_3.addActionListener(new ActionListener() {
			boolean colorFlag4 = false;
			public void actionPerformed(ActionEvent e) {
				if(colorFlag4 == false) {
					btnNewButton_3.setBackground(new Color(255, 255, 0));
					colorFlag4 = true;
					newTable.needCleanedTableNum.add("第4桌");
				}else {
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					colorFlag4 = false;
					newTable.needCleanedTableNum.remove("第4桌");
				}
			}
		});
		btnNewButton_3.setBounds(10, 280, 80, 80);
		contentPane.add(btnNewButton_3);
		
		
		JButton btnNewButton_4 = new JButton("+");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTable.Flag = false;
				setTable(newTable.i);
				if(newTable.i < 28)
					btnNewButton_4.setBounds(40+(newTable.i)/4*90, 30+(newTable.i)%4*90, 50, 50);
				else
					contentPane.remove(btnNewButton_4);
				if(newTable.Flag) {
					newTable.i++;
					newTable.Flag = false;
				}
			}
		});

		btnNewButton_4.setBounds(130, 30, 50, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("送出");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnNewButton_5.setBounds(275, 370, 85, 33);
		contentPane.add(btnNewButton_5);
		
	}
}
