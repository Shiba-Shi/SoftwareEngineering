package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoodStocks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodStocks frame = new FoodStocks();
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
	public FoodStocks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		//第一頁
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("ingredient1", null, panel_1, null);
		panel_1.setLayout(null);
		
		//顯示圖片和名稱
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 40, 150, 150);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("ingredient1_1", SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(20, 210, 130, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(240, 40, 150, 150);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("ingredient1_2", SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(250, 210, 130, 30);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(470, 40, 150, 150);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("ingredient1_3", SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(480, 210, 130, 30);
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBounds(700, 40, 150, 150);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("ingredient1_4", SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1.setBounds(710, 210, 130, 30);
		panel_1.add(lblNewLabel_3_1_1_1);
		
		int[][] ingredientSorted = {{100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}};
		
		JLabel lblNewLabel_2 = new JLabel("剩餘" + ingredientSorted[0][0] + "份");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(45, 240, 80, 30);
		panel_1.add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner.getValue();
	     		if(Num < 0)
	     			spinner.setValue(0);
	         }
		});
		spinner.setBounds(20, 310, 60, 30);
		panel_1.add(spinner);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(Color.GREEN);
		lblNewLabel_6.setBounds(75, 430, 20, 20);
		panel_1.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("使用");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner.getValue();
				ingredientSorted[0][0] -= Num;
				if(ingredientSorted[0][0] < 0)
					ingredientSorted[0][0] = 0;
				lblNewLabel_2.setText("剩餘" + ingredientSorted[0][0] + "份");
				spinner.setValue(0);
				if(ingredientSorted[0][0] >= 50)
					lblNewLabel_6.setBackground(Color.GREEN);
				else if(ingredientSorted[0][0] < 50 && ingredientSorted[0][0] >= 25)
					lblNewLabel_6.setBackground(Color.YELLOW);
				else
					lblNewLabel_6.setBackground(Color.RED);
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton.setBounds(90, 300, 65, 50);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("添加100份");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[0][0] += 100;
				lblNewLabel_2.setText("剩餘" + ingredientSorted[0][0] + "份");
				lblNewLabel_6.setBackground(Color.GREEN);
			}
		});
		btnNewButton_4.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_4.setBounds(35, 370, 100, 40);
		panel_1.add(btnNewButton_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("剩餘" + ingredientSorted[0][1] + "份");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(275, 240, 80, 30);
		panel_1.add(lblNewLabel_2_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner_1.getValue();
	     		if(Num < 0)
	     			spinner_1.setValue(0);
	         }
		});
		spinner_1.setBounds(250, 310, 60, 30);
		panel_1.add(spinner_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setOpaque(true);
		lblNewLabel_6_1.setBackground(Color.GREEN);
		lblNewLabel_6_1.setBounds(305, 430, 20, 20);
		panel_1.add(lblNewLabel_6_1);
		
		JButton btnNewButton_1 = new JButton("使用");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner_1.getValue();
				ingredientSorted[0][1] -= Num;
				if(ingredientSorted[0][1] < 0)
					ingredientSorted[0][1] = 0;
				lblNewLabel_2_1.setText("剩餘" + ingredientSorted[0][1] + "份");
				spinner_1.setValue(0);
				if(ingredientSorted[0][1] >= 50)
					lblNewLabel_6_1.setBackground(Color.GREEN);
				else if(ingredientSorted[0][1] < 50 && ingredientSorted[0][1] >= 25)
					lblNewLabel_6_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_6_1.setBackground(Color.RED);
				
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_1.setBounds(320, 300, 65, 50);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_4_1 = new JButton("添加100份");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[0][1] += 100;
				lblNewLabel_2_1.setText("剩餘" + ingredientSorted[0][1] + "份");
				lblNewLabel_6_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_4_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_4_1.setBounds(265, 370, 100, 40);
		panel_1.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("剩餘" + ingredientSorted[0][2] + "份");
		lblNewLabel_2_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(505, 240, 80, 30);
		panel_1.add(lblNewLabel_2_1_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner_2.getValue();
	     		if(Num < 0)
	     			spinner_2.setValue(0);
	         }
		});
		spinner_2.setBounds(480, 310, 60, 30);
		panel_1.add(spinner_2);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("");
		lblNewLabel_6_1_1.setOpaque(true);
		lblNewLabel_6_1_1.setBackground(Color.GREEN);
		lblNewLabel_6_1_1.setBounds(535, 430, 20, 20);
		panel_1.add(lblNewLabel_6_1_1);
		
		JButton btnNewButton_2 = new JButton("使用");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner_2.getValue();
				ingredientSorted[0][2] -= Num;
				if(ingredientSorted[0][2] < 0)
					ingredientSorted[0][2] = 0;
				lblNewLabel_2_1_1.setText("剩餘" + ingredientSorted[0][2] + "份");
				spinner_2.setValue(0);
				if(ingredientSorted[0][2] >= 50)
					lblNewLabel_6_1_1.setBackground(Color.GREEN);
				else if(ingredientSorted[0][2] < 50 && ingredientSorted[0][2] >= 25)
					lblNewLabel_6_1_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_6_1_1.setBackground(Color.RED);
				
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_2.setBounds(550, 300, 65, 50);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_4_1_1 = new JButton("添加100份");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[0][2] += 100;
				lblNewLabel_2_1_1.setText("剩餘" + ingredientSorted[0][2] + "份");
				lblNewLabel_6_1_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_4_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_4_1_1.setBounds(495, 370, 100, 40);
		panel_1.add(btnNewButton_4_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("剩餘" + ingredientSorted[0][3] + "份");
		lblNewLabel_2_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(735, 240, 80, 30);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner_3.getValue();
	     		if(Num < 0)
	     			spinner_3.setValue(0);
	         }
		});
		spinner_3.setBounds(710, 310, 60, 30);
		panel_1.add(spinner_3);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_1.setOpaque(true);
		lblNewLabel_6_1_1_1.setBackground(Color.GREEN);
		lblNewLabel_6_1_1_1.setBounds(765, 430, 20, 20);
		panel_1.add(lblNewLabel_6_1_1_1);
		
		JButton btnNewButton_3 = new JButton("使用");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner_3.getValue();
				ingredientSorted[0][3] -= Num;
				if(ingredientSorted[0][3] < 0)
					ingredientSorted[0][3] = 0;
				lblNewLabel_2_1_1_1.setText("剩餘" + ingredientSorted[0][3] + "份");
				spinner_3.setValue(0);
				if(ingredientSorted[0][3] >= 50)
					lblNewLabel_6_1_1_1.setBackground(Color.GREEN);
				else if(ingredientSorted[0][3] < 50 && ingredientSorted[0][3] >= 25)
					lblNewLabel_6_1_1_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_6_1_1_1.setBackground(Color.RED);
			}
		});
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_3.setBounds(780, 300, 65, 50);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4_1_1_1 = new JButton("添加100份");
		btnNewButton_4_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[0][3] += 100;
				lblNewLabel_2_1_1_1.setText("剩餘" + ingredientSorted[0][3] + "份");
				lblNewLabel_6_1_1_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_4_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_4_1_1_1.setBounds(725, 370, 100, 40);
		panel_1.add(btnNewButton_4_1_1_1);
		
		
		//第二頁
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("ingredient2", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabe2 = new JLabel("New label");
		lblNewLabe2.setBounds(10, 40, 150, 150);
		panel_2.add(lblNewLabe2);
		
		JLabel lblNewLabel_4 = new JLabel("ingredient2_1", SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(20, 210, 130, 30);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabe2_1 = new JLabel("New label");
		lblNewLabe2_1.setBounds(240, 40, 150, 150);
		panel_2.add(lblNewLabe2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("ingredient2_2", SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(250, 210, 130, 30);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabe2_1_1 = new JLabel("New label");
		lblNewLabe2_1_1.setBounds(470, 40, 150, 150);
		panel_2.add(lblNewLabe2_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("ingredient2_3", SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1_1.setBounds(480, 210, 130, 30);
		panel_2.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabe2_1_1_1 = new JLabel("New label");
		lblNewLabe2_1_1_1.setBounds(700, 40, 150, 150);
		panel_2.add(lblNewLabe2_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("ingredient2_4", SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1.setBounds(710, 210, 130, 30);
		panel_2.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabe2_2 = new JLabel("剩餘" + ingredientSorted[1][0] + "份");
		lblNewLabe2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabe2_2.setBounds(45, 240, 80, 30);
		panel_2.add(lblNewLabe2_2);
		
		JSpinner spinner1 = new JSpinner();
		spinner1.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner1.getValue();
	     		if(Num < 0)
	     			spinner1.setValue(0);
	         }
		});
		spinner1.setBounds(20, 310, 60, 30);
		panel_2.add(spinner1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(Color.GREEN);
		lblNewLabel_7.setBounds(75, 430, 20, 20);
		panel_2.add(lblNewLabel_7);
		
		JButton btnNewButton1 = new JButton("使用");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner1.getValue();
				ingredientSorted[1][0] -= Num;
				if(ingredientSorted[1][0] < 0)
					ingredientSorted[1][0] = 0;
				lblNewLabe2_2.setText("剩餘" + ingredientSorted[1][0] + "份");
				spinner1.setValue(0);
				if(ingredientSorted[1][0] >= 50)
					lblNewLabel_7.setBackground(Color.GREEN);
				else if(ingredientSorted[1][0] < 50 && ingredientSorted[1][0] >= 25)
					lblNewLabel_7.setBackground(Color.YELLOW);
				else
					lblNewLabel_7.setBackground(Color.RED);
			}
		});
		btnNewButton1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton1.setBounds(90, 300, 65, 50);
		panel_2.add(btnNewButton1);
		
		JButton btnNewButton_5 = new JButton("添加100份");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[1][0] += 100;
				lblNewLabe2_2.setText("剩餘" + ingredientSorted[1][0] + "份");
				lblNewLabel_7.setBackground(Color.GREEN);
			}
		});
		btnNewButton_5.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_5.setBounds(35, 370, 100, 40);
		panel_2.add(btnNewButton_5);
		
		JLabel lblNewLabe2_2_1 = new JLabel("剩餘" + ingredientSorted[1][1] + "份");
		lblNewLabe2_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabe2_2_1.setBounds(275, 240, 80, 30);
		panel_2.add(lblNewLabe2_2_1);
		
		JSpinner spinner1_1 = new JSpinner();
		spinner1_1.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner1_1.getValue();
	     		if(Num < 0)
	     			spinner1_1.setValue(0);
	         }
		});
		spinner1_1.setBounds(250, 310, 60, 30);
		panel_2.add(spinner1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setOpaque(true);
		lblNewLabel_7_1.setBackground(Color.GREEN);
		lblNewLabel_7_1.setBounds(305, 430, 20, 20);
		panel_2.add(lblNewLabel_7_1);
		
		JButton btnNewButton1_1 = new JButton("使用");
		btnNewButton1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner1_1.getValue();
				ingredientSorted[1][1] -= Num;
				if(ingredientSorted[1][1] < 0)
					ingredientSorted[1][1] = 0;
				lblNewLabe2_2_1.setText("剩餘" + ingredientSorted[1][1] + "份");
				spinner1_1.setValue(0);
				if(ingredientSorted[1][1] >= 50)
					lblNewLabel_7_1.setBackground(Color.GREEN);
				else if(ingredientSorted[1][1] < 50 && ingredientSorted[1][1] >= 25)
					lblNewLabel_7_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_7_1.setBackground(Color.RED);
			}
		});
		btnNewButton1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton1_1.setBounds(320, 300, 65, 50);
		panel_2.add(btnNewButton1_1);
		
		JButton btnNewButton_5_1 = new JButton("添加100份");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[1][1] += 100;
				lblNewLabe2_2_1.setText("剩餘" + ingredientSorted[1][1] + "份");
				lblNewLabel_7_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_5_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_5_1.setBounds(265, 370, 100, 40);
		panel_2.add(btnNewButton_5_1);
		
		JLabel lblNewLabe2_2_1_1 = new JLabel("剩餘" + ingredientSorted[1][2] + "份");
		lblNewLabe2_2_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabe2_2_1_1.setBounds(505, 240, 80, 30);
		panel_2.add(lblNewLabe2_2_1_1);
		
		JSpinner spinner1_2 = new JSpinner();
		spinner1_2.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner1_2.getValue();
	     		if(Num < 0)
	     			spinner1_2.setValue(0);
	         }
		});
		spinner1_2.setBounds(480, 310, 60, 30);
		panel_2.add(spinner1_2);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("");
		lblNewLabel_7_1_1.setOpaque(true);
		lblNewLabel_7_1_1.setBackground(Color.GREEN);
		lblNewLabel_7_1_1.setBounds(535, 430, 20, 20);
		panel_2.add(lblNewLabel_7_1_1);
		
		JButton btnNewButton1_2 = new JButton("使用");
		btnNewButton1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner1_2.getValue();
				ingredientSorted[1][2] -= Num;
				if(ingredientSorted[1][2] < 0)
					ingredientSorted[1][2] = 0;
				lblNewLabe2_2_1_1.setText("剩餘" + ingredientSorted[1][2] + "份");
				spinner1_2.setValue(0);
				if(ingredientSorted[1][2] >= 50)
					lblNewLabel_7_1_1.setBackground(Color.GREEN);
				else if(ingredientSorted[1][2] < 50 && ingredientSorted[1][2] >= 25)
					lblNewLabel_7_1_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_7_1_1.setBackground(Color.RED);
			}
		});
		btnNewButton1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton1_2.setBounds(550, 300, 65, 50);
		panel_2.add(btnNewButton1_2);
		
		JButton btnNewButton_5_1_1 = new JButton("添加100份");
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[1][2] += 100;
				lblNewLabe2_2_1_1.setText("剩餘" + ingredientSorted[1][2] + "份");
				lblNewLabel_7_1_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_5_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_5_1_1.setBounds(495, 370, 100, 40);
		panel_2.add(btnNewButton_5_1_1);
		
		JLabel lblNewLabe2_2_1_1_1 = new JLabel("剩餘" + ingredientSorted[1][3] + "份");
		lblNewLabe2_2_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabe2_2_1_1_1.setBounds(735, 240, 80, 30);
		panel_2.add(lblNewLabe2_2_1_1_1);
		
		JSpinner spinner1_3 = new JSpinner();
		spinner1_3.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner1_3.getValue();
	     		if(Num < 0)
	     			spinner1_3.setValue(0);
	         }
		});
		spinner1_3.setBounds(710, 310, 60, 30);
		panel_2.add(spinner1_3);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("");
		lblNewLabel_7_1_1_1.setOpaque(true);
		lblNewLabel_7_1_1_1.setBackground(Color.GREEN);
		lblNewLabel_7_1_1_1.setBounds(765, 430, 20, 20);
		panel_2.add(lblNewLabel_7_1_1_1);
		
		JButton btnNewButton1_3 = new JButton("使用");
		btnNewButton1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner1_3.getValue();
				ingredientSorted[1][3] -= Num;
				if(ingredientSorted[1][3] < 0)
					ingredientSorted[1][3] = 0;
				lblNewLabe2_2_1_1_1.setText("剩餘" + ingredientSorted[1][3] + "份");
				spinner1_3.setValue(0);
				if(ingredientSorted[1][3] >= 50)
					lblNewLabel_7_1_1_1.setBackground(Color.GREEN);
				else if(ingredientSorted[1][33] < 50 && ingredientSorted[1][3] >= 25)
					lblNewLabel_7_1_1_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_7_1_1_1.setBackground(Color.RED);
			}
		});
		btnNewButton1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton1_3.setBounds(780, 300, 65, 50);
		panel_2.add(btnNewButton1_3);
		
		JButton btnNewButton_5_1_1_1 = new JButton("添加100份");
		btnNewButton_5_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[1][3] += 100;
				lblNewLabe2_2_1_1_1.setText("剩餘" + ingredientSorted[1][3] + "份");
				lblNewLabel_7_1_1_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_5_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_5_1_1_1.setBounds(725, 370, 100, 40);
		panel_2.add(btnNewButton_5_1_1_1);
		
		
		//第三頁
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("ingredient3", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabe3 = new JLabel("New label");
		lblNewLabe3.setBounds(10, 40, 150, 150);
		panel_3.add(lblNewLabe3);
		
		JLabel lblNewLabel_5 = new JLabel("ingredient3_1", SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(20, 210, 130, 30);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabe3_1 = new JLabel("New label");
		lblNewLabe3_1.setBounds(240, 40, 150, 150);
		panel_3.add(lblNewLabe3_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("ingredient3_2", SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(250, 210, 130, 30);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabe3_1_1 = new JLabel("New label");
		lblNewLabe3_1_1.setBounds(470, 40, 150, 150);
		panel_3.add(lblNewLabe3_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("ingredient3_3", SwingConstants.CENTER);
		lblNewLabel_5_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_5_1_1.setBounds(480, 210, 130, 30);
		panel_3.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabe3_1_1_1 = new JLabel("New label");
		lblNewLabe3_1_1_1.setBounds(700, 40, 150, 150);
		panel_3.add(lblNewLabe3_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("ingredient3_4", SwingConstants.CENTER);
		lblNewLabel_5_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_5_1_1_1.setBounds(710, 210, 130, 30);
		panel_3.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabe3_2 = new JLabel("剩餘" + ingredientSorted[2][0] + "份");
		lblNewLabe3_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabe3_2.setBounds(45, 240, 80, 30);
		panel_3.add(lblNewLabe3_2);
		
		JSpinner spinner2 = new JSpinner();
		spinner2.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner2.getValue();
	     		if(Num < 0)
	     			spinner2.setValue(0);
	         }
		});
		spinner2.setBounds(20, 310, 60, 30);
		panel_3.add(spinner2);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(Color.GREEN);
		lblNewLabel_8.setBounds(75, 430, 20, 20);
		panel_3.add(lblNewLabel_8);
		
		JButton btnNewButton2 = new JButton("使用");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner2.getValue();
				ingredientSorted[2][0] -= Num;
				if(ingredientSorted[2][0] < 0)
					ingredientSorted[2][0] = 0;
				lblNewLabe3_2.setText("剩餘" + ingredientSorted[2][0] + "份");
				spinner2.setValue(0);
				if(ingredientSorted[2][0] >= 50)
					lblNewLabel_8.setBackground(Color.GREEN);
				else if(ingredientSorted[2][0] < 50 && ingredientSorted[2][0] >= 25)
					lblNewLabel_8.setBackground(Color.YELLOW);
				else
					lblNewLabel_8.setBackground(Color.RED);
			}
		});
		btnNewButton2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton2.setBounds(90, 300, 65, 50);
		panel_3.add(btnNewButton2);
		
		JButton btnNewButton_6 = new JButton("添加100份");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[2][0] += 100;
				lblNewLabe3_2.setText("剩餘" + ingredientSorted[2][0] + "份");
				lblNewLabel_8.setBackground(Color.GREEN);
			}
		});
		btnNewButton_6.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_6.setBounds(35, 370, 100, 40);
		panel_3.add(btnNewButton_6);
		
		JLabel lblNewLabe3_2_1 = new JLabel("剩餘" + ingredientSorted[2][1] + "份");
		lblNewLabe3_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabe3_2_1.setBounds(275, 240, 80, 30);
		panel_3.add(lblNewLabe3_2_1);
		
		JSpinner spinner2_1 = new JSpinner();
		spinner2_1.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner2_1.getValue();
	     		if(Num < 0)
	     			spinner2_1.setValue(0);
	         }
		});
		spinner2_1.setBounds(250, 310, 60, 30);
		panel_3.add(spinner2_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setOpaque(true);
		lblNewLabel_8_1.setBackground(Color.GREEN);
		lblNewLabel_8_1.setBounds(305, 430, 20, 20);
		panel_3.add(lblNewLabel_8_1);
		
		JButton btnNewButton2_1 = new JButton("使用");
		btnNewButton2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner2_1.getValue();
				ingredientSorted[2][1] -= Num;
				if(ingredientSorted[2][1] < 0)
					ingredientSorted[2][1] = 0;
				lblNewLabe3_2_1.setText("剩餘" + ingredientSorted[2][1] + "份");
				spinner2_1.setValue(0);
				if(ingredientSorted[2][1] >= 50)
					lblNewLabel_8_1.setBackground(Color.GREEN);
				else if(ingredientSorted[2][1] < 50 && ingredientSorted[2][1] >= 25)
					lblNewLabel_8_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_8_1.setBackground(Color.RED);
			}
		});
		btnNewButton2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton2_1.setBounds(320, 300, 65, 50);
		panel_3.add(btnNewButton2_1);
		
		JButton btnNewButton_6_1 = new JButton("添加100份");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[2][1] += 100;
				lblNewLabe3_2_1.setText("剩餘" + ingredientSorted[2][1] + "份");
				lblNewLabel_8_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_6_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_6_1.setBounds(265, 370, 100, 40);
		panel_3.add(btnNewButton_6_1);
		
		JLabel lblNewLabe3_2_1_1 = new JLabel("剩餘" + ingredientSorted[2][2] + "份");
		lblNewLabe3_2_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabe3_2_1_1.setBounds(505, 240, 80, 30);
		panel_3.add(lblNewLabe3_2_1_1);
		
		JSpinner spinner2_2 = new JSpinner();
		spinner2_2.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner2_2.getValue();
	     		if(Num < 0)
	     			spinner2_2.setValue(0);
	         }
		});
		spinner2_2.setBounds(480, 310, 60, 30);
		panel_3.add(spinner2_2);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("");
		lblNewLabel_8_1_1.setOpaque(true);
		lblNewLabel_8_1_1.setBackground(Color.GREEN);
		lblNewLabel_8_1_1.setBounds(535, 430, 20, 20);
		panel_3.add(lblNewLabel_8_1_1);
		
		JButton btnNewButton2_2 = new JButton("使用");
		btnNewButton2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner2_2.getValue();
				ingredientSorted[2][2] -= Num;
				if(ingredientSorted[2][2] < 0)
					ingredientSorted[2][2] = 0;
				lblNewLabe3_2_1_1.setText("剩餘" + ingredientSorted[2][2] + "份");
				spinner2_2.setValue(0);
				if(ingredientSorted[2][2] >= 50)
					lblNewLabel_8_1_1.setBackground(Color.GREEN);
				else if(ingredientSorted[2][2] < 50 && ingredientSorted[2][2] >= 25)
					lblNewLabel_8_1_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_8_1_1.setBackground(Color.RED);
			}
		});
		btnNewButton2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton2_2.setBounds(550, 300, 65, 50);
		panel_3.add(btnNewButton2_2);
		
		JButton btnNewButton_6_1_1 = new JButton("添加100份");
		btnNewButton_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[2][2] += 100;
				lblNewLabe3_2_1_1.setText("剩餘" + ingredientSorted[2][2] + "份");
				lblNewLabel_8_1_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_6_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_6_1_1.setBounds(495, 370, 100, 40);
		panel_3.add(btnNewButton_6_1_1);
		
		JLabel lblNewLabe3_2_1_1_1 = new JLabel("剩餘" + ingredientSorted[2][3] + "份");
		lblNewLabe3_2_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabe3_2_1_1_1.setBounds(735, 240, 80, 30);
		panel_3.add(lblNewLabe3_2_1_1_1);
		
		JSpinner spinner2_3 = new JSpinner();
		spinner2_3.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	int Num = (int) spinner2_3.getValue();
	     		if(Num < 0)
	     			spinner2_3.setValue(0);
	         }
		});
		spinner2_3.setBounds(710, 310, 60, 30);
		panel_3.add(spinner2_3);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("");
		lblNewLabel_8_1_1_1.setOpaque(true);
		lblNewLabel_8_1_1_1.setBackground(Color.GREEN);
		lblNewLabel_8_1_1_1.setBounds(765, 430, 20, 20);
		panel_3.add(lblNewLabel_8_1_1_1);
		
		JButton btnNewButton2_3 = new JButton("使用");
		btnNewButton2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Num = (int) spinner2_3.getValue();
				ingredientSorted[2][3] -= Num;
				if(ingredientSorted[2][3] < 0)
					ingredientSorted[2][3] = 0;
				lblNewLabe3_2_1_1_1.setText("剩餘" + ingredientSorted[2][3] + "份");
				spinner2_3.setValue(0);
				if(ingredientSorted[2][3] >= 50)
					lblNewLabel_8_1_1_1.setBackground(Color.GREEN);
				else if(ingredientSorted[2][3] < 50 && ingredientSorted[2][3] >= 25)
					lblNewLabel_8_1_1_1.setBackground(Color.YELLOW);
				else
					lblNewLabel_8_1_1_1.setBackground(Color.RED);
			}
		});
		btnNewButton2_3.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton2_3.setBounds(780, 300, 65, 50);
		panel_3.add(btnNewButton2_3);
		
		JButton btnNewButton_6_1_1_1 = new JButton("添加100份");
		btnNewButton_6_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientSorted[2][3] += 100;
				lblNewLabe3_2_1_1_1.setText("剩餘" + ingredientSorted[2][3] + "份");
				lblNewLabel_8_1_1_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_6_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_6_1_1_1.setBounds(725, 370, 100, 40);
		panel_3.add(btnNewButton_6_1_1_1);
	}
}
