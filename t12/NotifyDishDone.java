package t12;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;

public class NotifyDishDone extends JPanel {
	private TableSelection TS;
	private DishSelection DS;
	private JTextField tableEntry;
	private JTextField dishEntry;
	private JTextField timeEntry;
	private JButton tableButton;
	private JButton dishButton;
	private JButton timeButton;
	private JButton confirmButton;
	private JButton clearButton;
	private SearchWaiter SW;
	private JTextField waiterEntry;
	/**
	 * Create the panel.
	 */
	public NotifyDishDone() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) titlePanel.getLayout();
		flowLayout_4.setHgap(10);
		add(titlePanel, BorderLayout.NORTH);
		
		JLabel titleLabel = new JLabel("通知餐點");
		titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_4.getLayout();
		flowLayout_5.setHgap(20);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		
		JLabel waiterLabel = new JLabel("服務生");
		waiterLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_5.add(waiterLabel);
		
		waiterEntry = new JTextField();
		waiterEntry.setFont(new Font("新細明體", Font.PLAIN, 18));
		waiterEntry.setColumns(15);
		panel_5.add(waiterEntry);
		
		JButton waiterButton = new JButton("查詢服務生");
		waiterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SW = new SearchWaiter(waiterEntry);
				SW.setMinimumSize(new Dimension(600, 600));
				SW.pack();
				SW.setLocationRelativeTo(null);
				SW.setVisible(true);
			}
		});
		waiterButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel_5.add(waiterButton);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 744, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 744, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(44)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		
		confirmButton = new JButton("確認");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirmButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel_4.add(confirmButton);
		
		clearButton = new JButton("全部清除");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableEntry.setText("");
				dishEntry.setText("");
				timeEntry.setText("");
				waiterEntry.setText("");
			}
		});
		clearButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel_4.add(clearButton);
		
		JLabel timeLabel = new JLabel("時間");
		timeLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_3.add(timeLabel);
		
		timeEntry = new JTextField();
		timeEntry.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_3.add(timeEntry);
		timeEntry.setColumns(15);
		
		timeButton = new JButton("自動產生");
		timeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime time = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String t = time.format(formatter);
				timeEntry.setText(t);
			}
		});
		timeButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel_3.add(timeButton);
		
		JLabel dishLabel = new JLabel("餐點");
		dishLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_2.add(dishLabel);
		
		dishEntry = new JTextField();
		dishEntry.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_2.add(dishEntry);
		dishEntry.setColumns(15);
		
		dishButton = new JButton("查詢餐點");
		dishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DS = new DishSelection(dishEntry);
				DS.setMinimumSize(new Dimension(600, 600));
				DS.pack();
				DS.setLocationRelativeTo(null);
				DS.setVisible(true);	
			}
		});
		dishButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel_2.add(dishButton);
		
		JLabel tableLabel = new JLabel("餐桌");
		tableLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_1.add(tableLabel);
		
		tableEntry = new JTextField();
		tableEntry.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_1.add(tableEntry);
		tableEntry.setColumns(15);
		
		tableButton = new JButton("查詢餐桌");
		tableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TS = new TableSelection(tableEntry);
				TS.setMinimumSize(new Dimension(600, 600));
				TS.pack();
				TS.setLocationRelativeTo(null);
				TS.setVisible(true);
			}
		});
		tableButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel_1.add(tableButton);
		panel.setLayout(gl_panel);

	}
}
