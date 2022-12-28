package t6;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.tree.DefaultTreeModel;

import t12.OpenEmployeeFile;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Font;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManDeploy extends JPanel {
	private JTree deployTree1;
	private JTree deployTree2;
	private JButton changeButton;
	private JList menuList1;
	private JList menuList2;

	/**
	 * Create the panel.
	 */
	public ManDeploy() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		panel_2.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		deployTree1 = new JTree();
		deployTree1.setAlignmentX(Component.LEFT_ALIGNMENT);
		DefaultTreeModel treeModel = new DefaultTreeModel(OpenEmployeeFile.listAll("員工", OpenEmployeeFile.folderPath));
		deployTree1.setModel(treeModel);
		panel_4.add(deployTree1);
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		JPanel panel_5 = new JPanel();
		scrollPane_1.setViewportView(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("調度一");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 15));
		panel_1.add(lblNewLabel);
		
		menuList1 = new JList();
		menuList1.setFont(new Font("新細明體", Font.PLAIN, 18));
		menuList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<String> model1 = new DefaultListModel<String>();
		menuList1.setModel(model1);
		panel_5.add(menuList1, BorderLayout.CENTER);
		deployTree1.addTreeSelectionListener(new LoadEmployeeFile(menuList1));
		
		changeButton = new JButton("調換");
		changeButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		changeButton.setAlignmentX(0.55f);
		panel.add(changeButton);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.1);
		panel_3.add(splitPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane_2);
		
		JPanel panel_6 = new JPanel();
		scrollPane_2.setViewportView(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		deployTree2 = new JTree();
		deployTree2.setAlignmentX(Component.LEFT_ALIGNMENT);
		DefaultTreeModel treeModel1 = new DefaultTreeModel(OpenEmployeeFile.listAll("員工", OpenEmployeeFile.folderPath));
		deployTree2.setModel(treeModel1);
		
		panel_6.add(deployTree2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		splitPane_1.setRightComponent(scrollPane_3);
		
		JPanel panel_7 = new JPanel();
		scrollPane_3.setViewportView(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("調度二");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		panel_9.add(lblNewLabel_1);
		
		menuList2 = new JList();
		menuList2.setFont(new Font("新細明體", Font.PLAIN, 18));
		menuList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<String> model2 = new DefaultListModel<String>();
		menuList2.setModel(model2);
		deployTree2.addTreeSelectionListener(new LoadEmployeeFile(menuList2));
		panel_7.add(menuList2, BorderLayout.CENTER);
		
		changeButton.addActionListener(new SwitchPosEvent(deployTree1, menuList1, deployTree2, menuList2));
	}

}
