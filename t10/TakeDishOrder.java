package t10;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TakeDishOrder extends JPanel {
	private JTextArea mainDishText;
	private JTextArea sideDishText;
	private JTextArea soupText;
	private JTextArea dessertText;

	private ExampleData e = new ExampleData();
	private HashMap<String[], HashMap<String, String[]>> example = e.generate();
	private JTable orderTable;
	/**
	 * Create the panel.
	 */
	public TakeDishOrder() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.95);
		panel_1.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, BorderLayout.CENTER);
		
		orderTable = new JTable(0, 4) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		orderTable.getTableHeader().setReorderingAllowed(false);
		orderTable.getTableHeader().setFont(new Font("新細明體", Font.BOLD, 15) );
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		orderTable.setRowHeight(30);
		orderTable.setFont(new Font("新細明體", Font.PLAIN, 18));
		scrollPane_2.setViewportView(orderTable);
		
		Object[] columns = {"時間", "服務生", "樓層", "餐桌"};
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		String[][] keySet = e.exampleKeySet();
		for(String[] key: keySet) {
			tableModel.addRow(key);
		}
		orderTable.setModel(tableModel);
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton confirmButton = new JButton("接受並移除");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否接受訂單", "訂單接受", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION) {
					int row = orderTable.getSelectedRow();
					tableModel.removeRow(row);
				}
			}
		});
		confirmButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel.add(confirmButton);
		
		JButton cancelButton = new JButton("取消並移除");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退還訂單", "訂單退還", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION) {
					int row = orderTable.getSelectedRow();
					tableModel.removeRow(row);
				}
				
			}
		});
		cancelButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		panel.add(cancelButton);
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setLeftComponent(scrollPane_1);
		
		JPanel panel_3 = new JPanel();
		scrollPane_1.setViewportView(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_3.add(splitPane_1, BorderLayout.CENTER);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.5);
		splitPane_1.setLeftComponent(splitPane_2);
		
		JPanel panel_4 = new JPanel();
		splitPane_2.setLeftComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12, BorderLayout.NORTH);
		
		JLabel mainDishLabel = new JLabel("主餐");
		mainDishLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		panel_12.add(mainDishLabel);
		
		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		mainDishText = new JTextArea();
		mainDishText.setEditable(false);
		mainDishText.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_13.add(mainDishText); 
		
		JPanel panel_5 = new JPanel();
		splitPane_2.setRightComponent(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_5.add(panel_14, BorderLayout.NORTH);
		
		JLabel sideDishLabel = new JLabel("開胃菜");
		sideDishLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		panel_14.add(sideDishLabel);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		sideDishText = new JTextArea();
		sideDishText.setEditable(false);
		sideDishText.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_15.add(sideDishText, BorderLayout.CENTER);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setResizeWeight(0.5);
		splitPane_1.setRightComponent(splitPane_3);
		
		JPanel panel_6 = new JPanel();
		splitPane_3.setLeftComponent(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_6.add(panel_16, BorderLayout.NORTH);
		
		JLabel soupLabel = new JLabel("湯品");
		soupLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		panel_16.add(soupLabel);
		
		JPanel panel_17 = new JPanel();
		panel_6.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		soupText = new JTextArea();
		soupText.setEditable(false);
		soupText.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_17.add(soupText, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		splitPane_3.setRightComponent(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_7.add(panel_18, BorderLayout.NORTH);
		
		JLabel dessertLabel = new JLabel("甜點");
		dessertLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		panel_18.add(dessertLabel);
		
		JPanel panel_19 = new JPanel();
		panel_7.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		dessertText = new JTextArea();
		dessertText.setEditable(false);
		dessertText.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_19.add(dessertText, BorderLayout.CENTER);
		orderTable.addMouseListener(new TableSelectionEvent(
				this.example, mainDishText, sideDishText, soupText, dessertText));
	}
	
	public static void main(String arg[]) {
		JFrame frame = new JFrame();
		TakeDishOrder tdo = new TakeDishOrder();
		frame.getContentPane().add(tdo);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
}
