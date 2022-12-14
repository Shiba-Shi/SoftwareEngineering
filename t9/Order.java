package test;

import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.FlowLayout;

public class Order extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	
	private void loadTab(JComboBox<String> link, JPanel panelLink) {
		JButton btnNewButton_2 = new JButton("New button1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link.setSelectedIndex(1);
			}
		});
		btnNewButton_2.setBounds(65, 50, 120, 120);
		panelLink.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("New button2");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link.setSelectedIndex(2);
			}
		});
		btnNewButton_2_1.setBounds(260, 50, 120, 120);
		panelLink.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("New button3");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link.setSelectedIndex(3);
			}
		});
		btnNewButton_2_1_1.setBounds(455, 50, 120, 120);
		panelLink.add(btnNewButton_2_1_1);
	}
	
	public Order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//?????????????????????????????????comboBox(???????????????)
		
		Set<String> soup = new LinkedHashSet<>();
		soup.add("?????????...");
		soup.add("soup1");
		soup.add("soup2");
		soup.add("soup3");
		
		JComboBox<String> soupComboBox = new JComboBox<>();
		for(String soupName: soup) {
			soupComboBox.addItem(soupName);
		}
		soupComboBox.setBounds(20, 360, 125, 25);
		contentPane.add(soupComboBox);
		
		Set<String> appetizer = new LinkedHashSet<>();
		appetizer.add("?????????...");
		appetizer.add("appetizer1");
		appetizer.add("appetizer2");
		appetizer.add("appetizer3");
		
		JComboBox<String> appetizerComboBox = new JComboBox<>();
		for(String appetizerName: appetizer) {
			appetizerComboBox.addItem(appetizerName);
		}
		appetizerComboBox.setBounds(190, 360, 125, 25);
		contentPane.add(appetizerComboBox);
		
		Set<String> main_course = new LinkedHashSet<>();
		main_course.add("?????????...");
		main_course.add("main_course1");
		main_course.add("main_course2");
		main_course.add("main_course3");
		
		JComboBox<String> main_courseComboBox = new JComboBox<>();
		for(String main_courseName: main_course) {
			main_courseComboBox.addItem(main_courseName);
		}
		main_courseComboBox.setBounds(365, 360, 125, 25);
		contentPane.add(main_courseComboBox);
		
		Set<String> dessert = new LinkedHashSet<>();
		dessert.add("?????????...");
		dessert.add("dessert1");
		dessert.add("dessert2");
		dessert.add("dessert3");
		
		JComboBox<String> dessertComboBox = new JComboBox<>();
		for(String dessertName: dessert) {
			dessertComboBox.addItem(dessertName);
		}
		dessertComboBox.setBounds(540, 360, 125, 25);
		contentPane.add(dessertComboBox);
		
		//??????
		JLabel lblNewLabel = new JLabel("??????");
		lblNewLabel.setFont(new Font("???????????????", Font.PLAIN, 16));
		lblNewLabel.setBounds(20, 420, 70, 25);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);//????????????
		JScrollPane jScrollPane = new JScrollPane(textArea);
		jScrollPane.setBounds(20, 450, 470, 100);
		contentPane.add(jScrollPane);
		
		
		
		//????????????
		
		JTextArea mealTextArea = new JTextArea();
		mealTextArea.setLineWrap(true);//????????????
		JScrollPane jScrollPane_1 = new JScrollPane(mealTextArea);
		jScrollPane_1.setBounds(700, 15, 175, 535);
		contentPane.add(jScrollPane_1);
		
		//??????????????????
		
		JButton btnNewButton = new JButton("????????????");
		btnNewButton.setFont(new Font("???????????????", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			boolean isActive = false;
			public void actionPerformed(ActionEvent e) {
				if(!soupComboBox.getItemAt(soupComboBox.getSelectedIndex()).equals("?????????...")) { 
					mealTextArea.append(soupComboBox.getItemAt(soupComboBox.getSelectedIndex())+"\n");
					isActive = true;
				}
				if(!appetizerComboBox.getItemAt(appetizerComboBox.getSelectedIndex()).equals("?????????...")) {
					mealTextArea.append(appetizerComboBox.getItemAt(appetizerComboBox.getSelectedIndex())+"\n");
					isActive = true;
				}
				if(!main_courseComboBox.getItemAt(main_courseComboBox.getSelectedIndex()).equals("?????????...")) {
					mealTextArea.append(main_courseComboBox.getItemAt(main_courseComboBox.getSelectedIndex())+"\n");
					isActive = true;
				}
				if(!dessertComboBox.getItemAt(dessertComboBox.getSelectedIndex()).equals("?????????...")) {
					mealTextArea.append(dessertComboBox.getItemAt(dessertComboBox.getSelectedIndex())+"\n");
					isActive = true;
				}
				if(!textArea.getText().equals("")) {
					mealTextArea.append("?????????" + textArea.getText()+"\n");
					isActive = true;
				}
				soupComboBox.setSelectedIndex(0);
				appetizerComboBox.setSelectedIndex(0);
				main_courseComboBox.setSelectedIndex(0);
				dessertComboBox.setSelectedIndex(0);
				textArea.setText("");
				
				if(isActive) {
					mealTextArea.append("\n");
					isActive = false;
				}
			}
		});
		btnNewButton.setBounds(550, 450, 100, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("??????");
		btnNewButton_1.setFont(new Font("???????????????", Font.PLAIN, 16));
		btnNewButton_1.setBounds(550, 510, 100, 40);
		contentPane.add(btnNewButton_1);
		
		//???????????????
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();
		tabbedPane.addTab("Soup", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Appetizer", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Main_course", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("dessert", null, panel_3, null);
		panel_3.setLayout(null);
		
		tabbedPane.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		    	int n = tabbedPane.getSelectedIndex();
		    	JComboBox<String> comboBoxLink;
		    	JPanel panelLink;
		    	if(n == 0) {
		    		comboBoxLink = soupComboBox;
		    		panelLink = panel;
		    	}
		    	else if(n == 1) {
		    		comboBoxLink = appetizerComboBox;
		    		panelLink = panel_1;
		    	}
		    	else if(n == 2) {
		    		comboBoxLink = main_courseComboBox;
		    		panelLink = panel_2;
		    	}
		    	else {
		    		comboBoxLink = dessertComboBox;
		    		panelLink = panel_3;
		    	}
		    	loadTab(comboBoxLink, panelLink);
		    }
		});
		loadTab(soupComboBox, panel);
		tabbedPane.setBounds(20, 15, 645, 300);
		contentPane.add(tabbedPane);
		
	}
}
