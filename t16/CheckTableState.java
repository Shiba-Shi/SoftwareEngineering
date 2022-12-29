package t16;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JSplitPane;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.DefaultListModel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import org.jdesktop.swingx.JXTaskPaneContainer;
import java.awt.Color;
import org.jdesktop.swingx.JXTaskPane;

public class CheckTableState extends JPanel {
	private JPanel mapBodyPanel;
	private JTree floorTree;
	private JXTaskPaneContainer listBodyPanel;
	private JXTaskPane fullPanel;
	private JXTaskPane emptyPanel;
	private JXTaskPane notEmptyPanel;
	private JXTaskPane cleanPanel;
	private JXTaskPane dirtyPanel;
	private JPanel innerPanel;
	private SwitchButton switchButton;
	/**
	 * Create the panel.
	 */
	public CheckTableState() {
		
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		splitPane.setContinuousLayout(true);
		add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.9);
		splitPane.setRightComponent(splitPane_1);
		
		mapBodyPanel = new JPanel();
		splitPane_1.setLeftComponent(mapBodyPanel);
		
		listBodyPanel = new JXTaskPaneContainer();
		listBodyPanel.setBackground(new Color(255, 255, 255));
		splitPane_1.setRightComponent(listBodyPanel);
		
		
		fullPanel = new JXTaskPane("滿桌");
		fullPanel.setFont(new Font("新細明體", Font.BOLD, 15));
		fullPanel.setCollapsed(true);
		JList fullList = new JList();
		DefaultListModel<String> model = new DefaultListModel<>();
		fullList.setModel(model);
		fullList.setFont(new Font("新細明體", Font.PLAIN, 15));
		fullPanel.add(fullList);
		
		emptyPanel = new JXTaskPane("空桌");
		emptyPanel.setFont(new Font("新細明體", Font.BOLD, 15));
		emptyPanel.setCollapsed(true);
		JList emptyList = new JList();
		DefaultListModel<String> model1 = new DefaultListModel<>();
		emptyList.setModel(model1);
		emptyList.setFont(new Font("新細明體", Font.PLAIN, 15));
		emptyPanel.add(emptyList);
		
		notEmptyPanel = new JXTaskPane("非空桌(非滿桌)");
		notEmptyPanel.setFont(new Font("新細明體", Font.BOLD, 15));
		notEmptyPanel.setCollapsed(true);
		JList notEmptyList = new JList();
		DefaultListModel<String> model2 = new DefaultListModel<>();
		notEmptyList.setModel(model2);
		notEmptyList.setFont(new Font("新細明體", Font.PLAIN, 15));
		notEmptyPanel.add(notEmptyList);
		
		cleanPanel = new JXTaskPane("乾淨");
		cleanPanel.setFont(new Font("新細明體", Font.BOLD, 15));
		cleanPanel.setCollapsed(true);
		DefaultListModel<String> model3 = new DefaultListModel<>();
		JList cleanList = new JList();
		cleanList.setModel(model3);
		cleanList.setFont(new Font("新細明體", Font.PLAIN, 15));
		cleanPanel.add(cleanList);
		
		dirtyPanel = new JXTaskPane("髒亂");
		dirtyPanel.setFont(new Font("新細明體", Font.BOLD, 15));
		dirtyPanel.setCollapsed(true);
		DefaultListModel<String> model4 = new DefaultListModel<>();
		JList dirtyList = new JList();
		dirtyList.setModel(model4);
		dirtyList.setFont(new Font("新細明體", Font.PLAIN, 15));
		dirtyPanel.add(dirtyList);
		
		listBodyPanel.add(fullPanel);
		listBodyPanel.add(emptyPanel);
		listBodyPanel.add(notEmptyPanel);
		listBodyPanel.add(cleanPanel);
		listBodyPanel.add(dirtyPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		floorTree = new JTree();
		floorTree.setFont(new Font("新細明體", Font.PLAIN, 15));
		DefaultMutableTreeNode root = listAll("餐廳", System.getProperty("user.dir") + System.getProperty("file.separator") + "餐廳");
		DefaultTreeModel model5 = new DefaultTreeModel(root);
		floorTree.setModel(model5);
		mapBodyPanel.setPreferredSize(new Dimension(600, 600));
		mapBodyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		mapBodyPanel.add(panel, BorderLayout.NORTH);
		
		switchButton = new SwitchButton("人");
		panel.add(switchButton);
		
		innerPanel = new JPanel();
		innerPanel.addComponentListener(new SizeEvent());
		innerPanel.addContainerListener(new UnitStateEvent(listBodyPanel));
		mapBodyPanel.add(innerPanel, BorderLayout.CENTER);
		innerPanel.setLayout(null);
		scrollPane.setViewportView(floorTree);
		
		floorTree.addTreeSelectionListener(new MapGenerator(floorTree, innerPanel, switchButton));
		switchButton.addActionListener(new MapGenerator(floorTree, innerPanel, switchButton));
	}
	
	private DefaultMutableTreeNode listAll(String rootName, String rootPath) {
		File root = new File(rootPath);
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(rootName);
		File[] items = root.listFiles();
		for(int i = 0; i < items.length; i ++ ) {
			if(items[i].isDirectory()) {
				node.add(listAll(items[i].getName(), rootPath + System.getProperty("file.separator") + items[i].getName()));
			}
			else {
				node.add(new DefaultMutableTreeNode(items[i].getName()));
			}
		}
		return node;
	}
}
